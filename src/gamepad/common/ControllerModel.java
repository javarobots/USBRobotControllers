/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepad.common;

import net.java.games.input.Controller;

/**
 *
 * @author Parham
 */
public interface ControllerModel {
    
    void setController(Controller c);
    
    void addFunction(GamepadFunction function);
    
    String generateCommand();
    
}
