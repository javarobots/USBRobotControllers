/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import configuration.Configuration;
import gamepad.common.GamepadThread;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import net.java.games.input.Controller;
import org.jdom.Element;
import util.jinput.JinputUtilities;
import util.xml.JdomDocumentReader;

/**
 * The model class for application UI
 * @author Parham
 */
public class USBRobotGamepadAppModel extends Observable {
    
    private Controller mSelectedController;
    private Controller[] mAvailableControllers;
    private Map<File,String> mModelNameToFileName;
    private GamepadThread mThread;
    private String mCommandString = "";
    
    /**
     * Initialize the model
     */
    public void initModel(){
        List<Controller> availableControllers = JinputUtilities.availableGamepads();
        mAvailableControllers = availableControllers.toArray(new Controller[0]);        
        //Init model files
        mModelNameToFileName = new HashMap<File,String>();
        File[] xmlFiles = Configuration.getInstance().getApplicationDirectory().listFiles();
        for (File f : xmlFiles){
            JdomDocumentReader reader = new JdomDocumentReader(f);
            Element root = reader.initAndGetRoot();
            Element modelElement = root.getChild("model");
            mModelNameToFileName.put(f, modelElement.getText());
        }
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

    public Map<File,String> getModelNameToFileName() {
        return mModelNameToFileName;
    }

    public GamepadThread getThread() {
        return mThread;
    }

    public void setThread(GamepadThread mThread) {
        this.mThread = mThread;
    }

    public String getCommandString() {
        return mCommandString;
    }

    public void setCommandString(String mCommandString) {
        this.mCommandString = mCommandString;
        setChanged();
    }
    
}
