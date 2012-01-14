/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package configuration;

/**
 * A class used for debugging allowing System.out
 * statements to be replaced and later turned off
 * @author Parham
 */
public class ConsoleOutput {
    
    /**
     * Output a message to the console
     * @param message - the message to output
     */
    public static void outToConsole(String message){
        if (Configuration.OUTPUT_TO_CONSOLE){
            System.out.println(message);
        }
    }
    
}
