/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SESSIONclass;

import ENTITYclass.AcheteService;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author davide
 */
@Local
public interface AcheteServiceFacadeLocal {

    void create(AcheteService acheteService);

    void edit(AcheteService acheteService);

    void remove(AcheteService acheteService);

    AcheteService find(Object id);

    List<AcheteService> findAll();

    List<AcheteService> findRange(int[] range);

    int count();
    
}
