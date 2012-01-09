/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepad.common;

/**
 *
 * @author Parham
 */
public interface ControllerModel {
    
    void addFunction(GamepadFunction function);
    
    String generateCommand();
    
    String getModelName();
    
}
