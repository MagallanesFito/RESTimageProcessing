/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author adolfo
 */
public class FileManager {
    public FileManager(){}
    
    public void saveFile(InputStream inputStream, String path){
        try{
            OutputStream outputStream =  new FileOutputStream(new File(path));
            int read = 0;
            byte [] bytes = new byte[1024];
             
            while((read = inputStream.read(bytes)) != -1){
                outputStream.write(bytes,0,read);
            }
            outputStream.flush();
            outputStream.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public File loadImage(String path){
        return new File(path);
    }
    
}
