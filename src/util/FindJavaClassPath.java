/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 * A class that can be used to display the Java library path.
 * This path should contain location of where supporting .dll
 * files are saved.
 * @author Parham
 */
public class FindJavaClassPath {
   
   public static void main(String[] args)
   {
      String path = System.getProperty("java.library.path");
      System.out.println(path);
   }
}
