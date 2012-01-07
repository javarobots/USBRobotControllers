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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Parham
 */
public class JinputInstallationFrame extends javax.swing.JFrame {

    /** Creates new form RxtxInstallationDialog */
    public JinputInstallationFrame() {
        super();
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bitButtonGroup = new javax.swing.ButtonGroup();
        directoryLabel = new javax.swing.JLabel();
        directoryTextField = new javax.swing.JTextField();
        selectButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        radioButton_32Bit = new javax.swing.JRadioButton();
        radioButton_64Bit = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("JInput Installation");
        setResizable(false);

        directoryLabel.setText("Installation Directorry:");

        selectButton.setText("Select");
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("<html>\nThe installation directory should be the bin directory of the JRE and/or JDK.\n</html>");

        bitButtonGroup.add(radioButton_32Bit);
        radioButton_32Bit.setSelected(true);
        radioButton_32Bit.setText("32 Bit");

        bitButtonGroup.add(radioButton_64Bit);
        radioButton_64Bit.setText("64 Bit");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radioButton_32Bit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioButton_64Bit))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(directoryLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(directoryTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                        .addComponent(okButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelButton, okButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(directoryLabel)
                    .addComponent(directoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioButton_32Bit)
                    .addComponent(radioButton_64Bit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cancelButton)
                        .addComponent(okButton))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (chooser.showDialog(this, "Select") == JFileChooser.APPROVE_OPTION){
            directoryTextField.setText(chooser.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_selectButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        String dir = directoryTextField.getText();
        if (!dir.equals("") && (new File(dir)).isDirectory()){
            performCopy();
        }
        else {
            JOptionPane.showMessageDialog(this, "The selected directory it not valid. Installation failed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        System.exit(0);
    }//GEN-LAST:event_okButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bitButtonGroup;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel directoryLabel;
    private javax.swing.JTextField directoryTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton okButton;
    private javax.swing.JRadioButton radioButton_32Bit;
    private javax.swing.JRadioButton radioButton_64Bit;
    private javax.swing.JButton selectButton;
    // End of variables declaration//GEN-END:variables

    private void performCopy(){
        
        String[] bitFiles_32 = {"jinput-dx8.dll","jinput-raw.dll","jinput-wintab.dll"};
        String[] bitFiles_64 = {"jinput-dx8_64.dll","jinput-raw_64.dll","jinput-wintab.dll"};
        
        
        //Copy the resource files to the designated directory
        try {
            
            if (radioButton_32Bit.isSelected()){
                for (String s : bitFiles_32){
                    //Create streams for copying serial file
                    InputStream in = this.getClass().getClassLoader().getResourceAsStream("resources/jinput/" + s);
                    OutputStream out = new FileOutputStream(directoryTextField.getText() + "/" + s);

                    //Create copy buffer and copy file
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = in.read(buffer)) > 0){
                        out.write(buffer);
                    }

                    //Close streams
                    in.close();
                    out.close();
                }
            }
            else {
                for (String s : bitFiles_64){
                    //Create streams for copying serial file
                    InputStream in = this.getClass().getClassLoader().getResourceAsStream("resources/jinput/" + s);
                    OutputStream out = new FileOutputStream(directoryTextField.getText() + "/" + s);

                    //Create copy buffer and copy file
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = in.read(buffer)) > 0){
                        out.write(buffer);
                    }

                    //Close streams
                    in.close();
                    out.close();
                }
            }
                   
            this.dispose();
            
        } catch (IOException ex) {
            Logger.getLogger(JinputInstallationFrame.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}