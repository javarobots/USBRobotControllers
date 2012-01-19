/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.selectcomport;

import java.awt.Component;
import java.util.List;
import java.util.Observable;
import util.rxtx.RxTxUtilities;

/**
 *
 * @author Parham
 */
public class SelectComDialogModel extends Observable { 
    
    private List<String> mAvailableComPorts;
    private Component mParentComponent;
    
    public SelectComDialogModel(Component parent)    {
        mParentComponent = parent;
        initModel();
    }
    
    private void initModel(){
        mAvailableComPorts = RxTxUtilities.getAvailablePorts();
        setChanged();
    }

    public List<String> getmAvailableComPorts() {
        return mAvailableComPorts;
    }

    public Component getmParentComponent() {
        return mParentComponent;
    }
    
}
