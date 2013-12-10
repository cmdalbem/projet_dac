/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SESSIONclass;

import ENTITYclass.Commente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author davide
 */
@Local
public interface CommenteFacadeLocal {

    void create(Commente commente);

    void edit(Commente commente);

    void remove(Commente commente);

    Commente find(Object id);

    List<Commente> findAll();

    List<Commente> findRange(int[] range);

    int count();
    
}
