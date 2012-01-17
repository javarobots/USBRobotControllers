/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util.rxtx;

import gnu.io.CommPortIdentifier;
import java.util.Enumeration;

/**
 * A utility class for the RxTx library
 * @author jparham
 */
public class RxTxUtilities {
    
    public static void getAvailablePorts(){
        Enumeration identifiers = CommPortIdentifier.getPortIdentifiers();
        while (identifiers.hasMoreElements()){
            String name = ((CommPortIdentifier)identifiers.nextElement()).getName();
            System.out.println("Port name: " + name);
        }
    }
    
}
