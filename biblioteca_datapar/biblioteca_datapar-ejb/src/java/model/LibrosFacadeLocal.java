
package model;

import entity.Libros;
import java.util.List;
import javax.ejb.Local;


@Local
public interface LibrosFacadeLocal {

    void create(Libros libros);

    void edit(Libros libros);

    void remove(Libros libros);

    Libros find(Object id);

    List<Libros> findAll();

    List<Libros> findRange(int[] range);

    int count();
    
}
