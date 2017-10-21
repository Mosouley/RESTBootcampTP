package com.bootcamp.rest.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.bootcamp.entity.Bailleur;
import com.bootcamp.jpa.repository.BailleurRepository;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Ibrahim
 */
@Path("/bailleur")
public class BailleurRestController {

    //instanciation d'un bailleur repository
    BailleurRepository bailleurRepository = new BailleurRepository("PostgresPuWeb");

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getList() throws SQLException {
        List<Bailleur> bailleurs = bailleurRepository.findAll();
        //access par le concept CORS
        return Response.status(200).entity(bailleurs).header("Access-Control-Allow-Origin", "*").build();

    }

    @GET
    @Path("/pers/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id) throws SQLException {

        Bailleur bailleur = bailleurRepository.findByPropertyUnique("id", id);

        if (bailleur != null) {
            return Response.status(200).entity(bailleur).build();
        } else {
            return Response.status(404).entity(bailleur).build();
        }
    }

    @GET
    @Path("/pers/param/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByIdParam(@PathParam("id") int id, @QueryParam("fields") String fields) throws SQLException, IllegalArgumentException, IllegalAccessException, IntrospectionException, InvocationTargetException {
        String[] fieldArray = fields.split(",");
        Bailleur bailleur = bailleurRepository.findByPropertyUnique("id", id);
        //  Bailleur bailleurResponse=new Bailleur();
        Map<String, Object> responseMap = new HashMap<>();
//
        PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(Bailleur.class).getPropertyDescriptors();

        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {

            Method method = propertyDescriptor.getReadMethod();
            if (check(fieldArray, propertyDescriptor.getName())) {
                responseMap.put(propertyDescriptor.getName(), method.invoke(bailleur));
            }
//                System.out.println(" " + propertyDescriptor.getName());
//
//                System.out.println(method.invoke(bailleur));
        }
        return Response.status(200).entity(responseMap).build();
    }

    @POST
    @Path("/create")
//    @Produces(MediaType.)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Bailleur bailleur) {
        String output = " Félicitations objet créé avec succès : ";
        try {
            bailleurRepository.create(bailleur);
            return Response.status(200).entity(output + bailleur.getNom()).build();
        } catch (SQLException ex) {
            return Response.status(404).entity("Erreur: Objet non créé").build();
        }
    }

    @PUT
    @Path("/update")
//    @Produces(MediaType.)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Bailleur bailleur) {
        String output = " Félicitations Mise à jour effectuée avec succès pour : ";
        try {
            bailleurRepository.update(bailleur);
            return Response.status(200).entity(output + bailleur.getNom()).build();
        } catch (SQLException ex) {
            return Response.status(404).entity("Erreur: Objet non mis à jour").build();
        }

    }

    private boolean check(String[] fields, String field) {

        for (String field1 : fields) {
            if (field.equals(field1)) {
                return true;
            }
        }
        return false;
    }
}

//package org.codingpedia.demo.rest.util;
//
//import java.io.IOException;
//
//import javax.ws.rs.container.ContainerRequestContext;
//import javax.ws.rs.container.ContainerResponseContext;
//import javax.ws.rs.container.ContainerResponseFilter;
//import javax.ws.rs.core.MultivaluedMap;
//
//public class CORSResponseFilter
//implements ContainerResponseFilter {
//
//    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
//            throws IOException {
//
//        MultivaluedMap<String, Object> headers = responseContext.getHeaders();
//
//        headers.add("Access-Control-Allow-Origin", "*");
//        //headers.add("Access-Control-Allow-Origin", "http://podcastpedia.org"); //allows CORS requests only coming from podcastpedia.org
//        headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
//        headers.add("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, X-Codingpedia");
//    }
//
//}
