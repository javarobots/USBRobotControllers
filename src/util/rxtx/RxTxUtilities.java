/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util.rxtx;

import gnu.io.CommPortIdentifier;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * A utility class for the RxTx library
 * @author jparham
 */
public class RxTxUtilities {
    
    public static List<String> getAvailablePorts(){
        List<String> portNames = new ArrayList<>();
        Enumeration identifiers = CommPortIdentifier.getPortIdentifiers();
        while (identifiers.hasMoreElements()){
            CommPortIdentifier identifier = (CommPortIdentifier) identifiers.nextElement();
            if (identifier.getPortType() == CommPortIdentifier.PORT_SERIAL){
                portNames.add(identifier.getName());
            }
        }
        return portNames;
    }
    
}
