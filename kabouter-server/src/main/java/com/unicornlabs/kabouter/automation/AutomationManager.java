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
package com.unicornlabs.kabouter.automation;

import com.unicornlabs.kabouter.BusinessObjectManager;
import com.unicornlabs.kabouter.devices.DeviceInfo;
import com.unicornlabs.kabouter.devices.DeviceManager;
import com.unicornlabs.kabouter.historian.Historian;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * AutomationManager.java
 *
 * @author Mitchell Just <mitch.just@gmail.com>
 *
 * Description: Controls the automation features
 */
public class AutomationManager {

    private static final Logger LOGGER = Logger.getLogger(AutomationManager.class.getName());

    static {
        LOGGER.setLevel(Level.ALL);
    }
    
    private DeviceManager theDeviceManager;
    private Historian theHistorian;
    
    public AutomationManager() {
        theDeviceManager = (DeviceManager) BusinessObjectManager.getBusinessObject(DeviceManager.class.getName());
        theHistorian = (Historian) BusinessObjectManager.getBusinessObject(Historian.class.getName());
    }
    
    public void forceIOState(String deviceId, int ioNum, int value) {
        DeviceInfo di = theDeviceManager.getDeviceInfo(deviceId);
        
        if(di == null) {
            LOGGER.log(Level.SEVERE, "Invalid Device ID specified in IO Override: {0}", deviceId);
            return;
        }
        
        di.ioStates[ioNum] = value;
        
        theDeviceManager.updateDeviceIOState(di);
    }
    
}
