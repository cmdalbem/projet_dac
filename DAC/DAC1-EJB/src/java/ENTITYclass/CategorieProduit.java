
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
import javax.validation.constraints.Size;



@Entity
@Table(name = "categorieProduit")
@NamedQueries({
    @NamedQuery(name = "CategorieProduit.findAll", query = "SELECT c FROM CategorieProduit c"),
    @NamedQuery(name = "CategorieProduit.findByIdCategorie", query = "SELECT c FROM CategorieProduit c WHERE c.idCategorie = :idCategorie"),
    @NamedQuery(name = "CategorieProduit.findByNom", query = "SELECT c FROM CategorieProduit c WHERE c.nom = :nom"),
    @NamedQuery(name = "CategorieProduit.findBySaison", query = "SELECT c FROM CategorieProduit c WHERE c.saison = :saison")})
public class CategorieProduit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCategorie")
    private Integer idCategorie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "saison")
    private String saison;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategorie")
    private Collection<Produit> produitCollection;

    public CategorieProduit() {
    }

    public CategorieProduit(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    public CategorieProduit(Integer idCategorie, String nom, String saison) {
        this.idCategorie = idCategorie;
        this.nom = nom;
        this.saison = saison;
    }

    public Integer getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSaison() {
        return saison;
    }

    public void setSaison(String saison) {
        this.saison = saison;
    }


    public Collection<Produit> getProduitCollection() {
        return produitCollection;
    }

    public void setProduitCollection(Collection<Produit> produitCollection) {
        this.produitCollection = produitCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategorie != null ? idCategorie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategorieProduit)) {
            return false;
        }
        CategorieProduit other = (CategorieProduit) object;
        if ((this.idCategorie == null && other.idCategorie != null) || (this.idCategorie != null && !this.idCategorie.equals(other.idCategorie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTITYclass.CategorieProduit[ idCategorie=" + idCategorie + " ]";
    }
    
}
