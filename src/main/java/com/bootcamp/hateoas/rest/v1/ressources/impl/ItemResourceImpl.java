package com.bootcamp.hateoas.rest.v1.ressources.impl;

import com.bootcamp.hateoas.rest.v1.ressources.Item;
import com.bootcamp.hateoas.rest.v1.ressources.ItemResource;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Path;

/**
 *
 * @author soul
 * Implementation de la classe ItemResource
 */
//Definir le path de la ressource, version 1 de l'API
@Path("/v1/item")
public class ItemResourceImpl implements ItemResource{

    @Override
    public List<Item> getItems() {

        List<Item> items=new ArrayList<>();
        items.add(new Item(100,"Widget","A basic widget"));
        items.add(new Item(200,"Superwidget","A super widget"));
        items.add(new Item(300,"UberSuperWidget","A uber super widget"));

        return items;
    }

}
