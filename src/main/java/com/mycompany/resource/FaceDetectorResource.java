/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resource;


import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import com.mycompany.service.FaceDetectorService;
import com.mycompany.service.FileManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;


/**
 *
 * @author adolfo
 */

/*
Resource for facedetection: 
    Receives an image from upload
*/

@Path("facedetector")
public class FaceDetectorResource {
   
    private FaceDetectorService faceDetectorService = new FaceDetectorService();
    private FileManager fileManager = new FileManager();
    private static final String UPLOAD_DIR = "/Uploads";
    //Default message
    @GET
    @Path("/greet")
    @Produces(MediaType.TEXT_PLAIN)
    public String getData(){
        return "hello world!!!!";
    }
    
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public String uploadImage(
            @FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetails,
            @Context HttpServletRequest request){
        //return Response.status(Response.Status.OK).build();
        String path = request.getServletContext().getRealPath("")
                        + UPLOAD_DIR + File.separator
                        + fileDetails.getFileName();
        //Save imageString response = "imagen guardad!";
        fileManager.saveFile(uploadedInputStream,path);
        
        File uploadedImage = fileManager.loadImage(path);
        String response = "imagen guardada: " + uploadedImage.getAbsolutePath();
        //String response = faceDetectorService.detectFaces(uploadedImage);
        return response;
    }
   
}
