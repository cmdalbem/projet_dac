/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SESSIONclass;

import ENTITYclass.CarteFidelite;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author davide
 */
@Local
public interface CarteFideliteFacadeLocal {

    void create(CarteFidelite carteFidelite);

    void edit(CarteFidelite carteFidelite);

    void remove(CarteFidelite carteFidelite);

    CarteFidelite find(Object id);

    List<CarteFidelite> findAll();

    List<CarteFidelite> findRange(int[] range);

    int count();
    
}
