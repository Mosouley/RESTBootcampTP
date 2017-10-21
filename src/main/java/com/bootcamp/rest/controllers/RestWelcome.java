
package com.bootcamp.rest.controllers;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author Ibrahim
 */
@Path("/hello")
public class RestWelcome {
    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg) {

        String output = " get a simple param Jersey say : " + msg;

        return Response.status(200).entity(output).build();

    }
    //QueryParam
    @GET
    @Path("/test")
    public Response getQMsg(@QueryParam("param") String msg,@QueryParam("param2") String msg2) {

        String output = " QueryParam Jersey say : " + msg+" et "+ msg2;

        return Response.status(200).entity(output).build();

    }
    
    @GET
    @Path("/{param}/{param2}")
    public Response get3Msg(@PathParam("param") String msg,@PathParam("param2") String msg2) {

        String output = " get for param1/param2 Jersey say : " + msg +" et "+msg2;

        return Response.status(200).entity(output).build();

    }
    
     @GET
    @Path("/{param}/bootcamp/{param2}")
    public Response get2Msg(@PathParam("param") String msg,@PathParam("param2") String msg2 ) {

        String output = " get param1/bootcamp/param2 Jersey say : " + msg +" et "+msg2;

        return Response.status(200).entity(output).build();

    }
    
     @GET
    @Path("/")
    public Response home() {

        String output = " index home page";

        return Response.status(200).entity(output).build();

    }
    
    
    
     @POST
    @Path("/{param}")
    public Response postMsg(@PathParam("param") String msg) {

        String output = "Post  Jersey say : " + msg;

        return Response.status(200).entity(output).build();

    }
    
      @DELETE
    @Path("/{param}")
    public Response deleteMsg(@PathParam("param") String msg) {

        String output = "delete Jersey say : " + msg;

        return Response.status(200).entity(output).build();

    }
    
      @PUT
    @Path("/{param}")
    public Response putMsg(@PathParam("param") String msg) {

        String output = "put Jersey say : " + msg;

        return Response.status(200).entity(output).build();

    }
    
    
}
