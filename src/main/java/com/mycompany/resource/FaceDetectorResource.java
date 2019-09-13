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
    
    //Default message
    @GET
    @Path("/greet")
    @Produces(MediaType.TEXT_PLAIN)
    public String getData(){
        return "Face Detector welcome";
    }
    
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public String uploadImage(
            @FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetails,
            @Context HttpServletRequest request){
        //return Response.status(Response.Status.OK).build();
        String response = faceDetectorService.processImage() + " ruta actual: " + System.getProperty("user.dir");
        return response;
    }
}
