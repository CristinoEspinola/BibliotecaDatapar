
package model;

import entity.Libros;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class LibrosFacade extends AbstractFacade<Libros> implements LibrosFacadeLocal {

    @PersistenceContext(unitName = "biblioteca_datapar-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LibrosFacade() {
        super(Libros.class);
    }
    
}
