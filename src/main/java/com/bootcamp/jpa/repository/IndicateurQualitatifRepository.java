
package com.bootcamp.jpa.repository;

import com.bootcamp.entity.IndicateurQualitatif;

/**
 *
 * @author soul
 * 
 */
public class IndicateurQualitatifRepository extends BaseRepository<IndicateurQualitatif> {
    
    public IndicateurQualitatifRepository(String persistUnit) {
        super(persistUnit,IndicateurQualitatif.class);
    }
    
    
}
