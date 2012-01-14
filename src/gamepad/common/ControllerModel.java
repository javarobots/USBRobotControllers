/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepad.common;

import net.java.games.input.Controller;

/**
 * Interface for controller models. The Model has the controller
 * and functions you wish to be evaluated.
 * @author Parham
 */
public interface ControllerModel {
    
    /**
     * Set the controller for the model
     * @param c - the game controller
     */
    void setController(Controller c);
    
    /**
     * Add functions to the model
     * @param function - a function that is
     * to be evaluated
     */
    void addFunction(GamepadFunction function);
    
    /**
     * Generate the command you want to send
     * @return the generated command
     */
    String generateCommand();
    
}
