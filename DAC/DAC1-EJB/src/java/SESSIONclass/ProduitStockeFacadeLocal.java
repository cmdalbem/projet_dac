/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SESSIONclass;

import ENTITYclass.ProduitStocke;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author davide
 */
@Local
public interface ProduitStockeFacadeLocal {

    void create(ProduitStocke produitStocke);

    void edit(ProduitStocke produitStocke);

    void remove(ProduitStocke produitStocke);

    ProduitStocke find(Object id);

    List<ProduitStocke> findAll();

    List<ProduitStocke> findRange(int[] range);

    int count();
    
}
