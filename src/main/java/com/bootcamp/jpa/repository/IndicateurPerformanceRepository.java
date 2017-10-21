
package com.bootcamp.jpa.repository;

import com.bootcamp.entity.IndicateurPerformance;


/**
 *
 * @author soul
 * implementation du repository de base
 */
public class IndicateurPerformanceRepository extends BaseRepository<IndicateurPerformance>{
    
    public IndicateurPerformanceRepository(String persistUnit) {
        super(persistUnit,IndicateurPerformance.class);
    }
    
}
