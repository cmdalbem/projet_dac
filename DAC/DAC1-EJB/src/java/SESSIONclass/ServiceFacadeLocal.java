/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SESSIONclass;

import ENTITYclass.Service;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author davide
 */
@Local
public interface ServiceFacadeLocal {

    void create(Service service);

    void edit(Service service);

    void remove(Service service);

    Service find(Object id);

    List<Service> findAll();

    List<Service> findRange(int[] range);

    int count();
    
}
