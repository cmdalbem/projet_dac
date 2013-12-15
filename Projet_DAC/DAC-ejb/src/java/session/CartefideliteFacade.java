/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Cartefidelite;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author DARK
 */
@Stateless
public class CartefideliteFacade extends AbstractFacade<Cartefidelite> {
    @PersistenceContext(unitName = "DAC-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CartefideliteFacade() {
        super(Cartefidelite.class);
    }
    
    public Cartefidelite creerCarte( )
     {
         
         Cartefidelite c=new Cartefidelite( );
         create(c);
         //em.refresh(c);
         return(c);
     }
     public Cartefidelite findCarte(Integer num)
     {
          
         return(find(num));
         
     }
     
     
    
}
