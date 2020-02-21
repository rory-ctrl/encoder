/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encoder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
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
    int[] initialKey = {2, 2, 2, 2, 2};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    public String readFile(String fileName) throws IOException {
        /*
        This method is used to read files. It creates a BufferedReader
        It reads each line of the file into a String and the returns that String.
        */
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String readFile = br.readLine();
        return readFile;
    }

    public void writeFile(Path file, List decodedFile) throws IOException {
        
        Files.write(file, decodedFile);

    }

    public String encodeMessage(String message) {
        /*
        This method is the overall method used for encryption.
         */
        
        for (int keyVal : initialKey) {
            repeatingKey.offer(keyVal);
        }
        String encode = message;
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
        repeatingKey.clear();
        String encoded = sb.toString();
        return encoded;

    }

    public String decodeMessage(String message) {
        /*
        This method is the overall method used for decryption.
         */
        
        for (int keyVal : initialKey) {
            repeatingKey.offer(keyVal);
        }
        StringBuilder decodedBuffer = new StringBuilder();
        String decode = message;

        for (int ci = 0; ci < decode.length(); ci++) {
            int shift = repeatingKey.poll();

            // shift character by shift
            char toShift = decode.charAt(ci);
            int shifted = toShift - shift;
            char shiftedChar = (char) shifted; // cast back to char
            decodedBuffer.append(shiftedChar);

            // added shift back into the queue
            repeatingKey.offer(shift);
           

        }
        repeatingKey.clear();
        String decoded = decodedBuffer.toString();
        return decoded;

    }

    public void encodeFile(String fileName) throws IOException {
        /* 
      This encodeFile method is the first attempt at making a method that reads a file and encodes it's contents.
         */
        String message = readFile(fileName);
        String encodedMessage = encodeMessage(message);
        ArrayList<String> encodedFile = new ArrayList<>(Arrays.asList(encodedMessage));
        Path file = Paths.get("data" + File.separator + "hello(encoded).txt");
        writeFile(file, encodedFile);

    }

    public void decodeFile(String fileName) throws IOException {
        /* 
      This encodeFile method is the first attempt at making a method that reads a file and encodes it's contents.
         */
        String message = readFile(fileName);
        String encodedMessage = decodeMessage(message);
        ArrayList<String> encodedFile = new ArrayList<>(Arrays.asList(encodedMessage));
        Path file = Paths.get("data" + File.separator + "hello(decoded).txt");
        writeFile(file, encodedFile);

    }
}
