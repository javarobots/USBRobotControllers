/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import configuration.Configuration;
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
 *
 * @author Parham
 */
public class USBRobotGamepadAppModel extends Observable {
    
    private Controller mSelectedController;
    private Controller[] mAvailableControllers;
    private Map<String,File> mModelNameToFileName;
    
    public void initModel(){
        List<Controller> availableControllers = JinputUtilities.availableGamepads();
        mAvailableControllers = availableControllers.toArray(new Controller[0]);        
        //Init model files
        mModelNameToFileName = new HashMap<String,File>();
        File[] xmlFiles = Configuration.getInstance().getApplicationDirectory().listFiles();
        for (File f : xmlFiles){
            JdomDocumentReader reader = new JdomDocumentReader(f);
            Element root = reader.initAndGetRoot();
            Element modelElement = root.getChild("model");
            mModelNameToFileName.put(modelElement.getText(), f);
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

    public Map<String, File> getModelNameToFileName() {
        return mModelNameToFileName;
    }
    
    
}
