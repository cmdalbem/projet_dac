/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SESSIONclass;

import ENTITYclass.ProduitALouer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author davide
 */
@Stateless
public class ProduitALouerFacade extends AbstractFacade<ProduitALouer> implements ProduitALouerFacadeLocal {
    @PersistenceContext(unitName = "DAC1-EJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProduitALouerFacade() {
        super(ProduitALouer.class);
    }
    
}
