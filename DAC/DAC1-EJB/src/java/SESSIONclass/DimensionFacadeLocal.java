/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SESSIONclass;

import ENTITYclass.Dimension;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author davide
 */
@Local
public interface DimensionFacadeLocal {

    void create(Dimension dimension);

    void edit(Dimension dimension);

    void remove(Dimension dimension);

    Dimension find(Object id);

    List<Dimension> findAll();

    List<Dimension> findRange(int[] range);

    int count();
    
}
