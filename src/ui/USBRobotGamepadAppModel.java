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
import javax.swing.JFrame;
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
    private String mSelectedComPortName;
    private Controller[] mAvailableControllers;
    private Map<File,String> mModelNameToFileName;
    private GamepadThread mThread;
    private String mCommandString = "";
    private JFrame mParentFrame;
    private boolean mJoystickSelected = false;
    private boolean mSerialportSelected = false;

    public USBRobotGamepadAppModel(JFrame parentFrame){
        mParentFrame = parentFrame;
    }

    /**
     * Initialize the model
     */
    public void initModel(){
        List<Controller> availableControllers = JinputUtilities.availableGamepads();
        mAvailableControllers = availableControllers.toArray(new Controller[0]);
        //Init model files
        mModelNameToFileName = new HashMap<>();
        File[] xmlFiles = Configuration.getInstance().getApplicationDirectory().listFiles();
        for (File f : xmlFiles){
            //Read in info from files that aren;t the com selection file
            if (!f.getName().equals(Configuration.getInstance().getComSelectionFile().getName())){
                //Read in info from files that aren;t the com selection file
                JdomDocumentReader reader = new JdomDocumentReader(f);
                Element root = reader.initAndGetRoot();
                Element modelElement = root.getChild("model");
                mModelNameToFileName.put(f, modelElement.getText());
            } else if (f.getName().equals(Configuration.getInstance().getComSelectionFile().getName())){
                //Read the com selection file
                JdomDocumentReader reader = new JdomDocumentReader(f);
                Element root = reader.initAndGetRoot();
                Element selectedPort = root.getChild("selectedport");
                mSelectedComPortName = selectedPort.getValue();
                mSerialportSelected = true;
            }
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

    public JFrame getParentFrame() {
        return mParentFrame;
    }

    public String getSelectedComPortName() {
        return mSelectedComPortName;
    }

    public void setSelectedComPortName(String selectedComPortName) {
        this.mSelectedComPortName = selectedComPortName;
        setChanged();
    }

    public boolean isJoystickSelected() {
        return mJoystickSelected;
    }

    public void setJoystickSelected(boolean mJoystickSelected) {
        this.mJoystickSelected = mJoystickSelected;
        setChanged();
    }

    public boolean isSerialportSelected() {
        return mSerialportSelected;
    }

    public void setSerialportSelected(boolean mSerialportSelected) {
        this.mSerialportSelected = mSerialportSelected;
        setChanged();
    }

}
