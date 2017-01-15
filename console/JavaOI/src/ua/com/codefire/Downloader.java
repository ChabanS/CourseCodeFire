/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 *
 * @author codefire
 */
public class Downloader {

    public static void main(String[] args) throws IOException{
        String path = "http://www.ex.ua/get/10242971";
        URL url = new URL(path);
        InputStream inputStream = url.openStream();
        BufferedInputStream bufferedInput = new BufferedInputStream(inputStream);
        
        FileOutputStream outputStream = new FileOutputStream("picture.jpg");
        BufferedOutputStream bufferedOutput = new BufferedOutputStream(outputStream);
        long start = System.currentTimeMillis();
        int b;
        while((b = bufferedInput.read()) != -1){
            bufferedOutput.write(b);
        }
        System.out.println("Elapsed: " + (System.currentTimeMillis() - start) + " ms");
        outputStream.close();
        inputStream.close();
    }
}
