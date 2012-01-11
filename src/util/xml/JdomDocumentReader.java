/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util.xml;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import util.JdomWrapper;

/**
 *
 * @author Parham
 */
public class JdomDocumentReader {
    
    private File xmlFile;
    private Document doc;
    
    public JdomDocumentReader(File xmlFile){
        this.xmlFile = xmlFile;
    }
    
    public Element initAndGetRoot(){
        try {
            //Read in the ComPorts xml
            SAXBuilder parser = new SAXBuilder();
            doc = parser.build(xmlFile);
            Element root = doc.getRootElement();
            return root;
        } catch (JDOMException ex) {
            Logger.getLogger(JdomDocumentReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JdomDocumentReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean elementHasChildElement(Element e, String name){
        if (e.getChild(name) != null){
            return true;
        }
        return false;
    }
    
    public Element getChildOfElement(Element e, String name){
        return e.getChild(name);
    }
    
    public Element getChildOfElement(Element e, String name, Namespace ns){
        return e.getChild(name, ns);
    }
    
    public List<Element> getChildrenOfElement(Element e){
        return JdomWrapper.getChildren(e);
    }
    
    public boolean elementHasAttribute(Element e, String name){
        if (e.getAttribute(name) != null){
            return true;
        }
        return false;
    }
    
    public Attribute getAttributeOfElement(Element e, String name){
        return e.getAttribute(name);
    }
}
