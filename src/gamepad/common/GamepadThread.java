/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepad.common;

import gnu.io.SerialPort;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.USBRobotGamepadAppModel;
import ui.dialog.ErrorDialog;
import util.rxtx.RxTxUtilities;

/**
 * A Thread that runs continuously generating the
 * joystick command string
 * @author Parham
 */
public class GamepadThread implements Runnable {

    private boolean mStopThread = false;
    private ControllerModel mModel;
    private USBRobotGamepadAppModel mApplicationModel;

    public GamepadThread(ControllerModel model){
        mModel = model;
    }

    @Override
    @SuppressWarnings("SleepWhileInLoop")
    public void run() {
        OutputStream out = null;
        try {
            //Open up the port to send from
            SerialPort port = RxTxUtilities.openPortByName(mApplicationModel.getSelectedComPortName());
            out = port.getOutputStream();
            while (!mStopThread){
                try {
                    String cmd = mModel.generateCommand();
                    byte[] cmdAsBytes = cmd.getBytes();
                    out.write(cmdAsBytes);
                    mApplicationModel.setCommandString(cmd);
                    mApplicationModel.notifyObservers();
                    Thread.sleep(250);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GamepadThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            //Close the port previously opened
            port.close();
            
        } catch (IOException ex) {
            ErrorDialog dialog = new ErrorDialog(mApplicationModel.getParentFrame(), true, ex.getMessage());
            dialog.setVisible(true);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {

            }
        }
    }

    /**
     * Stop the thread from running
     * @param b - true to stop
     */
    public void stopThread(boolean b){
        mStopThread = b;
    }

    /**
     * Set the application model. This model holds
     * information specific to the application UI
     * @param mApplicationModel -the application model
     */
    public void setApplicationModel(USBRobotGamepadAppModel mApplicationModel) {
        this.mApplicationModel = mApplicationModel;
    }
}
