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
public class TestModel implements ControllerModel {
    
    private List<GamepadFunction> mFunctions;
    
    public TestModel(){
        mFunctions = new ArrayList<GamepadFunction>();
    }

    @Override
    public void addFunction(GamepadFunction function) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String generateCommand() {
        StringBuilder commandBuilder = new StringBuilder("$ROBCNT");
        for (GamepadFunction gf : mFunctions){
            commandBuilder.append(",").append(Float.toString(gf.evaluateFunction()));
        }
        return commandBuilder.toString();
    }

    @Override
    public String getModelName() {
        return "Test Model";
    }
    
}
