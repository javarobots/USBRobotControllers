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

import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.Controller.Type;
import net.java.games.input.ControllerEnvironment;

/**
 *
 * @author Parham
 */
public class CharacterizeDialog extends javax.swing.JDialog {
    
    private Map<String,Controller> nameToControllerMap;

    /** Creates new form CharacterizeDialog */
    public CharacterizeDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        initGamepads();
        gamepadTable.setModel(new CharacterizeTableModel());
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gamepadLabel = new javax.swing.JLabel();
        gamepadComboBox = new javax.swing.JComboBox();
        characterizeButton = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        gamepadTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        gamepadLabel.setText("Gamepad:");

        characterizeButton.setText("Characterize");
        characterizeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                characterizeButtonActionPerformed(evt);
            }
        });

        gamepadTable.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollPane.setViewportView(gamepadTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gamepadLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gamepadComboBox, 0, 325, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(characterizeButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gamepadLabel)
                    .addComponent(gamepadComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(characterizeButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void characterizeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_characterizeButtonActionPerformed
        Controller c = nameToControllerMap.get(gamepadComboBox.getSelectedItem().toString());
        Component[] components = c.getComponents();
        for (Component cmp : components){
            ((CharacterizeTableModel)gamepadTable.getModel()).addControllerComponent(cmp);
        }
    }//GEN-LAST:event_characterizeButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton characterizeButton;
    private javax.swing.JComboBox gamepadComboBox;
    private javax.swing.JLabel gamepadLabel;
    private javax.swing.JTable gamepadTable;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables

    private void initGamepads() {
        nameToControllerMap = new HashMap<String,Controller>();
        ControllerEnvironment env = ControllerEnvironment.getDefaultEnvironment();
        Controller[] controllers = env.getControllers();
        for (Controller c : controllers){
            if (c.getType() == Type.GAMEPAD){
                nameToControllerMap.put(c.getName(), c);
            }
        }
        gamepadComboBox.setModel(new DefaultComboBoxModel(nameToControllerMap.keySet().toArray(new String[0])));
    }
}
