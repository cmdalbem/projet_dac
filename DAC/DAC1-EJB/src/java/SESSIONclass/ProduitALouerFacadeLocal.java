/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SESSIONclass;

import ENTITYclass.ProduitALouer;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author davide
 */
@Local
public interface ProduitALouerFacadeLocal {

    void create(ProduitALouer produitALouer);

    void edit(ProduitALouer produitALouer);

    void remove(ProduitALouer produitALouer);

    ProduitALouer find(Object id);

    List<ProduitALouer> findAll();

    List<ProduitALouer> findRange(int[] range);

    int count();
    
}
