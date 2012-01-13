/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepad.models;

import gamepad.common.ControllerModel;
import gamepad.common.GamepadFunction;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Parham
 */
public class DefaultModel implements ControllerModel {
    
    private List<GamepadFunction> mFunctions;
    
    public DefaultModel(){
        mFunctions = new ArrayList<GamepadFunction>();
        System.out.println("DefaultModel instantiated.");
    }

    @Override
    public void addFunction(GamepadFunction function) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String generateCommand() {
        StringBuilder commandBuilder = new StringBuilder("$CNT");
        for (GamepadFunction gf : mFunctions){
            commandBuilder.append(",").append(Float.toString(gf.evaluateFunction()));
        }
        return commandBuilder.toString();
    }
    
}
