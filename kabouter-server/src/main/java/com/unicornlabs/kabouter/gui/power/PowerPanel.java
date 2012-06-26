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
package com.unicornlabs.kabouter.gui.power;

import com.unicornlabs.kabouter.BusinessObjectManager;
import com.unicornlabs.kabouter.historian.Historian;
import com.unicornlabs.kabouter.historian.data_objects.Powerlog;
import java.awt.Cursor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Mitch
 */
public class PowerPanel extends javax.swing.JPanel {

    private static final Logger LOGGER = Logger.getLogger(PowerPanel.class.getName());
    private static final int MAX_DATA_POINTS = 1000;

    static {
        LOGGER.setLevel(Level.ALL);
    }
    public static final String TOTAL_POWER = "Total";

    /**
     * Creates new form PowerPanel
     */
    public PowerPanel() {
        initComponents();
    }
    private JFreeChart myChart;
    private XYSeries powerSeries;
    private XYSeriesCollection dataset;

    public void updateDeviceList() {
        deviceComboBox.setEnabled(false);
        deviceComboBox.removeAllItems();

        deviceComboBox.addItem(TOTAL_POWER);

        Historian theHistorian = (Historian) BusinessObjectManager.getBusinessObject(Historian.class.getName());
        ArrayList<String> powerLogDeviceIds = theHistorian.getPowerLogDeviceIds();

        Collections.sort(powerLogDeviceIds);

        for (String s : powerLogDeviceIds) {
            deviceComboBox.addItem(s);
        }

        deviceComboBox.setSelectedIndex(0);
        deviceComboBox.setEnabled(true);
    }

    public String getSelectedDevice() {
        return (String) deviceComboBox.getSelectedItem();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        deviceComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        chartPanel = new ChartPanel(myChart);
        startDateChooser = new com.toedter.calendar.JDateChooser(new Date());
        jLabel2 = new javax.swing.JLabel();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, -6);
        startTimeSpinner = new com.unicornlabs.kabouter.gui.components.JTimeSpinner(cal.getTime());
        endDateChooser = new com.toedter.calendar.JDateChooser(new Date());
        endTimeSpinner = new com.unicornlabs.kabouter.gui.components.JTimeSpinner();
        jLabel3 = new javax.swing.JLabel();
        applyButton = new javax.swing.JButton();

        deviceComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deviceComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("Device ID:");

        chartPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout chartPanelLayout = new javax.swing.GroupLayout(chartPanel);
        chartPanel.setLayout(chartPanelLayout);
        chartPanelLayout.setHorizontalGroup(
            chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        chartPanelLayout.setVerticalGroup(
            chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 407, Short.MAX_VALUE)
        );

        jLabel2.setText("Graph Start Date:");

        jLabel3.setText("Graph End Date:");

        applyButton.setText("Apply");
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(15, 15, 15)
                                .addComponent(deviceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(startTimeSpinner, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(startDateChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 452, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(endTimeSpinner, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(endDateChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(applyButton, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startTimeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deviceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(applyButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(endTimeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(endDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deviceComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deviceComboBoxActionPerformed
    }//GEN-LAST:event_deviceComboBoxActionPerformed

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed

        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

        Calendar cal = Calendar.getInstance();
        cal.setTime((Date) startTimeSpinner.getValue());

        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);

        cal.setTime(startDateChooser.getDate());

        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, min);
        cal.set(Calendar.SECOND, sec);

        Date start = cal.getTime();

        cal.setTime((Date) endTimeSpinner.getValue());

        hour = cal.get(Calendar.HOUR_OF_DAY);
        min = cal.get(Calendar.MINUTE);
        sec = cal.get(Calendar.SECOND);

        cal.setTime(endDateChooser.getDate());

        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, min);
        cal.set(Calendar.SECOND, sec);

        Date end = cal.getTime();

        System.out.println("start = " + start);
        System.out.println("end = " + end);

        String graphfocus = (String) deviceComboBox.getSelectedItem();

        updateChart(graphfocus, start, end);

        setCursor(Cursor.getDefaultCursor());

    }//GEN-LAST:event_applyButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyButton;
    private javax.swing.JPanel chartPanel;
    private javax.swing.JComboBox deviceComboBox;
    private com.toedter.calendar.JDateChooser endDateChooser;
    private com.unicornlabs.kabouter.gui.components.JTimeSpinner endTimeSpinner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private com.toedter.calendar.JDateChooser startDateChooser;
    private com.unicornlabs.kabouter.gui.components.JTimeSpinner startTimeSpinner;
    // End of variables declaration//GEN-END:variables

    public void handleNewPowerLog(Powerlog newLog) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    //TODO fix this to actually work - Consider live case
    public void updateChart(String focus, Date start, Date end) {
        Historian theHistorian = (Historian) BusinessObjectManager.getBusinessObject(Historian.class.getName());
        ArrayList<Powerlog> powerlogs;

        powerSeries = new XYSeries("First");
        dataset = new XYSeriesCollection(powerSeries);

        LOGGER.log(Level.INFO, "Obtaining all power logs for {0}", focus);
        powerlogs = theHistorian.getPowerlogs(focus, start, end);

        LOGGER.log(Level.INFO, "Got {0} Power Logs", powerlogs.size());
        for (Powerlog p : powerlogs) {
            powerSeries.add(p.getId().getLogtime().getTime(), p.getPower());
        }


        LOGGER.log(Level.INFO, "Added {0} Data Items", powerSeries.getItemCount());

        myChart = ChartFactory.createXYLineChart("Power Usage For " + focus, "Date", "Power", dataset, PlotOrientation.VERTICAL, true, true, true);

        ((ChartPanel) chartPanel).setChart(myChart);
    }
}
