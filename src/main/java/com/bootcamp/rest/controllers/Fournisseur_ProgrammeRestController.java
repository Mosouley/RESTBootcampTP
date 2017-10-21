
package com.bootcamp.rest.controllers;

import com.bootcamp.entity.Fournisseur_Programme;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.bootcamp.jpa.repository.Fournisseur_ProgrammeRepository;
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

@Path("/fourn/prog")
public class Fournisseur_ProgrammeRestController {
    
    //instanciation d'un livrable repository
    
    Fournisseur_ProgrammeRepository four_progRepository=new Fournisseur_ProgrammeRepository("PostgresPuWeb");
   
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getList() throws SQLException{
       
       List<Fournisseur_Programme> donnees= four_progRepository.findAll();
        return Response.status(200).entity(donnees).build();

    }
    
     @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id) throws SQLException {
                 
       Fournisseur_Programme four_prog = four_progRepository.findByPropertyUnique("id", id);
        
        if(four_prog != null)
            return Response.status(200).entity(four_prog).build();
        else
            return Response.status(404).entity(four_prog).build();
    }
    
    @POST
    @Path("/create")
//    @Produces(MediaType.)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Fournisseur_Programme four_prog) {
     String output = " Félicitations objet créé avec succès : ";
        try {
            four_progRepository.create(four_prog);
           return Response.status(200).entity(output + four_prog.getCompteBancaire()).build();
        } catch (SQLException ex) {
            return Response.status(404).entity("Erreur: Objet non créé").build();
        
        }
    

    }
    
      @PUT
    @Path("/update")
//    @Produces(MediaType.)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Fournisseur_Programme four_prog) {
     String output = " Félicitations Mise à jour effectuée avec succès pour : ";
        try {
            four_progRepository.update(four_prog);
            return Response.status(200).entity(output + four_prog.getCompteBancaire()).build();
        } catch (SQLException ex) {
            return Response.status(404).entity("Erreur: Objet non mis à jour").build();
        }
        

    }

}
