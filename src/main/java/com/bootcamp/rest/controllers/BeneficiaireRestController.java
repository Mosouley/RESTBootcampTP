
package com.bootcamp.rest.controllers;

import com.bootcamp.entity.Beneficiaire;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.bootcamp.jpa.repository.BeneficiaireRepository;
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

@Path("/beneficiaire")
public class BeneficiaireRestController {
    
     //instancie le repository beneficiaire
    BeneficiaireRepository beneficiaireRepository=new BeneficiaireRepository("PostgresPuWeb");
   
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getList() throws SQLException{
       
       List<Beneficiaire> donnees= beneficiaireRepository.findAll();
        return Response.status(200).entity(donnees).build();

    }
    
     @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id) throws SQLException {
        //rechercher le bene dont l'id est donné en parametre
       Beneficiaire bene = beneficiaireRepository.findByPropertyUnique("id", id);
        
        if(bene != null)
            return Response.status(200).entity(bene).build();
        else
            return Response.status(404).entity(bene).build();
    }
    
    @POST
    @Path("/create")
//    @Produces(MediaType.)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Beneficiaire bene) {
     String output = " Félicitations objet créé avec succès : ";
        try {
            beneficiaireRepository.create(bene);
           return Response.status(200).entity(output + bene.getNom()).build();
        } catch (SQLException ex) {
            return Response.status(404).entity("Erreur: Objet non créé").build();
        
        }
    

    }
    
      @PUT
    @Path("/update")
//    @Produces(MediaType.)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Beneficiaire bene) {
     String output = " Félicitations Mise à jour effectuée avec succès pour : ";
        try {
            beneficiaireRepository.update(bene);
            return Response.status(200).entity(output + bene.getNom()).build();
        } catch (SQLException ex) {
            return Response.status(404).entity("Erreur: Objet non mis à jour").build();
        }
        

    }

}
