/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SESSIONclass;

import ENTITYclass.CategorieProduit;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author davide
 */
@Local
public interface CategorieProduitFacadeLocal {

    void create(CategorieProduit categorieProduit);

    void edit(CategorieProduit categorieProduit);

    void remove(CategorieProduit categorieProduit);

    CategorieProduit find(Object id);

    List<CategorieProduit> findAll();

    List<CategorieProduit> findRange(int[] range);

    int count();
    
}
