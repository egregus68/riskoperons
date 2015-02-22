/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bsb.riskoperons.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pl.com.bsb.riskoperons.model.DatabaseLayer;

/**
 *
 * @author Grzegorz
 */
@Stateless
public class DatabaseLayerFacade extends AbstractFacade<DatabaseLayer> {
    @PersistenceContext(unitName = "riskoperonsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DatabaseLayerFacade() {
        super(DatabaseLayer.class);
    }
    
}
