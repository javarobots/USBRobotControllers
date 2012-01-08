/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util.jinput;

import java.util.ArrayList;
import java.util.List;
import net.java.games.input.Controller;
import net.java.games.input.Controller.Type;
import net.java.games.input.ControllerEnvironment;

/**
 *
 * @author Parham
 */
public class JinputUtilities {
    
    public static List<Controller> availableGamepads() {
        List<Controller> controllerList = new ArrayList<Controller>();
        ControllerEnvironment env = ControllerEnvironment.getDefaultEnvironment();
        Controller[] controllers = env.getControllers();
        for (Controller c : controllers){
            if (c.getType() == Type.GAMEPAD){
                controllerList.add(c);
            }
        }
        return controllerList;
    }
    
}
