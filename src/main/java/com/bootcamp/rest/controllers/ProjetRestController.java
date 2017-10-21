
package com.bootcamp.rest.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.bootcamp.entity.Projet;
import com.bootcamp.jpa.repository.ProjetRepository;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Ibrahim
 */

@Path("/projet")
public class ProjetRestController {
    
    //instanciation d'un livrable repository
    
    ProjetRepository projetRepository=new ProjetRepository("PostgresPuWeb");
   
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getList() throws SQLException{
       
       List<Projet> projets= projetRepository.findAll();
        return Response.status(200).entity(projets).build();

    }
    
     @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id) throws SQLException {
                 
       Projet projet = projetRepository.findByPropertyUnique("id", id);
        
        if(projet != null)
            return Response.status(200).entity(projet).build();
        else
            return Response.status(404).entity(projet).build();
    }
    
    @POST
    @Path("/create")
//    @Produces(MediaType.)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Projet projet) {
     String output = " Félicitations objet créé avec succès : ";
        try {
            projetRepository.create(projet);
           return Response.status(200).entity(output + projet.getNom()).build();
        } catch (SQLException ex) {
            return Response.status(404).entity("Erreur: Objet non créé").build();
        
        }
    

    }
    
      @PUT
    @Path("/update")
//    @Produces(MediaType.)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Projet projet) {
     String output = " Félicitations Mise à jour effectuée avec succès pour : ";
        try {
            projetRepository.update(projet);
            return Response.status(200).entity(output + projet.getNom()).build();
        } catch (SQLException ex) {
            return Response.status(404).entity("Erreur: Objet non mis à jour").build();
        }
        

    }

}
