/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SESSIONclass;

import ENTITYclass.CategorieProduit;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author davide
 */
@Stateless
public class CategorieProduitFacade extends AbstractFacade<CategorieProduit> implements CategorieProduitFacadeLocal {
    @PersistenceContext(unitName = "DAC1-EJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategorieProduitFacade() {
        super(CategorieProduit.class);
    }
    
}
