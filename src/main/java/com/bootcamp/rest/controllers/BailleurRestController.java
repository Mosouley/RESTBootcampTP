package com.bootcamp.rest.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.bootcamp.entity.Bailleur;
import com.bootcamp.entity.Bailleurs;
import com.bootcamp.jpa.repository.BailleurRepository;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Ibrahim
 */
@Path("/bailleurs")
public class BailleurRestController {

    //instanciation d'un bailleur repository
    BailleurRepository bailleurRepository = new BailleurRepository("PostgresPuWeb");

    //Annotation JAX-RS2
    @Context
    UriInfo uriInfo;

    /**
     *
     * @param start
     * @param size
     * @param uriInfo
     * @return
     */
    @GET
//    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
//    @org.jboss.resteasy.annotations.providers.jaxb.Formatted
//    public Bailleurs getBailleurs(@Context UriInfo uriInfo) throws SQLException {
//                        //definition des URI permettant d'obtenir le previous et le next de tout bailleur
//                        //aussi les parametres de pagination son
    public Bailleurs getBailleurs(@QueryParam("start") int start,
            @QueryParam("size") @DefaultValue("2") int size,
            @Context UriInfo uriInfo) throws SQLException {

        //Determination du Builder
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.queryParam("start", "{start}");
        builder.queryParam("size", "{size}");
//
//        UriBuilder nextLinkBuilder = uriInfo.getAbsolutePathBuilder();
//        nextLinkBuilder.queryParam("start", 5);
//        nextLinkBuilder.queryParam("size", 10);
//        URI next = nextLinkBuilder.build();
        List<Bailleur> bailleurs = bailleurRepository.findAll();

        ArrayList<Link> links = new ArrayList<Link>();
        ArrayList<Bailleur> list = new ArrayList<>();
        synchronized (bailleurs) {
            int i = 0;
            for (Bailleur bailleur : bailleurs) {
                if (i >= start && i < start + size) {
                    list.add(bailleur);
                }
                i++;
            }
        }
//
        // next link
        if (start + size < bailleurs.size()) {
            int next = start + size;
            URI nextUri = builder.clone().build(next, size);
            Link nextLink = Link.fromUri(nextUri)
                    .rel("next").type("application/json").build();
            links.add(nextLink);
        }
        // previous link
        if (start > 0) {
            int previous = start - size;
            if (previous < 0) {
                previous = 0;
            }
            URI previousUri = builder.clone().build(previous, size);
            Link previousLink = Link.fromUri(previousUri)
                    .rel("previous")
                    .type("application/json").build();
            links.add(previousLink);
        }

        //         List<Projet> projets;
        //Pour chaque bailleur definir son link
        //pour chaque bailleur faire un lien vers sa liste de projets
        //pour chaque bailleur faire un lien vers sa liste de projets
        //mise en oeuvre de l'implementation Hateoas
        //boucle for sur chaque bailleur
        //Introduire son champ self (lui-meme) qui fait reference à son lien

            for (Bailleur bailleur : bailleurs) {
                 //pour chaque bailleur dans la liste
     //trouver l'URI vers sa ressource provenant de la recherche par id se trouvant dans la methode getbyId

//    UriBuilder builder = UriBuilder.fromUri(uriInfo.getRequestUri());
////        builder.host("{hostname}");
//        builder.path(BailleurRestController.class,"getById");
//        UriBuilder clone = builder.clone();
//            URI uri = clone.build(uriInfo.getPath(), bailleur.getId());
         Link lien=Link.fromUri(uriInfo.getBaseUriBuilder()
                            .path(getClass())
                            .path(getClass(), "getById")
                            .build(bailleur.getId()))
                                .rel(bailleur.getNom())
                                .type("GET").build();
         bailleur.setSelf(lien);
         Response.accepted(bailleur)
                    .links(bailleur.getSelf())

                     .build();
         //setter pour fixer le lien vers cette ressource
                bailleur.setSelf(lien);
            }
        Bailleurs listBailleurs = new Bailleurs();
        //on la remplit de la liste provenant de la base de donnée
        listBailleurs.setBailleurs(bailleurs);
        //on lui met ses liens
        listBailleurs.setLinks(links);
        //on retourne la reponse à la requete
        return listBailleurs;

//        bailleurs.stream().map((bailleur) -> {
//     //pour chaque bailleur dans la liste
//     //trouver l'URI vers sa ressource provenant de la recherche par id se trouvant dans la methode getbyId
//
////    UriBuilder builder = UriBuilder.fromUri(uriInfo.getRequestUri());
//////        builder.host("{hostname}");
////        builder.path(BailleurRestController.class,"getById");
////        UriBuilder clone = builder.clone();
////            URI uri = clone.build(uriInfo.getPath(), bailleur.getId());
//         Link lien=Link.fromUri(uriInfo.getBaseUriBuilder()
//                            .path(getClass())
//                            .path(getClass(), "getById")
//                            .build(bailleur.getId()))
//                                .rel(bailleur.getNom())
//                                .type("GET").build();
////            UriBuilder.fromUri(uriInfo.getAbsolutePath())
////                    .path("pers/{id}")
////                    .queryParam("id", "{id}")
////                    .build("user", "sam");
////            bailleur.setSelf(
////                    Link.fromUri(uriInfo.getAbsolutePath())
////                            .rel("self")
////                            .type("GET")
////                            .build());
////                bailleur.setSelf(
////                    Link.fromUri(uri)
////                            .rel("self")
////                            .type("GET")
////                            .build());
//        
////
//            return bailleur;
//        }).forEach((bailleur) -> {
//            Response.accepted(bailleur)
//                    .links(bailleur.getSelf())
//
//                     .build();
//        });
//        return Response.accepted(bailleurs).build();
//on fait appel à la ressource Bailleurs qui est une collection de la ressource BAilleur
    }

    @GET
    @Path("/pers/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id) throws SQLException {

        Bailleur bailleur = bailleurRepository.findByPropertyUnique("id", id);

        if (bailleur != null) {
            bailleur.setSelf(
                    Link.fromUri(uriInfo.getAbsolutePath())
                    .rel("self")
                    .type("GET")
                    .build());
            return Response.accepted(bailleur).links(bailleur.getSelf()).build();
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
