/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepad.models;

import configuration.ConsoleOutput;
import gamepad.common.ControllerModel;
import gamepad.common.GamepadFunction;
import java.util.ArrayList;
import java.util.List;
import net.java.games.input.Controller;

/**
 * The default Gamepad model. This model build command
 * string using $CNT has it's message header and comma
 * delimits function values
 *
 * e.g. $CNT,123,456
 *
 * @author Parham
 */
public class DefaultModel implements ControllerModel {

    private Controller mController;
    private List<GamepadFunction> mFunctions;

    public DefaultModel(){
        mFunctions = new ArrayList<>();
       ConsoleOutput.outToConsole("DefaultModel instantiated.");
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
        //Poll the controller obtaining new values
        mController.poll();
        //Build the command
        StringBuilder commandBuilder = new StringBuilder("$CNT");
        for (GamepadFunction gf : mFunctions){
            commandBuilder.append(",").append(gf.evaluateFunction());
        }
        return commandBuilder.toString();
    }

}
