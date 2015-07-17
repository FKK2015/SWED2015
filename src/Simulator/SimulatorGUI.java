/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


 
 
public class SimulatorGUI extends javax.swing.JFrame {

    Simulator mySim = new Simulator();
    
    public SimulatorGUI() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Start = new javax.swing.JButton();
        Statistics = new javax.swing.JButton();
        inputDur = new javax.swing.JTextField();
        labelDur = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        filename = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        waitingTime = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        idleTime = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        floor1Users = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        floor2Users = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        totalUsers = new javax.swing.JTextArea();
        filenameLabel = new javax.swing.JLabel();
        waitingTimeLabel = new javax.swing.JLabel();
        floor1UsersLabel = new javax.swing.JLabel();
        floor2UsersLabel = new javax.swing.JLabel();
        idelTimeLabel = new javax.swing.JLabel();
        totalUsersLabel = new javax.swing.JLabel();
        inputDurSec = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lift Simulator 1.0");

        Start.setText("Start");
        Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartActionPerformed(evt);
            }
        });

        Statistics.setText("Statistics");
        Statistics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatisticsActionPerformed(evt);
            }
        });

        labelDur.setText("Duration [min]");

        filename.setColumns(20);
        filename.setRows(5);
        jScrollPane1.setViewportView(filename);

        waitingTime.setColumns(20);
        waitingTime.setRows(5);
        waitingTime.setPreferredSize(new java.awt.Dimension(104, 30));
        jScrollPane2.setViewportView(waitingTime);

        idleTime.setColumns(20);
        idleTime.setRows(5);
        idleTime.setPreferredSize(new java.awt.Dimension(104, 30));
        jScrollPane3.setViewportView(idleTime);

        floor1Users.setColumns(20);
        floor1Users.setRows(5);
        floor1Users.setPreferredSize(new java.awt.Dimension(104, 30));
        jScrollPane4.setViewportView(floor1Users);

        floor2Users.setColumns(20);
        floor2Users.setRows(5);
        floor2Users.setPreferredSize(new java.awt.Dimension(104, 30));
        jScrollPane5.setViewportView(floor2Users);

        totalUsers.setColumns(20);
        totalUsers.setRows(5);
        totalUsers.setPreferredSize(new java.awt.Dimension(104, 30));
        jScrollPane6.setViewportView(totalUsers);

        filenameLabel.setText("File Name");

        waitingTimeLabel.setText("Avg Waiting");

        floor1UsersLabel.setText("Users on F1");

        floor2UsersLabel.setText("Users on F2");

        idelTimeLabel.setText("Idle Time");

        totalUsersLabel.setText("Total Users");

        inputDurSec.setText("Duration [sec]");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Statistics)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(filenameLabel)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(waitingTimeLabel)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(idelTimeLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(floor1UsersLabel)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(floor2UsersLabel)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalUsersLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Start)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputDur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelDur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(inputDurSec)))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Start, Statistics});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {inputDur, inputDurSec, labelDur});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {floor1UsersLabel, floor2UsersLabel, idelTimeLabel, jScrollPane2, jScrollPane3, jScrollPane4, jScrollPane5, jScrollPane6, totalUsersLabel, waitingTimeLabel});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Start)
                    .addComponent(inputDur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDur)
                    .addComponent(inputDurSec))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Statistics)
                    .addComponent(filenameLabel)
                    .addComponent(waitingTimeLabel)
                    .addComponent(floor1UsersLabel)
                    .addComponent(idelTimeLabel)
                    .addComponent(totalUsersLabel)
                    .addComponent(floor2UsersLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartActionPerformed
        try {
            float dur = Float.parseFloat(inputDur.getText());
            int durSec = Math.round(dur*60);
            inputDurSec.setText(String.valueOf(durSec)+" sec");
            mySim.run(durSec);
        } catch (IOException ex) {
            Logger.getLogger(SimulatorGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_StartActionPerformed

    private void StatisticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StatisticsActionPerformed
        final JFileChooser fc = new JFileChooser("C:/Users/Kris/Documents/NetBeansProjects/Simulator");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV & TXT","csv", "txt");
        fc.setFileFilter(filter);
        int returnVal = fc.showOpenDialog(Statistics);
        File stats = fc.getSelectedFile();
        try {
            BufferedReader br = new BufferedReader(new FileReader(stats));
            String line;
            while((line = br.readLine()) != null){
                String[] parsed = line.split(",");
                filename.append(parsed[0]+"\n");
                float tmp = Float.valueOf(parsed[1]);
                tmp = (float)(Math.round(tmp*1000))/1000;
                waitingTime.append(String.valueOf(tmp)+"\n");
                idleTime.append(parsed[2]+"\n");
                floor1Users.append(parsed[3]+"\n");
                floor2Users.append(parsed[4]+"\n");
                totalUsers.append(parsed[5]+"\n");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SimulatorGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SimulatorGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_StatisticsActionPerformed

    
    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SimulatorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimulatorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimulatorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimulatorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SimulatorGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Start;
    private javax.swing.JButton Statistics;
    private javax.swing.JTextArea filename;
    private javax.swing.JLabel filenameLabel;
    private javax.swing.JTextArea floor1Users;
    private javax.swing.JLabel floor1UsersLabel;
    private javax.swing.JTextArea floor2Users;
    private javax.swing.JLabel floor2UsersLabel;
    private javax.swing.JLabel idelTimeLabel;
    private javax.swing.JTextArea idleTime;
    private javax.swing.JTextField inputDur;
    private javax.swing.JLabel inputDurSec;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel labelDur;
    private javax.swing.JTextArea totalUsers;
    private javax.swing.JLabel totalUsersLabel;
    private javax.swing.JTextArea waitingTime;
    private javax.swing.JLabel waitingTimeLabel;
    // End of variables declaration//GEN-END:variables
}