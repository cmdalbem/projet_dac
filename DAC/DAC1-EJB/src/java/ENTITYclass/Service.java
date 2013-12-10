
package ENTITYclass;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 *
 * @author davide
 */
@Entity
@Table(name = "service")
@NamedQueries({
    @NamedQuery(name = "Service.findAll", query = "SELECT s FROM Service s"),
    @NamedQuery(name = "Service.findByIdProduit", query = "SELECT s FROM Service s WHERE s.idProduit = :idProduit")})
public class Service implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProduit")
    private Integer idProduit;
    @Lob
    @Size(max = 65535)
    @Column(name = "time_description")
    private String timeDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "service")
    private Collection<AcheteService> acheteServiceCollection;
    @JoinColumn(name = "idProduit", referencedColumnName = "idProduit", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Produit produit;

    public Service() {
    }

    public Service(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public Integer getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public String getTimeDescription() {
        return timeDescription;
    }

    public void setTimeDescription(String timeDescription) {
        this.timeDescription = timeDescription;
    }

    public Collection<AcheteService> getAcheteServiceCollection() {
        return acheteServiceCollection;
    }

    public void setAcheteServiceCollection(Collection<AcheteService> acheteServiceCollection) {
        this.acheteServiceCollection = acheteServiceCollection;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduit != null ? idProduit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Service)) {
            return false;
        }
        Service other = (Service) object;
        if ((this.idProduit == null && other.idProduit != null) || (this.idProduit != null && !this.idProduit.equals(other.idProduit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTITYclass.Service[ idProduit=" + idProduit + " ]";
    }
    
}
