/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package configuration;

/**
 *
 * @author Parham
 */
public class ConsoleOutput {
    
    public static void outToConsole(String message){
        if (Configuration.OUTPUT_TO_CONSOLE){
            System.out.println(message);
        }
    }
    
}
