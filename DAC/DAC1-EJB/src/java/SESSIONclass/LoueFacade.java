/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SESSIONclass;

import ENTITYclass.Loue;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author davide
 */
@Stateless
public class LoueFacade extends AbstractFacade<Loue> implements LoueFacadeLocal {
    @PersistenceContext(unitName = "DAC1-EJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LoueFacade() {
        super(Loue.class);
    }
    
}
