
package ENTITYclass;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "produitAAcheter")
@NamedQueries({
    @NamedQuery(name = "ProduitAAcheter.findAll", query = "SELECT p FROM ProduitAAcheter p"),
    @NamedQuery(name = "ProduitAAcheter.findByIdProduit", query = "SELECT p FROM ProduitAAcheter p WHERE p.idProduit = :idProduit")})
public class ProduitAAcheter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProduit")
    private Integer idProduit;
    @JoinColumn(name = "idProduit", referencedColumnName = "idProduit", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private ProduitStocke produitStocke;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produitAAcheter")
    private Collection<Achete> acheteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produitAAcheter")
    private Collection<Loue> loueCollection;

    public ProduitAAcheter() {
    }

    public ProduitAAcheter(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public Integer getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public ProduitStocke getProduitStocke() {
        return produitStocke;
    }

    public void setProduitStocke(ProduitStocke produitStocke) {
        this.produitStocke = produitStocke;
    }

    
    public Collection<Achete> getAcheteCollection() {
        return acheteCollection;
    }

    public void setAcheteCollection(Collection<Achete> acheteCollection) {
        this.acheteCollection = acheteCollection;
    }

    
    public Collection<Loue> getLoueCollection() {
        return loueCollection;
    }

    public void setLoueCollection(Collection<Loue> loueCollection) {
        this.loueCollection = loueCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduit != null ? idProduit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        //  Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProduitAAcheter)) {
            return false;
        }
        ProduitAAcheter other = (ProduitAAcheter) object;
        if ((this.idProduit == null && other.idProduit != null) || (this.idProduit != null && !this.idProduit.equals(other.idProduit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTITYclass.ProduitAAcheter[ idProduit=" + idProduit + " ]";
    }
    
}
