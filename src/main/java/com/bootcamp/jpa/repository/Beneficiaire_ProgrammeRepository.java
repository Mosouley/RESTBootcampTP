
package com.bootcamp.jpa.repository;

import com.bootcamp.entity.Beneficiaire_Programme;

/**
 * impl du repository pour la nouvelle classe bene_program
 * @author soul
 */
public class Beneficiaire_ProgrammeRepository extends BaseRepository<Beneficiaire_Programme> {
    
    public Beneficiaire_ProgrammeRepository(String persistUnit) {
        super(persistUnit, Beneficiaire_Programme.class);
    }
    
}
