/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import gamepad.models.AvailableModels;
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
    private List<Class> mAvailableModels;
    
    public void initModel(){
        List<Controller> availableControllers = JinputUtilities.availableGamepads();
        mAvailableControllers = availableControllers.toArray(new Controller[0]);
        mAvailableModels = AvailableModels.instance().getAvailableClasses();
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
    
    public List<Class> getAvailableClasses(){
        return mAvailableModels;
    }
    
}
