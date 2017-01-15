/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author codefire
 */
public class ReadText {

    public static void main(String[] args) throws IOException, JavaLayerException{
        
        // Grub HTML page
        URL url = new URL("http://i.ua");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.addRequestProperty("User-Agent", "Mozilla/5.0 (X11; Linux x86_64)");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream(), "windows-1251"));
        String line;
        while((line = reader.readLine()) != null){
            System.out.println(line);
        }
        reader.close();
        
        
        // Read date and time from SNTP Server
        /*
        Socket socket = new Socket("ntp.time.in.ua", 13);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream()));
        String line;
        while((line = reader.readLine()) != null){
            System.out.println(line);;
        }
        reader.close();
        */
        
        
        // Read remote file
        /*
        URL url = new URL("http://www.ex.ua/playlist/103227057.m3u");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        url.openStream()));
        String line;
        while((line = reader.readLine()) != null){
            System.out.println(line);
            Player player = new Player(new URL(line).openStream());
            player.play();
        }
        reader.close();
        */
        
        
        // Read local file
        /*
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("book.txt"), "windows-1251"));
        String line;
        while((line = reader.readLine()) != null){
            System.out.println(line);
        }
        reader.close();
        */
        
        /*
        String line = reader.readLine();
        while(line != null){
            System.out.println(line);
            line = reader.readLine();
        }
        */
    }
}
