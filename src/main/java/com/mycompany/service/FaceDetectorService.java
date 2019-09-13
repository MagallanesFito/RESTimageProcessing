/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import java.io.File;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.objdetect.CascadeClassifier;

/**
 *
 * @author adolfo
 */
/*This class provides several methods for image processing */
public class FaceDetectorService {
    
    public static final String CASCADE_CLASSIFIER = "haarcascade_frontalface_default.xml";
    private CascadeClassifier cascadeClassifier;
    
    public FaceDetectorService(){
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        this.cascadeClassifier = new CascadeClassifier(CASCADE_CLASSIFIER);
    }
    
    public String detectFaces(File file){
        Mat image = Imgcodecs.imread(file.getAbsolutePath(),Imgcodecs.CV_LOAD_IMAGE_COLOR);
        MatOfRect faceDetections = new MatOfRect();
        cascadeClassifier.detectMultiScale(image, faceDetections);
        String result = faceDetections.toArray().toString();
        return "Processed image!: "+result;
        //return "Processed image: ";
    }
}
