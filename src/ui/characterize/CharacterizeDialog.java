/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CharacterizeDialog.java
 *
 * Created on Jan 7, 2012, 10:40:10 PM
 */
package ui.characterize;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import net.java.games.input.Component;
import net.java.games.input.Controller;
import util.jinput.JinputUtilities;

/**
 * A dialog class that can be opened to characterize and
 * unknown USB controller. This allows the user to see
 * what components the controller has as well as its output
 * values
 * @author Parham
 */
public class CharacterizeDialog extends javax.swing.JDialog {
    
    private Map<String,Controller> nameToControllerMap;
    private CharacterizeThread mCharacterizeThread;

    /** Creates new form CharacterizeDialog */
    public CharacterizeDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        initGamepads();
        mGamepadTable.setModel(new CharacterizeTableModel());
        
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                if (mCharacterizeThread != null){
                    mCharacterizeThread.stopThread(true);
                }
            }
        });        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mGamepadLabel = new javax.swing.JLabel();
        mGamepadComboBox = new javax.swing.JComboBox();
        mCharacterizeButton = new javax.swing.JButton();
        mScrollPane = new javax.swing.JScrollPane();
        mGamepadTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        mGamepadLabel.setText("Gamepad:");

        mCharacterizeButton.setText("Characterize");
        mCharacterizeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mCharacterizeButtonActionPerformed(evt);
            }
        });

        mGamepadTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Component", "Value"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        mScrollPane.setViewportView(mGamepadTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mGamepadLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mGamepadComboBox, 0, 325, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mCharacterizeButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mGamepadLabel)
                    .addComponent(mGamepadComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mCharacterizeButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mCharacterizeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mCharacterizeButtonActionPerformed
        Controller c = nameToControllerMap.get(mGamepadComboBox.getSelectedItem().toString());
        Component[] components = c.getComponents();
        for (Component cmp : components){
            ((CharacterizeTableModel)mGamepadTable.getModel()).addControllerComponent(cmp);
        }
        mCharacterizeThread = new CharacterizeThread(c, (CharacterizeTableModel)mGamepadTable.getModel());
        Thread t = new Thread(mCharacterizeThread);
        t.start();
    }//GEN-LAST:event_mCharacterizeButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton mCharacterizeButton;
    private javax.swing.JComboBox mGamepadComboBox;
    private javax.swing.JLabel mGamepadLabel;
    private javax.swing.JTable mGamepadTable;
    private javax.swing.JScrollPane mScrollPane;
    // End of variables declaration//GEN-END:variables

    private void initGamepads() {
        nameToControllerMap = new HashMap<>();
        List<Controller> controllers = JinputUtilities.availableGamepads();
        for (Controller c : controllers){
            if (c.getType() == Controller.Type.GAMEPAD){
                nameToControllerMap.put(c.getName(), c);
            }
        }
        String[] values = nameToControllerMap.keySet().toArray(new String[0]);
        mGamepadComboBox.setModel(new DefaultComboBoxModel(values));
    }
}
