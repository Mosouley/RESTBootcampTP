
package com.bootcamp.jpa.repository;

import com.bootcamp.entity.Bailleur;

/**
 *
 * @author soul
 * 
 */
public class BailleurRepository extends BaseRepository<Bailleur>{
 
    public BailleurRepository(String persistUnit) {
        super(persistUnit,Bailleur.class);
    }
  
}
