/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import configuration.ConsoleOutput;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Copies resource files to a designated file path.
 * The resource file path is the relative path within
 * the project.
 * @author Parham
 */
public class ResourceCopier {
    
    private String sourcePath;
    private String destPath;
    
    public ResourceCopier(String resource,String destination){
        this.sourcePath = resource;
        this.destPath = destination;
    }
    
    /**
     * Copies the selected resource file
     * to the designated destination path
     */
    public void copyFile(){
        try {
            //Create streams for copying serial file
            InputStream in = this.getClass().getClassLoader().getResourceAsStream(sourcePath);
            OutputStream out = new FileOutputStream(destPath);
            
            ConsoleOutput.outToConsole("Source path: " + sourcePath);
            ConsoleOutput.outToConsole("Destination path" + destPath);

            //Create copy buffer and copy file
            byte[] buffer = new byte[4096];
            int bytesRead = in.read(buffer);
            while (bytesRead > 0){
                out.write(buffer,0,bytesRead);
                bytesRead = in.read(buffer);
            }

            //Close streams
            in.close();
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(ResourceCopier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
