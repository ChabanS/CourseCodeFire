/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author codefire
 */
public class ExExample {
    public static void main(String[] args) throws IOException{
        URL url = new URL("http://www.ex.ua/get/4931443");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setInstanceFollowRedirects(false); // disable 302 redirect
        String realPath = connection.getHeaderField("Location");
        if(realPath != null){
            System.out.println("Found: " + realPath);
            File file = new File(realPath);
            String realName = file.getName();
            System.out.println("File: " + realName);
        }
    }
}
