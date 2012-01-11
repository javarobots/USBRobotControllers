/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepad.common;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Parham
 */
public class GamepadThread implements Runnable {
    
    private boolean mStopThread = false;
    private ControllerModel mModel;

    public GamepadThread(ControllerModel model){
        mModel = model;
    }
    
    @Override
    @SuppressWarnings("SleepWhileInLoop")
    public void run() {
        while (!mStopThread){
            try {
                System.out.println("Thread running");
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                Logger.getLogger(GamepadThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void stopThread(boolean b){
        mStopThread = b;
    }
    
}
