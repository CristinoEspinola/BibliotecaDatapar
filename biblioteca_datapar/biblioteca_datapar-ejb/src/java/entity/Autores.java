
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "autores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autores.findAll", query = "SELECT a FROM Autores a")
    , @NamedQuery(name = "Autores.findByIdAutores", query = "SELECT a FROM Autores a WHERE a.idAutores = :idAutores")
    , @NamedQuery(name = "Autores.findByNombres", query = "SELECT a FROM Autores a WHERE a.nombres = :nombres")
    , @NamedQuery(name = "Autores.findByApellidos", query = "SELECT a FROM Autores a WHERE a.apellidos = :apellidos")})
public class Autores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_autores")
    private Integer idAutores;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellidos")
    private String apellidos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAutores")
    private List<Libros> librosList;

    public Autores() {
    }

    public Autores(Integer idAutores) {
        this.idAutores = idAutores;
    }

    public Autores(Integer idAutores, String nombres, String apellidos) {
        this.idAutores = idAutores;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public Integer getIdAutores() {
        return idAutores;
    }

    public void setIdAutores(Integer idAutores) {
        this.idAutores = idAutores;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @XmlTransient
    public List<Libros> getLibrosList() {
        return librosList;
    }

    public void setLibrosList(List<Libros> librosList) {
        this.librosList = librosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAutores != null ? idAutores.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autores)) {
            return false;
        }
        Autores other = (Autores) object;
        if ((this.idAutores == null && other.idAutores != null) || (this.idAutores != null && !this.idAutores.equals(other.idAutores))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Autores[ idAutores=" + idAutores + " ]";
    }
    
}
