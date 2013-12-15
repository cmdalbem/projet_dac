/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DARK
 */
@Entity
@Table(name = "possedestocklocation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Possedestocklocation.findAll", query = "SELECT p FROM Possedestocklocation p"),
    @NamedQuery(name = "Possedestocklocation.findByIdProduit", query = "SELECT p FROM Possedestocklocation p WHERE p.possedestocklocationPK.idProduit = :idProduit"),
    @NamedQuery(name = "Possedestocklocation.findByIdDimension", query = "SELECT p FROM Possedestocklocation p WHERE p.possedestocklocationPK.idDimension = :idDimension"),
    @NamedQuery(name = "Possedestocklocation.findByStock", query = "SELECT p FROM Possedestocklocation p WHERE p.stock = :stock")})
public class Possedestocklocation implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PossedestocklocationPK possedestocklocationPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock")
    private int stock;
    @JoinColumn(name = "idDimension", referencedColumnName = "idDimension", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Dimension dimension;
    @JoinColumn(name = "idProduit", referencedColumnName = "idProduit", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Produitalouer produitalouer;

    public Possedestocklocation() {
    }

    public Possedestocklocation(PossedestocklocationPK possedestocklocationPK) {
        this.possedestocklocationPK = possedestocklocationPK;
    }

    public Possedestocklocation(PossedestocklocationPK possedestocklocationPK, int stock) {
        this.possedestocklocationPK = possedestocklocationPK;
        this.stock = stock;
    }

    public Possedestocklocation(int idProduit, int idDimension) {
        this.possedestocklocationPK = new PossedestocklocationPK(idProduit, idDimension);
    }

    public PossedestocklocationPK getPossedestocklocationPK() {
        return possedestocklocationPK;
    }

    public void setPossedestocklocationPK(PossedestocklocationPK possedestocklocationPK) {
        this.possedestocklocationPK = possedestocklocationPK;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public Produitalouer getProduitalouer() {
        return produitalouer;
    }

    public void setProduitalouer(Produitalouer produitalouer) {
        this.produitalouer = produitalouer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (possedestocklocationPK != null ? possedestocklocationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Possedestocklocation)) {
            return false;
        }
        Possedestocklocation other = (Possedestocklocation) object;
        if ((this.possedestocklocationPK == null && other.possedestocklocationPK != null) || (this.possedestocklocationPK != null && !this.possedestocklocationPK.equals(other.possedestocklocationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Possedestocklocation[ possedestocklocationPK=" + possedestocklocationPK + " ]";
    }
    
}
