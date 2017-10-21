
package com.bootcamp.rest.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.bootcamp.entity.Programme;
import com.bootcamp.jpa.repository.ProgrammeRepository;
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

@Path("/programme")
public class ProgrammeRestController {
    
    //instanciation d'un livrable repository
    
    ProgrammeRepository programmeRepository=new ProgrammeRepository("PostgresPuWeb");
   
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getList() throws SQLException{
       
       List<Programme> programmes= programmeRepository.findAll();
        return Response.status(200).entity(programmes).build();

    }
    
     @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id) throws SQLException {
                 
       Programme programme = programmeRepository.findByPropertyUnique("id", id);
        
        if(programme != null)
            return Response.status(200).entity(programme).build();
        else
            return Response.status(404).entity(programme).build();
    }
    
    @POST
    @Path("/create")
//    @Produces(MediaType.)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Programme programme) {
     String output = " Félicitations objet créé avec succès : ";
        try {
            programmeRepository.create(programme);
            return Response.status(200).entity(output + programme.getNom()).build();
        } catch (SQLException ex) {
              return Response.status(200).entity("Erreur création").build();
        }
   
    

    }
    
      @PUT
    @Path("/update")
//    @Produces(MediaType.)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Programme programme) {
     String output = " Félicitations Mise à jour effectuée avec succès pour : ";
        try {
            programmeRepository.update(programme);
             return Response.status(200).entity(output + programme.getNom()).build();
        } catch (SQLException ex) {
            return Response.status(200).entity("Erreur création").build();
        }
    
        

    }

}
