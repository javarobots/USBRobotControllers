/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.characterize;

import net.java.games.input.Component;
import net.java.games.input.Controller;

/**
 * A thread that runs collecting raw data from the
 * USB controller
 * @author Parham
 */
public class CharacterizeThread implements Runnable {

    private Controller mController;
    private CharacterizeTableModel mTableModel;
    private boolean mThreadStop = false;
    
    
    public CharacterizeThread(Controller controller, CharacterizeTableModel tableModel){
        mController = controller;
        mTableModel = tableModel;
    }
    
    @Override
    public void run() {
        while (!mThreadStop){
            mController.poll();
            for (Component c : mController.getComponents()){
                int tableRow = mTableModel.getComponentRow(c.getName());
                mTableModel.setValueAt(c.getPollData(), tableRow, 1);
            }
        }
        System.out.println("Characterize thread stopped.");
    }
    
    /**
     * Stop the thread from running
     * @param b - true to stop the thread
     */
    public void stopThread(boolean b){
        mThreadStop = b;
    }
    
}
