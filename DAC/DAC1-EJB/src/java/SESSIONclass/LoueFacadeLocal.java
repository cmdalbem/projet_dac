/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SESSIONclass;

import ENTITYclass.Loue;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author davide
 */
@Local
public interface LoueFacadeLocal {

    void create(Loue loue);

    void edit(Loue loue);

    void remove(Loue loue);

    Loue find(Object id);

    List<Loue> findAll();

    List<Loue> findRange(int[] range);

    int count();
    
}
