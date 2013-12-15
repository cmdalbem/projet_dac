/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

/**
 *
 * @author DARK
 */
@Entity
@Table(name = "categorieproduit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categorieproduit.findAll", query = "SELECT c FROM Categorieproduit c"),
    @NamedQuery(name = "Categorieproduit.findByIdCategorie", query = "SELECT c FROM Categorieproduit c WHERE c.idCategorie = :idCategorie"),
    @NamedQuery(name = "Categorieproduit.findByNom", query = "SELECT c FROM Categorieproduit c WHERE c.nom = :nom"),
    @NamedQuery(name = "Categorieproduit.findBySaison", query = "SELECT c FROM Categorieproduit c WHERE c.saison = :saison")})
public class Categorieproduit implements Serializable {
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategorie", fetch = FetchType.LAZY)
    private Collection<Produit> produitCollection;

    public Categorieproduit() {
    }

    public Categorieproduit(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    public Categorieproduit(Integer idCategorie, String nom, String saison) {
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

    @XmlTransient
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
        if (!(object instanceof Categorieproduit)) {
            return false;
        }
        Categorieproduit other = (Categorieproduit) object;
        if ((this.idCategorie == null && other.idCategorie != null) || (this.idCategorie != null && !this.idCategorie.equals(other.idCategorie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Categorieproduit[ idCategorie=" + idCategorie + " ]";
    }
    
}
