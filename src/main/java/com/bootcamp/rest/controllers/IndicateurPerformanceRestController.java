
package com.bootcamp.rest.controllers;

import com.bootcamp.entity.IndicateurPerformance;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.bootcamp.jpa.repository.IndicateurPerformanceRepository;
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

@Path("/ind/perf")
public class IndicateurPerformanceRestController {
    
    //instanciation d'un livrable repository
    
    IndicateurPerformanceRepository indPerfRepo=new IndicateurPerformanceRepository("PostgresPuWeb");
   
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getList() throws SQLException{
       
       List<IndicateurPerformance> donnees= indPerfRepo.findAll();
        return Response.status(200).entity(donnees).build();

    }
    
     @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id) throws SQLException {
                 
       IndicateurPerformance indPerf = indPerfRepo.findByPropertyUnique("id", id);
        
        if(indPerf != null)
            return Response.status(200).entity(indPerf).build();
        else
            return Response.status(404).entity(indPerf).build();
    }
    
    @POST
    @Path("/create")
//    @Produces(MediaType.)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(IndicateurPerformance ind) {
     String output = " Félicitations objet créé avec succès : ";
        try {
            indPerfRepo.create(ind);
           return Response.status(200).entity(output + ind.getLibelle()).build();
        } catch (SQLException ex) {
            return Response.status(404).entity("Erreur: Objet non créé").build();
        
        }
    

    }
    
      @PUT
    @Path("/update")
//    @Produces(MediaType.)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(IndicateurPerformance ind) {
     String output = " Félicitations Mise à jour effectuée avec succès pour : ";
        try {
            indPerfRepo.update(ind);
            return Response.status(200).entity(output + ind.getLibelle()).build();
        } catch (SQLException ex) {
            return Response.status(404).entity("Erreur: Objet non mis à jour").build();
        }
        

    }

}
