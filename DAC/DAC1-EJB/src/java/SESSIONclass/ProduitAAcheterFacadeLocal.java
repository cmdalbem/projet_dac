/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SESSIONclass;

import ENTITYclass.ProduitAAcheter;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author davide
 */
@Local
public interface ProduitAAcheterFacadeLocal {

    void create(ProduitAAcheter produitAAcheter);

    void edit(ProduitAAcheter produitAAcheter);

    void remove(ProduitAAcheter produitAAcheter);

    ProduitAAcheter find(Object id);

    List<ProduitAAcheter> findAll();

    List<ProduitAAcheter> findRange(int[] range);

    int count();
    
}
