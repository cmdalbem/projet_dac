/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Acheteservice;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author DARK
 */
@Stateless
public class AcheteserviceFacade extends AbstractFacade<Acheteservice> {
    @PersistenceContext(unitName = "DAC-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AcheteserviceFacade() {
        super(Acheteservice.class);
    }
    
}
