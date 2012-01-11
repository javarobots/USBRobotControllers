/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/**
 * A class that simplifies XML
 * document creation using JDOM
 * @author Parham
 */
public class JdomDocumentCreator {
    
    private Document doc;
    private Element rootElement;
    private File outputFile;
    
    public JdomDocumentCreator(){
        this.doc = new Document();        
    }
    
    public JdomDocumentCreator(File outputFile){
        this.doc = new Document();
        this.outputFile = outputFile;
    }
    
    /**
     * Create the root element for the document
     * @param elementName - the name of the root element
     * @return the root element
     */
    public Element createRootElement(String elementName){
        rootElement = new Element(elementName);
        doc.setRootElement(rootElement);
        return rootElement;
    }
    
    /**
     * Add a new element to a given element
     * @param e - the element being added to
     * @param elementName - name of the new element
     * @param value - value of the new element
     * @return the new element
     */
    public Element addElementToElement(Element e, String elementName, String value){
        Element ne = new Element(elementName);
        if (value != null){
            ne.setText(value);
        }   
        e.addContent(ne);
        return ne;        
    }
    
    /**
     * Add an attribute to a given element
     * @param e - the element the attribute is being added to
     * @param attributeName - the name of the attribute
     * @param value - the value of the attribute
     * @return the original element
     */
    public Element addAttributeToElement(Element e, String attributeName, String value){
        e.setAttribute(attributeName, value);
        return e;
    }
    
    /**
     * Write the document to file.
     * @return <tt>true</tt> if write is successful
     */
    public boolean writeDocument(){
        if (outputFile != null){
            try {
              XMLOutputter serializer = new XMLOutputter();
              serializer.setFormat(Format.getPrettyFormat());            
              FileOutputStream out = new FileOutputStream(outputFile);
              serializer.output(doc, out);
              out.close();
            } catch (IOException ex) {
                Logger.getLogger(JdomDocumentCreator.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
            return true;
        }
        else {
            return false;
        }
            
    }
    
}
