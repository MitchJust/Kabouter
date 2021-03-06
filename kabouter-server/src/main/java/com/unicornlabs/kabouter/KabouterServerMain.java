// <editor-fold defaultstate="collapsed" desc="License">
/*
 * Copyright 2012 Mitchell Just <mitch.just@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// </editor-fold>
package com.unicornlabs.kabouter;

import com.unicornlabs.kabouter.automation.AutomationManager;
import com.unicornlabs.kabouter.clients.ClientManager;
import com.unicornlabs.kabouter.config.ConfigManager;
import com.unicornlabs.kabouter.config.KabouterConstants;
import com.unicornlabs.kabouter.devices.DeviceManager;
import com.unicornlabs.kabouter.gui.GuiManager;
import com.unicornlabs.kabouter.gui.SplashScreen;
import com.unicornlabs.kabouter.gui.debug.DialogErrorHandler;
import com.unicornlabs.kabouter.historian.Historian;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 * KabouterServerMain.java
 *
 * @author Mitchell Just <mitch.just@gmail.com>
 *
 * Description: Kick starter for Server
 */
public class KabouterServerMain {

    private static final Logger LOGGER = Logger.getLogger(KabouterServerMain.class.getName());
    private static boolean NOGUI = false;

    static {
        LOGGER.setLevel(Level.ALL);
    }

    /**
     * Main method for Server
     *
     * @param args input arguments
     */
    public static void main(String[] args) {

        for (String argument : args) {
            if (argument.equalsIgnoreCase("-nogui")) {
                NOGUI = true;
            }
            else {
                System.out.println("Unknown Argument: " + argument);
                System.exit(-1);
            }
        }

        //Display the splash screen

        setGUILookAndFeel();
        SplashScreen mySplashScreen = new SplashScreen();
        mySplashScreen.setTitle(KabouterConstants.FRAME_TITLE);
        //Put it in the middle of the screen and make it visible
        mySplashScreen.setLocationRelativeTo(null);

        mySplashScreen.addText("Starting Kabouter Server...\n");

        if (NOGUI == false) {
            mySplashScreen.setVisible(true);
        }

        try {

            //Setup the Config Manager
            mySplashScreen.addText("Reading Kabouter Config...");
            InputStream myPropertiesStream =
                    KabouterServerMain.class.getResourceAsStream(
                    KabouterConstants.CONFIG_PATH
                    + KabouterConstants.KABOUTER_SERVER_PROPERTIES);
            ConfigManager theConfigManager = new ConfigManager(myPropertiesStream);
            BusinessObjectManager.registerBusinessObject(ConfigManager.class.getName(), theConfigManager);
            mySplashScreen.addText("Done!\n");

            //Setup the Historian
            mySplashScreen.addText("Starting Historian Service...");
            Historian theHistorian = new Historian();
            BusinessObjectManager.registerBusinessObject(Historian.class.getName(), theHistorian);
            mySplashScreen.addText("Done!\n");

            //Setup the Device Manager
            mySplashScreen.addText("Starting Device Manager Service...");
            DeviceManager theDeviceManager = new DeviceManager();
            theDeviceManager.startServer();
            BusinessObjectManager.registerBusinessObject(DeviceManager.class.getName(), theDeviceManager);
            mySplashScreen.addText("Done!\n");

            //Setup the Client Manager
            mySplashScreen.addText("Starting Client Manager Service...");
            ClientManager theClientManager = new ClientManager();
            theClientManager.startServer();
            BusinessObjectManager.registerBusinessObject(ClientManager.class.getName(), theClientManager);
            mySplashScreen.addText("Done!\n");

            //Setup the Automation Manager
            mySplashScreen.addText("Starting Automation Manager Service...");
            AutomationManager theAutomationManager = new AutomationManager();
            theDeviceManager.addDeviceEventListener(theAutomationManager);
            BusinessObjectManager.registerBusinessObject(AutomationManager.class.getName(), theAutomationManager);
            mySplashScreen.addText("Done!\n");

            //Start the GUI Manager in the Swing Initializer Thread
            if (NOGUI == false) {
                mySplashScreen.addText("Starting GUI Manager...");

                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        GuiManager theGuiManager = new GuiManager();
                        BusinessObjectManager.registerBusinessObject(GuiManager.class.getName(), theGuiManager);
                        theGuiManager.initalize();
                    }
                });
                mySplashScreen.addText("Done!\n");
            }

            //Finished loading all components
            mySplashScreen.dispose();

        } catch (Exception ex) {
            mySplashScreen.addText("\n\nException In Startup: \n" + ex);
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Sets up the logger for the entire application
     *
     * @throws IOException
     */
    public static void configureLogging() throws IOException {
        //Read the logging config file
        String propertiesPath = KabouterConstants.CONFIG_PATH + KabouterConstants.LOGGING_PROPERTIES;
        InputStream loggingProperties = KabouterServerMain.class.getResourceAsStream(propertiesPath);
        LogManager.getLogManager().readConfiguration(loggingProperties);

        Logger rootLogger = Logger.getLogger("");
        //Add a popup handler for severe messages
        rootLogger.addHandler(new DialogErrorHandler());

    }

    /**
     * Set the look and feel to nimbus
     */
    public static void setGUILookAndFeel() {

        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                try {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                } catch (Exception ex) {
                    LOGGER.log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    /**
     * Sets up the home directory to store logs
     *
     * @return
     */
    public static boolean setupAppDirectory() {
        File myAppDirectory = new File(KabouterConstants.APP_DIRECTORY);
        if (myAppDirectory.exists()) {
            return true;
        } else {
            boolean success = myAppDirectory.mkdir();
            if (!success) {
                System.err.println("Unable to create directory: " + myAppDirectory);
            }
            return success;
        }
    }
}
