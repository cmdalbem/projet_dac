/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SESSIONclass;

import ENTITYclass.Achete;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author davide
 */
@Local
public interface AcheteFacadeLocal {

    void create(Achete achete);

    void edit(Achete achete);

    void remove(Achete achete);

    Achete find(Object id);

    List<Achete> findAll();

    List<Achete> findRange(int[] range);

    int count();
    
}
