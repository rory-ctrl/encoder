/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encoder;

import java.io.*;
 import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 *
 * @author Rory Mackin
 */
public class Encoder {
    
   /* 
    The queue used for encryption
    */
    Queue<Integer> repeatingKey = new LinkedList<>();
    int[] initialKey = {17, 98, 15, 9, 300};
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public String encodeMessage (String fileName) {
        /*
        This method is the overall method used for encryption.
        */
        for (int keyVal : initialKey) {
            repeatingKey.offer(keyVal);
        }
        String encode = fileName;
        StringBuilder sb = new StringBuilder();

        for (int ci = 0; ci < encode.length(); ci++) {
            int shift = repeatingKey.poll();

            // shift character by shift
            char toShift = encode.charAt(ci);
            int shifted = toShift + shift;
            char shiftedChar = (char) shifted; // cast back to char
            sb.append(shiftedChar);

            // added shift back into the queue
            repeatingKey.offer(shift);
            //System.out.println("key: " + repeatingKey);
        }

        String encoded = sb.toString();
        return encoded;
        
    }

    public String encodeFile(String fileName) throws IOException {
     /* 
      This encodeFile method is the first attempt at making a method that reads a file and encodes it's contents.
     */
        
        //Path path = FileSystems.getDefault().getPath(fileName);
        List lines = Files.readAllLines(Paths.get(fileName));
        String encodedFile = lines.toString();
        String encodedMessage2 = encodeMessage(encodedFile);
       
        return encodedMessage2;

    }
}
