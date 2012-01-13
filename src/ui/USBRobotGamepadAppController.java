/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import gamepad.common.ControllerModel;
import gamepad.common.GamepadThread;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    void startGamepadThread(String controllerName, String modelClassName) {
        try {
            System.out.println(controllerName + " starting with model: " + modelClassName);
            ControllerModel m = (ControllerModel) Class.forName("gamepad.models.DefaultModel").newInstance();
        } catch (InstantiationException ex) {
            Logger.getLogger(USBRobotGamepadAppController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(USBRobotGamepadAppController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(USBRobotGamepadAppController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
