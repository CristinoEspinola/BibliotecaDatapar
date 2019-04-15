
package controller;

import entity.Autores;
import entity.Libros;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import model.AutoresFacadeLocal;
import model.LibrosFacadeLocal;


@Named(value = "librosBean")
@RequestScoped
public class LibrosBean {

    @EJB
    private LibrosFacadeLocal librosFacade;
    private Libros libros;

    @EJB
    private AutoresFacadeLocal autoresFacade;
    private Autores autores;
    

    
    public LibrosBean() {
        libros = new Libros();
        autores = new Autores();
    }
    
    
    public List<Libros>getLibroses(){
        return librosFacade.findAll();
    }
    
    public List<Autores>getAutoreses(){
        return autoresFacade.findAll();
    }
    
    public void guardar(){
        libros.setIdAutores(autores);
        if(libros.getIdLibros() == null){
            librosFacade.create(libros);
        }else{
            librosFacade.edit(libros);
        }
        libros = new Libros();
        autores = new Autores();
    }
    
    
    public void eliminar(Libros libros){
        if(libros.getIdLibros() != null){
            librosFacade.remove(libros);
        }
    }
    
    

    public Libros getLibros() {
        return libros;
    }

    public void setLibros(Libros libros) {
        this.libros = libros;
        this.autores = libros.getIdAutores();
    }

    public Autores getAutores() {
        return autores;
    }

    public void setAutores(Autores autores) {
        this.autores = autores;
    }
    
    
    
}
