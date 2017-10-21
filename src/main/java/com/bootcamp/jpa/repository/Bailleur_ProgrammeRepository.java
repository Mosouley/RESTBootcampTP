
package com.bootcamp.jpa.repository;

import com.bootcamp.entity.Bailleur_Programme;

/**
 *
 * @author soul
 */
public class Bailleur_ProgrammeRepository extends BaseRepository<Bailleur_Programme>{
    
    public Bailleur_ProgrammeRepository(String persistUnit) {
        super(persistUnit, Bailleur_Programme.class);
    }
    
}
