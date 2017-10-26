/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.hateoas.rest.v1.ressources;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author soul
 */
public interface ItemResource {

    //Example: returning more than one Item
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<Item> getItems();
}
