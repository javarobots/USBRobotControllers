/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepad.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Parham
 */
public class AvailableModels {
    
    private static AvailableModels mInstance;
    private List<Class> mAvailableClasses;
    
    private AvailableModels(){
        mAvailableClasses = new ArrayList<Class>();
        mAvailableClasses.add(gamepad.models.DefaultModel.class);
    }
    
    public static AvailableModels instance(){
        if (mInstance == null){
            mInstance = new AvailableModels();
        }
        return mInstance;
    }
    
    public List<Class> getAvailableClasses(){
        return mAvailableClasses;
    }
    
}
