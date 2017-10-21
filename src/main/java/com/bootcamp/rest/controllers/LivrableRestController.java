
package com.bootcamp.rest.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.bootcamp.entity.Livrable;
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

@Path("/livrable")
public class LivrableRestController {
    
    //instanciation d'un livrable repository
    
    LivrableRepository livrableRepository=new LivrableRepository("PostgresPuWeb");
   
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getList() throws SQLException{
       
       List<Livrable> livrables= livrableRepository.findAll();
        return Response.status(200).entity(livrables).build();

    }
    
     @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id) throws SQLException {
                 
       Livrable livrable = livrableRepository.findByPropertyUnique("id", id);
        
        if(livrable != null)
            return Response.status(200).entity(livrable).build();
        else
            return Response.status(404).entity(livrable).build();
    }
    
    @POST
    @Path("/create")
//    @Produces(MediaType.)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Livrable livrable) {
     String output = " Félicitations objet créé avec succès : ";
        try {
            livrableRepository.create(livrable);
           return Response.status(200).entity(output + livrable.getNom()).build(); 
        } catch (SQLException ex) {
            return Response.status(404).entity("Erreur: Objet non créé").build();
        
        }
    

    }
    
      @PUT
    @Path("/update")
//    @Produces(MediaType.)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Livrable livrable) {
     String output = " Félicitations Mise à jour effectuée avec succès pour : ";
        try {
            livrableRepository.update(livrable);
            return Response.status(200).entity(output + livrable.getNom()).build();
        } catch (SQLException ex) {
            return Response.status(404).entity("Erreur: Objet non mis à jour").build();
        }
        

    }

}
