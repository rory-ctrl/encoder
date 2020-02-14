/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encoder;

import java.io.*;
 import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


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
    
    public String encodeMessage (String fileName) {
        return "";
        
    }

    public String encodeFile(String fileName) throws IOException {
     /* 
      This encodeFile method is the first attempt at making a method that reads a file. Checks
      if that file is in the project, reads it and ouputs it content as the String value of a list
     */
        
        //Path path = FileSystems.getDefault().getPath(fileName);
        List lines = Files.readAllLines(Paths.get(fileName));
        return lines.toString();

    }
}
