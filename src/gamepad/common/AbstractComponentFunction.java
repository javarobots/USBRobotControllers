/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepad.common;

import net.java.games.input.Component;

/**
 *
 * @author Parham
 */
public abstract class AbstractComponentFunction implements GamepadFunction {
    
    protected Component mComponent;
    
    public AbstractComponentFunction(Component component){
        mComponent = component;
    }
    
}
