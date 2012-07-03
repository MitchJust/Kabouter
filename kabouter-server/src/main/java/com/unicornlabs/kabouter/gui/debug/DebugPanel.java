/*
 * Copyright 2012 Mitch.
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
package com.unicornlabs.kabouter.gui.debug;

import com.unicornlabs.kabouter.BusinessObjectManager;
import com.unicornlabs.kabouter.devices.DeviceManager;
import com.unicornlabs.kabouter.historian.Historian;
import com.unicornlabs.kabouter.historian.data_objects.Device;
import com.unicornlabs.kabouter.historian.data_objects.Powerlog;
import com.unicornlabs.kabouter.historian.data_objects.PowerlogId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mitch
 */
public class DebugPanel extends javax.swing.JPanel {

    private static final Logger LOGGER = Logger.getLogger(DebugPanel.class.getName());

    static {
        LOGGER.setLevel(Level.ALL);
    }
    
    /**
     * Creates new form DebugPanel
     */
    public DebugPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        historianDataButton = new javax.swing.JButton();
        historianDataDeviceIdTextField = new javax.swing.JTextField();
        historianDataEntriesTextField = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        clearDevicesButton = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Historian Tools", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.black));

        jLabel1.setText("Create Historian Data");

        jLabel2.setText("Device ID:");

        jLabel3.setText("Entries:");

        historianDataButton.setText("Create Data");
        historianDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historianDataButtonActionPerformed(evt);
            }
        });

        historianDataDeviceIdTextField.setText("Test Device");

        historianDataEntriesTextField.setText("0");

        clearDevicesButton.setText("Clear All Devices");
        clearDevicesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearDevicesButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(historianDataDeviceIdTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                    .addComponent(historianDataEntriesTextField))
                                .addGap(18, 18, 18)
                                .addComponent(historianDataButton))
                            .addComponent(clearDevicesButton)
                            .addComponent(jLabel1))
                        .addGap(0, 422, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(historianDataDeviceIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(historianDataEntriesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(historianDataButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clearDevicesButton)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(347, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void historianDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historianDataButtonActionPerformed
        try {
            this.setEnabled(false);
            int entries = Integer.parseInt(historianDataEntriesTextField.getText());
            String deviceId = historianDataDeviceIdTextField.getText();
            Historian theHistorian = (Historian) BusinessObjectManager.getBusinessObject(Historian.class.getName());
            DeviceManager theDeviceManager = (DeviceManager) BusinessObjectManager.getBusinessObject(DeviceManager.class.getName());
            
            Calendar theCalendar = Calendar.getInstance();
            
            Device newDevice = new Device(deviceId, "1.1.1.1");
            newDevice.setNumio(0);
            
            
            //theDeviceManager.insertNewDevice(newDevice);
            
            Random r = new Random(); 
            ArrayList<Powerlog> powerlogs = new ArrayList<Powerlog>();
            
            LOGGER.info("Generating Logs...");
            
            int count = 0;
            int currentSectionLength = r.nextInt(100);
            float setPoint = r.nextFloat() * (float)r.nextInt(1000);
            
            for(int pass =0; pass<entries; pass++) {
                powerlogs.clear();
                for(int i=0;i<1000;i++) {

                    if(count >= currentSectionLength) {
                        currentSectionLength = r.nextInt(60*60*4);
                        count = 0;
                        setPoint = r.nextFloat() * (float)r.nextInt(1000);
                    }

                    double d = setPoint+r.nextDouble()*100;
                    PowerlogId id = new PowerlogId(theCalendar.getTime(), deviceId);
                    Powerlog log = new Powerlog(id, d);
                    powerlogs.add(log);
                    theCalendar.add(Calendar.MINUTE, -1);
                }
                LOGGER.log(Level.INFO, "Sending Logs To Historian '{'Pass {0}'}'", pass);
            
                theHistorian.savePowerlogs(powerlogs);
            }
            
            
            
            JOptionPane.showMessageDialog(this, "Added " + entries + " new entries","Complete",JOptionPane.INFORMATION_MESSAGE);
            
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Invalid Entries", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        this.setEnabled(true);

    }//GEN-LAST:event_historianDataButtonActionPerformed

    private void clearDevicesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearDevicesButtonActionPerformed
        int showConfirmDialog = JOptionPane.showConfirmDialog(this, "Really Delete All Device Logs?", "Confirmation", JOptionPane.OK_CANCEL_OPTION);
        
        if(showConfirmDialog == JOptionPane.CANCEL_OPTION) {
            return;
        }
        
        Historian theHistorian = (Historian) BusinessObjectManager.getBusinessObject(Historian.class.getName());
        ArrayList<Device> devices = theHistorian.getDevices();
        for(Device d : devices) {
            theHistorian.deleteDevice(d);
        }
    }//GEN-LAST:event_clearDevicesButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearDevicesButton;
    private javax.swing.JButton historianDataButton;
    private javax.swing.JTextField historianDataDeviceIdTextField;
    private javax.swing.JTextField historianDataEntriesTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
