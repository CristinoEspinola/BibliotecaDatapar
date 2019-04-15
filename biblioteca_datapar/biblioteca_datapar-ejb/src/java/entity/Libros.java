
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "libros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libros.findAll", query = "SELECT l FROM Libros l")
    , @NamedQuery(name = "Libros.findByIdLibros", query = "SELECT l FROM Libros l WHERE l.idLibros = :idLibros")
    , @NamedQuery(name = "Libros.findByTitulo", query = "SELECT l FROM Libros l WHERE l.titulo = :titulo")
    , @NamedQuery(name = "Libros.findByEditorial", query = "SELECT l FROM Libros l WHERE l.editorial = :editorial")})
public class Libros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_libros")
    private Integer idLibros;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "editorial")
    private String editorial;
    @JoinColumn(name = "id_autores", referencedColumnName = "id_autores")
    @ManyToOne(optional = false)
    private Autores idAutores;

    public Libros() {
    }

    public Libros(Integer idLibros) {
        this.idLibros = idLibros;
    }

    public Libros(Integer idLibros, String titulo, String editorial) {
        this.idLibros = idLibros;
        this.titulo = titulo;
        this.editorial = editorial;
    }

    public Integer getIdLibros() {
        return idLibros;
    }

    public void setIdLibros(Integer idLibros) {
        this.idLibros = idLibros;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Autores getIdAutores() {
        return idAutores;
    }

    public void setIdAutores(Autores idAutores) {
        this.idAutores = idAutores;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLibros != null ? idLibros.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libros)) {
            return false;
        }
        Libros other = (Libros) object;
        if ((this.idLibros == null && other.idLibros != null) || (this.idLibros != null && !this.idLibros.equals(other.idLibros))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Libros[ idLibros=" + idLibros + " ]";
    }
    
}
