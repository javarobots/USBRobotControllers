/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import gnu.io.CommPortIdentifier;
import java.util.Enumeration;

/**
 * A wrapper to allow a single place to suppress
 * unchecked conversions in RxTx classes
 * @author Parham
 */
public class RxTxWrapper {
    
    public static Enumeration<CommPortIdentifier> getIdentifiers(){
        @SuppressWarnings("unchecked")
        Enumeration<CommPortIdentifier> result = CommPortIdentifier.getPortIdentifiers();
        return result;
    }
    
}
