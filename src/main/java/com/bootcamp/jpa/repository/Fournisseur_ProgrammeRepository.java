
package com.bootcamp.jpa.repository;

import com.bootcamp.entity.Fournisseur_Programme;

/**
 *
 * @author soul
 */
public class Fournisseur_ProgrammeRepository extends BaseRepository<Fournisseur_Programme> {
    
    public Fournisseur_ProgrammeRepository(String persistUnit) {
        super(persistUnit, Fournisseur_Programme.class);
    }
    
}
