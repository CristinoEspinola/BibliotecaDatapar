
package model;

import entity.Autores;
import java.util.List;
import javax.ejb.Local;


@Local
public interface AutoresFacadeLocal {

    void create(Autores autores);

    void edit(Autores autores);

    void remove(Autores autores);

    Autores find(Object id);

    List<Autores> findAll();

    List<Autores> findRange(int[] range);

    int count();
    
}
