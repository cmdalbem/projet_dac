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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "produitaacheter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produitaacheter.findAll", query = "SELECT p FROM Produitaacheter p"),
    @NamedQuery(name = "Produitaacheter.findByIdProduit", query = "SELECT p FROM Produitaacheter p WHERE p.idProduit = :idProduit"),
    @NamedQuery(name = "Produitaacheter.findByPhoto", query = "SELECT p FROM Produitaacheter p WHERE p.photo = :photo")})
public class Produitaacheter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProduit")
    private Integer idProduit;
    @Size(max = 100)
    @Column(name = "photo")
    private String photo;
    @JoinColumn(name = "idProduit", referencedColumnName = "idProduit", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Produit produit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produitaacheter", fetch = FetchType.LAZY)
    private Collection<Achete> acheteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produitaacheter", fetch = FetchType.LAZY)
    private Collection<Possedestockachat> possedestockachatCollection;

    public Produitaacheter() {
    }

    public Produitaacheter(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public Integer getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @XmlTransient
    public Collection<Achete> getAcheteCollection() {
        return acheteCollection;
    }

    public void setAcheteCollection(Collection<Achete> acheteCollection) {
        this.acheteCollection = acheteCollection;
    }

    @XmlTransient
    public Collection<Possedestockachat> getPossedestockachatCollection() {
        return possedestockachatCollection;
    }

    public void setPossedestockachatCollection(Collection<Possedestockachat> possedestockachatCollection) {
        this.possedestockachatCollection = possedestockachatCollection;
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
        if (!(object instanceof Produitaacheter)) {
            return false;
        }
        Produitaacheter other = (Produitaacheter) object;
        if ((this.idProduit == null && other.idProduit != null) || (this.idProduit != null && !this.idProduit.equals(other.idProduit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Produitaacheter[ idProduit=" + idProduit + " ]";
    }
    
}
