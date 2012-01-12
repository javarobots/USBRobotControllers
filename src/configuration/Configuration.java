/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package configuration;

import java.io.File;
import util.ResourceCopier;

/**
 *
 * @author Parham
 */
public class Configuration {
    
    private static Configuration instance = null;
    private String userHome;
    public static final int OPEN_COMM_PAUSE = 2500;
    public static final String CONFIGURATION_DIRECTORY = "/USBController";
    public static final boolean OUTPUT_TO_CONSOLE = true;
        
    private Configuration(){
        
    }
    
    public static Configuration getInstance(){
        if (instance == null){
            instance = new Configuration();
        }
        return instance;
    }
    
    /**
     * This method checks for existence
     * of configuration files necessary
     * for proper execution. Missing files
     * are copied from the resource location
     * to the users home directory.
     */
    public void configurationChecks(){        
        //Determine OS
        if (isWindows()){
            userHome = System.getenv("USERPROFILE");
        }
        else {
            userHome = System.getenv("HOME");
        }
        
        //Check for configuration directory and create if necessary
        File configurationDirectory = new File(userHome + CONFIGURATION_DIRECTORY);
        if (!configurationDirectory.exists()){
            configurationDirectory.mkdirs();
        }
        
        //Check for template .xml file        
        boolean templateExists = false;
        for (File f :configurationDirectory.listFiles()){
            if (f.getName().equals("TemplateFile")){
                templateExists = true;
            }
        }
        if (!templateExists){
            ResourceCopier copier = new ResourceCopier("gamepad/xml/TemplateFile.xml", configurationDirectory.toString() + "/Template.xml");
            copier.copyFile();
            ConsoleOutput.outToConsole("TemplateFile.xml copied");
        }
    }
    
    public String getSystemHome(){
        return userHome;
    }
    
    public File getApplicationDirectory(){
        return new File(userHome + CONFIGURATION_DIRECTORY);
    }
    
    /**
     * Checks to see if the current
     * OS is Windows or not
     * @return true if OS is a Windows OS
     */
    private boolean isWindows(){
        String os = System.getenv("OS");
        if (os.contains("Windows")){
            return true;
        }
        return false;
    }
    
}
