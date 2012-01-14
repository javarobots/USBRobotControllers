/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import gamepad.common.ControllerModel;
import gamepad.common.GamepadThread;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.java.games.input.Controller;
import util.jinput.JinputUtilities;

/**
 *
 * @author Parham
 */
public class USBRobotGamepadAppController {
    
    private USBRobotGamepadAppModel mModel;
    private GamepadThread mThread;
    
    public USBRobotGamepadAppController(USBRobotGamepadAppModel model){
        mModel = model;
    }
    
    public void setSelectedController(){
        
    }

    void startGamepadThread(String controllerName, String modelClassAndFileName) {
        try {
            String[] splitClassAndFile = modelClassAndFileName.split("-");
            ControllerModel m = (ControllerModel) Class.forName(splitClassAndFile[0]).newInstance();
            Controller gameController = JinputUtilities.getControllerByName(controllerName);
            
            
            System.out.println("debug");
        } catch (InstantiationException ex) {
            Logger.getLogger(USBRobotGamepadAppController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(USBRobotGamepadAppController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(USBRobotGamepadAppController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
