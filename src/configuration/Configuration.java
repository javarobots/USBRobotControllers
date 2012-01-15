/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package configuration;

import java.io.File;
import util.ResourceCopier;

/**
 * A singleton class for configuring common parameters
 * used throughout the application. 
 * @author Parham
 */
public class Configuration {
    
    private static Configuration instance = null;
    private String mUserHome;
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
            mUserHome = System.getenv("USERPROFILE");
        }
        else {
            mUserHome = System.getenv("HOME");
        }
        
        //Check for configuration directory and create if necessary
        File configurationDirectory = new File(mUserHome + CONFIGURATION_DIRECTORY);
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
            ResourceCopier copier = new ResourceCopier("gamepad/xml/ExampleFile.xml", configurationDirectory.toString() + "/Example.xml");
            copier.copyFile();
            ConsoleOutput.outToConsole("Example.xml copied");
        }
    }
    
    /**
     * Get the String path of the users home directory.
     * This return a OS dependent path.
     * @return the users home directory path
     */
    public String getSystemHome(){
        return mUserHome;
    }
    
    /**
     * The directory path where model .xml 
     * files are written
     * @return the application directory path
     */
    public File getApplicationDirectory(){
        return new File(mUserHome + CONFIGURATION_DIRECTORY);
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
