/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.List;
import org.jdom.Element;

/**
 * A wrapper to allow a single place to suppress
 * unchecked conversions in JDOM classes
 * @author Parham
 */
public class JdomWrapper {
    
    public static List<Element> getChildren(Element e){
        @SuppressWarnings("unchecked")
        List<Element> result = e.getChildren();
        return result;
    }
    
}
