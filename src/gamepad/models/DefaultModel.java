/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepad.models;

import gamepad.common.ControllerModel;
import gamepad.common.GamepadFunction;
import java.util.ArrayList;
import java.util.List;
import net.java.games.input.Controller;

/**
 *
 * @author Parham
 */
public class DefaultModel implements ControllerModel {
    
    private Controller mController;
    private List<GamepadFunction> mFunctions;
    
    public DefaultModel(){
        mFunctions = new ArrayList<GamepadFunction>();
        System.out.println("DefaultModel instantiated.");
    }
    
    @Override
    public void setController(Controller c){
        mController = c;
    }

    @Override
    public void addFunction(GamepadFunction function) {
        mFunctions.add(function);
    }

    @Override
    public String generateCommand() {
        mController.poll();
        StringBuilder commandBuilder = new StringBuilder("$CNT");
        for (GamepadFunction gf : mFunctions){
            commandBuilder.append(",").append(Float.toString(gf.evaluateFunction()));
        }
        return commandBuilder.toString();
    }
    
}
