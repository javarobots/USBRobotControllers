/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import configuration.Configuration;
import gamepad.common.ControllerModel;
import gamepad.common.GamepadFunction;
import gamepad.common.GamepadThread;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.java.games.input.Component;
import net.java.games.input.Controller;
import org.jdom.Element;
import util.JdomWrapper;
import util.jinput.JinputUtilities;
import util.xml.JdomDocumentReader;

/**
 * Controller class for the main application.
 * This class allows logic the be separated
 * from the view.
 * @author Parham
 */
public class USBRobotGamepadAppController {
    
    private USBRobotGamepadAppModel mModel;
    
    public USBRobotGamepadAppController(USBRobotGamepadAppModel model){
        mModel = model;
    }

    /**
     * Starts the Gamepad thread. The selected Gamepad controller
     * is obtained and all mapped functions instantiated.
     * @param controllerName - The name of the controller
     * @param modelClassAndFileName - The name of the model class
     * and its .xml file
     */
    public void startGamepadThread(String controllerName, String modelClassAndFileName) {
        try {
            //Split the model and filename into separate Strings
            String[] splitClassAndFile = modelClassAndFileName.split("-");
            //Get the controller and the controller model
            Controller gameController = JinputUtilities.getControllerByName(controllerName);
            ControllerModel controllerModel = (ControllerModel) Class.forName("gamepad.models." + splitClassAndFile[0]).newInstance();
            controllerModel.setController(gameController);
            //Map all component names to components
            Map<String,Component> componentNameToComponentMap = new HashMap<String,Component>();
            for (Component c : gameController.getComponents()){
                componentNameToComponentMap.put(c.getName(), c);
            }
            //Determine components and corresponding function to load            
            JdomDocumentReader reader = new JdomDocumentReader(new File(Configuration.getInstance().getApplicationDirectory(),splitClassAndFile[1]));
            Element rootElement = reader.initAndGetRoot();
            List<Element> rootChildren = JdomWrapper.getChildren(rootElement);
            for (Element e : rootChildren){
                if (e.getName().equals("control")){
                    //Extract the component and function
                    Element componentElement = e.getChild("component");
                    Element functionElement = e.getChild("function");
                    GamepadFunction gf = (GamepadFunction) Class.forName("gamepad.functions." + functionElement.getValue()).newInstance();
                    gf.setComponent(componentNameToComponentMap.get(componentElement.getValue()));
                    controllerModel.addFunction(gf);
                }
            }
            //Set up the thread
            GamepadThread gt = new GamepadThread(controllerModel);
            gt.setApplicationModel(mModel);
            mModel.setThread(gt);
            Thread t = new Thread(gt);
            t.start();
        } catch (InstantiationException ex) {
            Logger.getLogger(USBRobotGamepadAppController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(USBRobotGamepadAppController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(USBRobotGamepadAppController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Stop the Gamepad thread
     */
    public void stopThread() {
        mModel.getThread().stopThread(true);
    }
    
}
