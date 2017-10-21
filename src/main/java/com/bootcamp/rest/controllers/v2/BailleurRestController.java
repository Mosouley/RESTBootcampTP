
package com.bootcamp.rest.controllers.v2;

import com.bootcamp.rest.controllers.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.bootcamp.entity.Bailleur;
import com.bootcamp.jpa.repository.BailleurRepository;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

@Path("/v2/bailleur")
public class BailleurRestController {
    
    //instanciation d'un bailleur repository
    
    BailleurRepository bailleurRepository=new BailleurRepository("PostgresPuWeb");
   
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getList() throws SQLException{
        
       // bailleur.setTypeDeBailleur(TypeDeBailleur.PRIVE);
       List<Bailleur> bailleurs= bailleurRepository.findAll();
        return Response.status(200).entity(bailleurs).build();

    }
    
     @GET
    @Path("/pers/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id) throws SQLException {
                 
       Bailleur bailleur = bailleurRepository.findByPropertyUnique("id", id);
        
        if(bailleur != null)
            return Response.status(200).entity(bailleur).build();
        else
            return Response.status(404).entity(bailleur).build();
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

}
