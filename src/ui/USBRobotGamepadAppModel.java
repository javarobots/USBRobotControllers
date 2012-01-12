/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.List;
import java.util.Observable;
import net.java.games.input.Controller;
import util.jinput.JinputUtilities;

/**
 *
 * @author Parham
 */
public class USBRobotGamepadAppModel extends Observable {
    
    private Controller mSelectedController;
    private Controller[] mAvailableControllers;
    
    public void initModel(){
        List<Controller> availableControllers = JinputUtilities.availableGamepads();
        mAvailableControllers = availableControllers.toArray(new Controller[0]);
        setChanged();
    }

    public Controller getSelectedController() {
        return mSelectedController;
    }

    public void setSelectedController(Controller selectedController) {
        this.mSelectedController = selectedController;
        setChanged();
    }

    public Controller[] getAvailableControllers() {
        return mAvailableControllers;
    }
    
}
