/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bsb.riskoperons.dao;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import pl.com.bsb.riskoperons.to.RiskOperonTO;

/**
 *
 * @author Grzegorz
 */
@Stateless
public class RiskOperonsListFacade {
    
    @PersistenceContext(unitName = "riskoperonsPU")
    private EntityManager em;

    public List<RiskOperonTO> findRiskOperonsEntries() {
        final Query query = em.createQuery("");
        List<RiskOperonTO> entries = query.getResultList();
        if (entries == null) {
            entries = new ArrayList<RiskOperonTO>();
        }
        return entries;
    }
}
