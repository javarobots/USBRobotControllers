/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author mnord
 */
public class FindJavaClassPath {
   
   public static void main(String[] args)
   {
      String path = System.getProperty("java.library.path");
      System.out.println(path);
   }
}
