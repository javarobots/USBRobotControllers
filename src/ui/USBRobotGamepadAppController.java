/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import gamepad.common.GamepadThread;

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
        
    }
    
}
