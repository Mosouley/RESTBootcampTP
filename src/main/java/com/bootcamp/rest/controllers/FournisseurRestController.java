
package com.bootcamp.rest.controllers;

import com.bootcamp.entity.Fournisseur;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.bootcamp.jpa.repository.FournisseurRepository;
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

@Path("/fournisseur")
public class FournisseurRestController {
    
    //instanciation d'un livrable repository
    
    FournisseurRepository fournisseurRepository=new FournisseurRepository("PostgresPuWeb");
   
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getList() throws SQLException{
       
       List<Fournisseur> livrables= fournisseurRepository.findAll();
        return Response.status(200).entity(livrables).build();

    }
    
     @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id) throws SQLException {
                 
       Fournisseur fournisseur = fournisseurRepository.findByPropertyUnique("id", id);
        
        if(fournisseur != null)
            return Response.status(200).entity(fournisseur).build();
        else
            return Response.status(404).entity(fournisseur).build();
    }
    
    @POST
    @Path("/create")
//    @Produces(MediaType.)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Fournisseur fournisseur) {
     String output = " Félicitations objet créé avec succès : ";
        try {
            fournisseurRepository.create(fournisseur);
           return Response.status(200).entity(output + fournisseur.getNom()).build();
        } catch (SQLException ex) {
            return Response.status(404).entity("Erreur: Objet non créé").build();
        
        }
    

    }
    
      @PUT
    @Path("/update")
//    @Produces(MediaType.)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Fournisseur fournisseur) {
     String output = " Félicitations Mise à jour effectuée avec succès pour : ";
        try {
            fournisseurRepository.update(fournisseur);
            return Response.status(200).entity(output + fournisseur.getNom()).build();
        } catch (SQLException ex) {
            return Response.status(404).entity("Erreur: Objet non mis à jour").build();
        }
        

    }

}
