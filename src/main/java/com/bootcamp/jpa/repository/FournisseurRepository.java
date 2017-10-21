
package com.bootcamp.jpa.repository;

import com.bootcamp.entity.Fournisseur;

/**
 *
 * @author soul
 * 
 */
public class FournisseurRepository extends BaseRepository<Fournisseur> {


    public FournisseurRepository(String persistUnit) {
        super(persistUnit,Fournisseur.class);
    }
    
   
    
}
