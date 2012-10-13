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
package com.unicornlabs.kabouter.gui.devices;

import com.unicornlabs.kabouter.BusinessObjectManager;
import com.unicornlabs.kabouter.devices.DeviceManager;
import com.unicornlabs.kabouter.devices.DeviceStatus;
import com.unicornlabs.kabouter.historian.data_objects.Device;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Mitchell Just <mitch.just@gmail.com>
 */
public class DeviceInfoPanel extends javax.swing.JPanel {

    private DeviceManager theDeviceManager;
    private DeviceStatus selectedDeviceStatus;
    private DevicesPanel myParent;

    /**
     * Creates new form DeviceInfoPanel
     */
    public DeviceInfoPanel(DevicesPanel parent) {
        this.myParent = parent;
        initComponents();
        theDeviceManager = (DeviceManager) BusinessObjectManager.getBusinessObject(DeviceManager.class.getName());
    }

    public void setSelectedDevice(DeviceStatus d) {
        selectedDeviceStatus = d;
        updateFields();
    }

    public void updateFields() {
        if (selectedDeviceStatus != null) {
            this.deviceIdField.setText(selectedDeviceStatus.theDevice.getId());
            this.deviceNameField.setText(selectedDeviceStatus.theDevice.getDisplayname());
            this.deviceIpField.setText(selectedDeviceStatus.theDevice.getIpaddress());
            this.deviceTypeField.setText(selectedDeviceStatus.theDevice.getType());
            this.jCheckBox1.setSelected(selectedDeviceStatus.isConnected);
            updateIoNames(selectedDeviceStatus.theDevice);
        } else {
            this.deviceIdField.setText("");
            this.deviceNameField.setText("");
            this.deviceIpField.setText("");
            this.deviceTypeField.setText("");
            this.jCheckBox1.setSelected(false);
            ioComboBox.removeAllItems();
            ioSetValueField.setText("");
        }
    }

    private void updateIoNames(Device theDevice) {
        ioComboBox.removeAllItems();
        List<String> iodirections = theDevice.getIodirections();
        List<String> ionames = theDevice.getIonames();
        
        for(int i=0;i<ionames.size();i++) {
            if(iodirections.get(i).contentEquals("output")) {
                ioComboBox.addItem(ionames.get(i));
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        deviceIpField = new javax.swing.JTextField();
        deviceTypeField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        deviceNameField = new javax.swing.JTextField();
        deviceIdField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        ioComboBox = new javax.swing.JComboBox();
        ioSetValueField = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jLabel4.setText("Device IP:");

        deviceIpField.setEditable(false);

        deviceTypeField.setEditable(false);

        jLabel3.setText("Device Type:");

        jLabel2.setText("Device Name:");

        deviceNameField.setEditable(false);

        deviceIdField.setEditable(false);

        jLabel5.setText("Device ID:");

        jLabel6.setText("Connected:");

        jCheckBox1.setEnabled(false);

        ioComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ioSetValueField.setText("0");

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Set I/O:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deviceTypeField, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deviceIpField, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(deviceNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(87, 87, 87))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(deviceIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(ioComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ioSetValueField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateButton))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(deviceIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ioComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ioSetValueField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(deviceNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(deviceTypeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(deviceIpField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(jCheckBox1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        if(!selectedDeviceStatus.isConnected) {
            JOptionPane.showMessageDialog(this, "Device must be connected to set I/O State.");
            return;
        }
        try {
            String ioName = (String) ioComboBox.getSelectedItem();
            double value = Double.parseDouble(ioSetValueField.getText());
            selectedDeviceStatus.tcpChannel.write(ioName+":"+value);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Exception Caught:\n"+e);
        }
    }//GEN-LAST:event_updateButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField deviceIdField;
    private javax.swing.JTextField deviceIpField;
    private javax.swing.JTextField deviceNameField;
    private javax.swing.JTextField deviceTypeField;
    private javax.swing.JComboBox ioComboBox;
    private javax.swing.JTextField ioSetValueField;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
