/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepad.functions;

import gamepad.common.AbstractComponentFunction;
import net.java.games.input.Component;

/**
 * A simple test function used to demonstrate
 * the use of functions for a game pads
 * @author Parham
 */
public class TestFunction extends AbstractComponentFunction {

    public TestFunction(Component c){
        super(c);
    }
    
    @Override
    public float evaluateFunction() {
        float readValue = mComponent.getPollData();
        
        //Create your custom function here
        float calculatedValue = readValue * 100;
        
        return calculatedValue;
    }
    
}
