
package com.bootcamp.jpa.repository;

import com.bootcamp.entity.Projet;

/**
 *
 * @author soul
 * 
 */
public class ProjetRepository extends BaseRepository<Projet> {
    
    public ProjetRepository(String persistUnit) {
        super(persistUnit,Projet.class);
    }
    
}
