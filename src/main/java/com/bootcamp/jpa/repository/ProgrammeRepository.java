
package com.bootcamp.jpa.repository;

import com.bootcamp.entity.Programme;

/**
 *
 * @author soul
 * 
 */
public class ProgrammeRepository extends BaseRepository<Programme> {
   
    public ProgrammeRepository(String persistUnit) {
        super(persistUnit,Programme.class);
    }
   
    
}
