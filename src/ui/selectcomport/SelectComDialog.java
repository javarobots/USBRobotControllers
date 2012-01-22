/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.selectcomport;

import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultComboBoxModel;
import ui.USBRobotGamepadAppModel;

/**
 *
 * @author jparham
 */
public class SelectComDialog extends javax.swing.JDialog implements Observer {

    private SelectComDialogController mController;
    private USBRobotGamepadAppModel mApplicationModel;

    /**
     * Creates new form SelectComDialog
     */
    @SuppressWarnings("LeakingThisInConstructor")
    public SelectComDialog(java.awt.Frame parent, boolean modal, USBRobotGamepadAppModel applicationModel) {
        super(parent, modal);
        initComponents();
        mApplicationModel = applicationModel;
        SelectComDialogModel m = new SelectComDialogModel(this);
        m.addObserver(this);
        m.notifyObservers();
        mController = new SelectComDialogController(m);
        mBaudComboBox.setSelectedItem(Integer.toString(mApplicationModel.getBaudRate()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mComportLabel = new javax.swing.JLabel();
        mSerialPortComboBox = new javax.swing.JComboBox();
        mCancelButton = new javax.swing.JButton();
        mOkButton = new javax.swing.JButton();
        mBaudRateLabel = new javax.swing.JLabel();
        mBaudComboBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Select COM Port");

        mComportLabel.setText("COM Port:");

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

        mBaudRateLabel.setText("Baud Rate:");

        mBaudComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2400", "4800", "9600", "19200", "38400", "57600", "115200", " " }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mComportLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mSerialPortComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(mBaudRateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mBaudComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(mOkButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mCancelButton)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {mCancelButton, mOkButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mComportLabel)
                    .addComponent(mSerialPortComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mBaudRateLabel)
                    .addComponent(mBaudComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mCancelButton)
                    .addComponent(mOkButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mCancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_mCancelButtonActionPerformed

    private void mOkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mOkButtonActionPerformed
        String selectedPortName = mSerialPortComboBox.getSelectedItem().toString();
        mController.saveSelectedPort(selectedPortName,mBaudComboBox.getSelectedItem());
        mApplicationModel.setSelectedComPortName(selectedPortName);
        mApplicationModel.setBaudRate(Integer.parseInt(mBaudComboBox.getSelectedItem().toString()));
        mApplicationModel.setSerialportSelected(true);
        mApplicationModel.notifyObservers();
        this.dispose();
    }//GEN-LAST:event_mOkButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox mBaudComboBox;
    private javax.swing.JLabel mBaudRateLabel;
    private javax.swing.JButton mCancelButton;
    private javax.swing.JLabel mComportLabel;
    private javax.swing.JButton mOkButton;
    private javax.swing.JComboBox mSerialPortComboBox;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object o1) {
        if (o instanceof SelectComDialogModel){
            SelectComDialogModel model = (SelectComDialogModel) o;
            mSerialPortComboBox.setModel(new DefaultComboBoxModel(model.getmAvailableComPorts().toArray(new String[0])));
            if (mApplicationModel.isSerialportSelected()){
                mSerialPortComboBox.getModel().setSelectedItem(mApplicationModel.getSelectedComPortName());
            }
        }
    }
}
