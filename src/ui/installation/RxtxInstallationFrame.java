/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RxtxInstallationDialog.java
 *
 * Created on Aug 15, 2011, 10:20:59 PM
 */
package ui.installation;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * An installation frame that allows you to choose where
 * to extract RxTx files.
 * @author Parham
 */
public class RxtxInstallationFrame extends javax.swing.JFrame {

    /** Creates new form RxtxInstallationDialog */
    public RxtxInstallationFrame() {
        super();
        initComponents();
        
        //Show the java library paths
        String paths = System.getProperty("java.library.path");
        String[] indivPath = paths.split(";");
        for (String p : indivPath){
            if ((p.contains("Java") || p.contains("java")) && p.contains("Program Files")){
                mTextArea.append(p + "\n");
            }
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mDirectoryLabel = new javax.swing.JLabel();
        mDirectoryTextField = new javax.swing.JTextField();
        mSelectButton = new javax.swing.JButton();
        mCancelButton = new javax.swing.JButton();
        mOkButton = new javax.swing.JButton();
        mInformationLabel = new javax.swing.JLabel();
        mScrollPane = new javax.swing.JScrollPane();
        mTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("RxTx Installation");
        setResizable(false);

        mDirectoryLabel.setText("Installation Directorry:");

        mSelectButton.setText("Select");
        mSelectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSelectButtonActionPerformed(evt);
            }
        });

        mCancelButton.setText("Cancel");
        mCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mCancelButtonActionPerformed(evt);
            }
        });

        mOkButton.setText("OK");
        mOkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mOkButtonActionPerformed(evt);
            }
        });

        mInformationLabel.setText("<html>\nThe installation directory should be the bin directory of the JRE and/or JDK.\n</html>");

        mTextArea.setColumns(20);
        mTextArea.setRows(5);
        mScrollPane.setViewportView(mTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mDirectoryLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mDirectoryTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mSelectButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(mInformationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                        .addComponent(mOkButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mCancelButton))
                    .addComponent(mScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {mCancelButton, mOkButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mDirectoryLabel)
                    .addComponent(mDirectoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mSelectButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(mCancelButton)
                        .addComponent(mOkButton))
                    .addComponent(mInformationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mCancelButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mCancelButtonActionPerformed

    private void mSelectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSelectButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (chooser.showDialog(this, "Select") == JFileChooser.APPROVE_OPTION){
            mDirectoryTextField.setText(chooser.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_mSelectButtonActionPerformed

    private void mOkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mOkButtonActionPerformed
        String dir = mDirectoryTextField.getText();
        if (!dir.equals("") && (new File(dir)).isDirectory()){
            performCopy();
        }
        else {
            JOptionPane.showMessageDialog(this, "The selected directory it not valid. Installation failed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        System.exit(0);
    }//GEN-LAST:event_mOkButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton mCancelButton;
    private javax.swing.JLabel mDirectoryLabel;
    private javax.swing.JTextField mDirectoryTextField;
    private javax.swing.JLabel mInformationLabel;
    private javax.swing.JButton mOkButton;
    private javax.swing.JScrollPane mScrollPane;
    private javax.swing.JButton mSelectButton;
    private javax.swing.JTextArea mTextArea;
    // End of variables declaration//GEN-END:variables

    private void performCopy(){
        //Copy the resource files to the designated directory
        try {
            //Create streams for copying serial file
            InputStream in = this.getClass().getClassLoader().getResourceAsStream("resources/rxtx/rxtxSerial.dll");
            OutputStream out = new FileOutputStream(mDirectoryTextField.getText() + "/rxtxSerial.dll");
            
            //Create copy buffer and copy file
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) > 0){
                out.write(buffer);
            }
            
            //Close streams
            in.close();
            out.close();
            
            //Create streams for copying parallel file            
            in = this.getClass().getClassLoader().getResourceAsStream("resources/rxtx/rxtxParallel.dll");
            out = new FileOutputStream(mDirectoryTextField.getText() + "/rxtxParallel.dll");
            
            //copy file
            while ((len = in.read(buffer)) > 0){
                out.write(buffer);
            }
            
            //close streams and dispose dialog
            in.close();
            out.close();            
            this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(RxtxInstallationFrame.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
