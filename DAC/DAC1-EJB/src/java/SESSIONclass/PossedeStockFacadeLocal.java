/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SESSIONclass;

import ENTITYclass.PossedeStock;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author davide
 */
@Local
public interface PossedeStockFacadeLocal {

    void create(PossedeStock possedeStock);

    void edit(PossedeStock possedeStock);

    void remove(PossedeStock possedeStock);

    PossedeStock find(Object id);

    List<PossedeStock> findAll();

    List<PossedeStock> findRange(int[] range);

    int count();
    
}
