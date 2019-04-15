
package model;

import entity.Autores;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class AutoresFacade extends AbstractFacade<Autores> implements AutoresFacadeLocal {

    @PersistenceContext(unitName = "biblioteca_datapar-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AutoresFacade() {
        super(Autores.class);
    }
    
}
