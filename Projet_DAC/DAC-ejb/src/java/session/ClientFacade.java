/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;


import entity.Cartefidelite;
import entity.Client;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author DARK
 */
@Stateless
public class ClientFacade extends AbstractFacade<Client> {
    @PersistenceContext(unitName = "DAC-ejbPU")
    private EntityManager em;
    @EJB
private CartefideliteFacade cartefideliteFacade;
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }
    public void creerClient( String nom, String prenom, String adresse, long telephone, String mail, String mdp, Date dateNaissance)
     {
        
         Cartefidelite carte=cartefideliteFacade.creerCarte();
        
         Client c=new Client(  nom,  prenom,  adresse,  telephone,  mail,  mdp,  dateNaissance,carte);
         create(c);
        
        
     }
    
    
    /*
     public void creerClient( String nom, String prenom, String adresse, long telephone, String mail, String mdp, Date dateNaissance,Integer numCarte)
     {
         
         Client c=new Client(  nom,  prenom,  adresse,  telephone,  mail,  mdp,  dateNaissance,  cartefideliteFacade.find( numCarte));
         create(c);  
     }
     */
     
    public void supprimerClient(Integer id)
     {
         Client c=find(id);
         remove(c);
     }
}
