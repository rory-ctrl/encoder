/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encoder;

import java.util.*;
import java.io.*;
/**
 *
 * @author Rory Mackin
 */
public class Encoder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public boolean encode(String fileName) {
      /* 
      This encode method is a method stub to see how a File Reader would be contructed.
      Typing false text into the file text bar should return false. This means the method
      is taking a file and seeing if it can be read it. 
      */
      File read = new File(fileName);
      
        return read.canRead() == true;
    
}
}
