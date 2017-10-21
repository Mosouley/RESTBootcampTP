
package com.bootcamp.jpa.repository;

import com.bootcamp.entity.Livrable;

/**
 *
 * @author soul
 * 
 */
public class LivrableRepository extends BaseRepository<Livrable> {
    
    public LivrableRepository(String persistUnit) {
        super(persistUnit,Livrable.class);
    }
    
}
