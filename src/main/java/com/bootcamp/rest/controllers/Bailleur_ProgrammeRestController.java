
package com.bootcamp.rest.controllers;

import com.bootcamp.entity.Bailleur_Programme;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.bootcamp.entity.Livrable;
import com.bootcamp.jpa.repository.Bailleur_ProgrammeRepository;
import com.bootcamp.jpa.repository.LivrableRepository;
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

@Path("/bail/prog")
public class Bailleur_ProgrammeRestController {
    
    //instanciation d'un livrable repository
    
    Bailleur_ProgrammeRepository bail_progRepository=new Bailleur_ProgrammeRepository("PostgresPuWeb");
   
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getList() throws SQLException{
       
       List<Bailleur_Programme> donnees= bail_progRepository.findAll();
        return Response.status(200).entity(donnees).build();

    }
    
     @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id) throws SQLException {
                 
       Bailleur_Programme bail_prog = bail_progRepository.findByPropertyUnique("id", id);
        
        if(bail_prog != null)
            return Response.status(200).entity(bail_prog).build();
        else
            return Response.status(404).entity(bail_prog).build();
    }
    
    @POST
    @Path("/create")
//    @Produces(MediaType.)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Bailleur_Programme obj) {
     String output = " Félicitations objet créé avec succès et son capital est: ";
        try {
            bail_progRepository.create(obj);
           return Response.status(200).entity(output+obj.getCapital()).build();
        } catch (SQLException ex) {
            return Response.status(404).entity("Erreur: Objet non créé").build();
                }
    }
    
      @PUT
    @Path("/update")
//    @Produces(MediaType.)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Bailleur_Programme obj) {
     String output = " Félicitations Mise à jour effectuée avec succès pour : ";
        try {
            bail_progRepository.update(obj);
            return Response.status(200).entity(output).build();
        } catch (SQLException ex) {
            return Response.status(404).entity("Erreur: Objet non mis à jour").build();
        }
        

    }

}
