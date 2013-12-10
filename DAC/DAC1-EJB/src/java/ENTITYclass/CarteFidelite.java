
package ENTITYclass;

import java.io.Serializable;
import java.util.Collection;
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



@Entity
@Table(name = "carteFidelite")

@NamedQueries({
    @NamedQuery(name = "CarteFidelite.findAll", query = "SELECT c FROM CarteFidelite c"),
    @NamedQuery(name = "CarteFidelite.findByNumCarte", query = "SELECT c FROM CarteFidelite c WHERE c.numCarte = :numCarte"),
    @NamedQuery(name = "CarteFidelite.findByPoints", query = "SELECT c FROM CarteFidelite c WHERE c.points = :points")})
public class CarteFidelite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_carte")
    private Integer numCarte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "points")
    private int points;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numCarte")
    private Collection<Client> clientCollection;

    public CarteFidelite() {
    }

    public CarteFidelite(Integer numCarte) {
        this.numCarte = numCarte;
    }

    public CarteFidelite(Integer numCarte, int points) {
        this.numCarte = numCarte;
        this.points = points;
    }

    public Integer getNumCarte() {
        return numCarte;
    }

    public void setNumCarte(Integer numCarte) {
        this.numCarte = numCarte;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Collection<Client> getClientCollection() {
        return clientCollection;
    }

    public void setClientCollection(Collection<Client> clientCollection) {
        this.clientCollection = clientCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numCarte != null ? numCarte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarteFidelite)) {
            return false;
        }
        CarteFidelite other = (CarteFidelite) object;
        if ((this.numCarte == null && other.numCarte != null) || (this.numCarte != null && !this.numCarte.equals(other.numCarte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTITYclass.CarteFidelite[ numCarte=" + numCarte + " ]";
    }
    
}
