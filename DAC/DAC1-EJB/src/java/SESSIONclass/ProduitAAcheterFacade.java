/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SESSIONclass;

import ENTITYclass.ProduitAAcheter;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author davide
 */
@Stateless
public class ProduitAAcheterFacade extends AbstractFacade<ProduitAAcheter> implements ProduitAAcheterFacadeLocal {
    @PersistenceContext(unitName = "DAC1-EJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProduitAAcheterFacade() {
        super(ProduitAAcheter.class);
    }
    
}
