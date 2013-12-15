/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Categorieproduit;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author DARK
 */
@Stateless
public class CategorieproduitFacade extends AbstractFacade<Categorieproduit> {
    @PersistenceContext(unitName = "DAC-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategorieproduitFacade() {
        super(Categorieproduit.class);
    }
    
}
