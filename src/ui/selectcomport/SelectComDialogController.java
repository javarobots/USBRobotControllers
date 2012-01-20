/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.selectcomport;

import configuration.Configuration;
import org.jdom.Element;
import util.xml.JdomDocumentCreator;

/**
 *
 * @author Parham
 */
public class SelectComDialogController {

    private SelectComDialogModel mModel;

    public SelectComDialogController(SelectComDialogModel model){
        mModel = model;
    }

    public void saveSelectedPort(String selectedPort){
        JdomDocumentCreator out = new JdomDocumentCreator(Configuration.getInstance().getComSelectionFile());
        Element root = out.createRootElement("serialport");
        out.addElementToElement(root, "selectedport", selectedPort);
        out.writeDocument();
    }

}
