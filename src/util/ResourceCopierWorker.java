/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.swing.SwingWorker;

/**
 * A resource copier that works on a separate thread.
 * @author Parham
 */
public class ResourceCopierWorker extends SwingWorker<Boolean,Boolean> {
    
    private String sourcePath;
    private String destPath;
    
    public ResourceCopierWorker(String resource,String destination){
        this.sourcePath = resource;
        this.destPath = destination;
    }

    @Override
    protected Boolean doInBackground() throws Exception {
        ResourceCopier copier = new ResourceCopier(sourcePath,destPath);
        copier.copyFile();
        return true;
    }
    
}
