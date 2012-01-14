/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepad.functions;

import gamepad.common.AbstractComponentFunction;
import net.java.games.input.Component;

/**
 * A simple example function used to demonstrate
 * the use of functions for a game pads.
 * 
 * This function takes the value read and multiplies it by 100
 * 
 * @author Parham
 */
public class ExampleFunction extends AbstractComponentFunction {

    public ExampleFunction(){
        super();
    }
    
    @Override
    public void setComponent(Component c){
        this.mComponent = c;
    }
    
    @Override
    public float evaluateFunction() {
        float readValue = mComponent.getPollData();
        //Create your custom function here
        float calculatedValue = readValue * 100;        
        return calculatedValue;
    }
    
}
