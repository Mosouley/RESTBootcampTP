
package com.bootcamp.rest.controllers;

import com.bootcamp.entity.IndicateurQualitatif;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.bootcamp.entity.Livrable;
import com.bootcamp.jpa.repository.IndicateurQualitatifRepository;
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

@Path("/ind/qualit")
public class IndicateurQualitatifRestController {
    
    //instanciation d'un livrable repository
    
    IndicateurQualitatifRepository indQualiRepository=new IndicateurQualitatifRepository("PostgresPuWeb");
   
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getList() throws SQLException{
       
       List<IndicateurQualitatif> donnees= indQualiRepository.findAll();
        return Response.status(200).entity(donnees).build();

    }
    
     @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id) throws SQLException {
                 
       IndicateurQualitatif ind = indQualiRepository.findByPropertyUnique("id", id);
        
        if(ind != null)
            return Response.status(200).entity(ind).build();
        else
            return Response.status(404).entity(ind).build();
    }
    
    @POST
    @Path("/create")
//    @Produces(MediaType.)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(IndicateurQualitatif ind) {
     String output = " Félicitations objet créé avec succès : ";
        try {
            indQualiRepository.create(ind);
           return Response.status(200).entity(output + ind.getNom()).build();
        } catch (SQLException ex) {
            return Response.status(404).entity("Erreur: Objet non créé").build();
        
        }
    

    }
    
      @PUT
    @Path("/update")
//    @Produces(MediaType.)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(IndicateurQualitatif ind) {
     String output = " Félicitations Mise à jour effectuée avec succès pour : ";
        try {
            indQualiRepository.update(ind);
            return Response.status(200).entity(output + ind.getNom()).build();
        } catch (SQLException ex) {
            return Response.status(404).entity("Erreur: Objet non mis à jour").build();
        }
        

    }

}
