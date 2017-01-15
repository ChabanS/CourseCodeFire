/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author codefire
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        FileOutputStream outputStream = new FileOutputStream("data.bin");
        DataOutputStream dataOutput = new DataOutputStream(outputStream);
        dataOutput.writeDouble(3.14);
        dataOutput.writeInt(125);
        dataOutput.writeUTF("Hello World!");
        // dataOutput.flush();
        dataOutput.close(); // -> autoflush
        outputStream.close();
        
        FileInputStream inputStream = new FileInputStream("data.bin");
        DataInputStream dataInput = new DataInputStream(inputStream);
        System.out.println(dataInput.readDouble());
        System.out.println(dataInput.readInt());
        System.out.println(dataInput.readUTF());
        dataInput.close();
        inputStream.close();
        
        RandomAccessFile file = new RandomAccessFile("data.bin", "rw");
        file.seek(13);
        int length = file.read();
        for (int i = 0; i < length; i++) {
            System.out.print((char)file.read());
        }
        System.out.println();
    }
    
}
