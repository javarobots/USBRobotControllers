/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util.jinput;

import commonutilities.swing.ComponentPosition;
import java.util.ArrayList;
import java.util.List;
import net.java.games.input.Controller;
import net.java.games.input.Controller.Type;
import net.java.games.input.ControllerEnvironment;

/**
 * A utility class for the JInput library
 * @author Parham
 */
public class JinputUtilities {

    /**
     * Get a list of all available controllers
     * plugged in to the computer
     * @return list of available Controller objects
     */
    public static List<Controller> availableGamepads() {
        List<Controller> controllerList = new ArrayList<>();
        ControllerEnvironment env = ControllerEnvironment.getDefaultEnvironment();
        Controller[] controllers = env.getControllers();
        if (controllers.length == 0){
            MissingDllDialog dialog = new MissingDllDialog(null,true);
            dialog.setVisible(true);
        }
        for (Controller c : controllers){
            if (c.getType() == Type.GAMEPAD){
                controllerList.add(c);
            }
        }
        if (controllerList.isEmpty()){
            MissingDllDialog dialog = new MissingDllDialog(null,true);
            dialog.setVisible(true);
        }
        return controllerList;
    }

    /**
     * Get a controller object by name.
     * @param controllerName - the name of the controller
     * @return the Controller object
     */
    public static Controller getControllerByName(String controllerName){
        ControllerEnvironment env = ControllerEnvironment.getDefaultEnvironment();
        Controller[] controllers = env.getControllers();
        for (Controller c : controllers){
            if (c.getName().equals(controllerName)){
                return c;
            }
        }
        return null;
    }

    /**
     * Get a controller object my name and port number
     * @param controllerName - the controller name
     * @param portNumber - the port number
     * @return the controller object
     */
    public static Controller getControllerByName(String controllerName, int portNumber){
        ControllerEnvironment env = ControllerEnvironment.getDefaultEnvironment();
        Controller[] controllers = env.getControllers();
        for (Controller c : controllers){
            if (c.getName().equals(controllerName) && c.getPortNumber() == portNumber){
                return c;
            }
        }
        return null;
    }

}
