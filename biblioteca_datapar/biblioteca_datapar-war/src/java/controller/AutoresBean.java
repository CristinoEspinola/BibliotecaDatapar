
package controller;

import entity.Autores;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import model.AutoresFacadeLocal;


@Named(value = "autoresBean")
@RequestScoped
public class AutoresBean {

    @EJB
    private AutoresFacadeLocal autoresFacade;
    private Autores autores;
    
    
    public AutoresBean() {
        autores = new Autores();
    }
    
    public List<Autores>getAutoreses(){
        return autoresFacade.findAll();
    }
    
    public void guardar(){
        if(autores.getIdAutores()==null){
            autoresFacade.create(autores);
        }else{
            autoresFacade.edit(autores);
        }
        autores = new Autores();
    }
    
    public void eliminar(Autores autores){
        if(autores.getIdAutores()!=null){
            autoresFacade.remove(autores);
        }
    }
    

    public Autores getAutores() {
        return autores;
    }

    public void setAutores(Autores autores) {
        this.autores = autores;
    }
    
    
    
    
}
