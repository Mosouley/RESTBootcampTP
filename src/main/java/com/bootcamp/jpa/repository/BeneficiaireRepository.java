
package com.bootcamp.jpa.repository;

import com.bootcamp.entity.Beneficiaire;

/**
 *
 * @author soul
 * 
 */
public class BeneficiaireRepository extends BaseRepository<Beneficiaire> {
   
    public BeneficiaireRepository(String persistUnit) {
        super(persistUnit,Beneficiaire.class);
    }
   
    
}
