/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepad.common;

import net.java.games.input.Component;

/**
 * An interface for Gamepad functions
 * @author Parham
 */
public interface GamepadFunction {

    /**
     * Evaluate the function
     * @return the function's float value
     */
    String evaluateFunction();

    /**
     * Sets the controller component
     * for the function
     * @param c - the component
     */
    void setComponent(Component c);

}
