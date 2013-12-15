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
@Table(name = "possedestockachat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Possedestockachat.findAll", query = "SELECT p FROM Possedestockachat p"),
    @NamedQuery(name = "Possedestockachat.findByIdProduit", query = "SELECT p FROM Possedestockachat p WHERE p.possedestockachatPK.idProduit = :idProduit"),
    @NamedQuery(name = "Possedestockachat.findByIdDimension", query = "SELECT p FROM Possedestockachat p WHERE p.possedestockachatPK.idDimension = :idDimension"),
    @NamedQuery(name = "Possedestockachat.findByStock", query = "SELECT p FROM Possedestockachat p WHERE p.stock = :stock")})
public class Possedestockachat implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PossedestockachatPK possedestockachatPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock")
    private int stock;
    @JoinColumn(name = "idDimension", referencedColumnName = "idDimension", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Dimension dimension;
    @JoinColumn(name = "idProduit", referencedColumnName = "idProduit", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Produitaacheter produitaacheter;

    public Possedestockachat() {
    }

    public Possedestockachat(PossedestockachatPK possedestockachatPK) {
        this.possedestockachatPK = possedestockachatPK;
    }

    public Possedestockachat(PossedestockachatPK possedestockachatPK, int stock) {
        this.possedestockachatPK = possedestockachatPK;
        this.stock = stock;
    }

    public Possedestockachat(int idProduit, int idDimension) {
        this.possedestockachatPK = new PossedestockachatPK(idProduit, idDimension);
    }

    public PossedestockachatPK getPossedestockachatPK() {
        return possedestockachatPK;
    }

    public void setPossedestockachatPK(PossedestockachatPK possedestockachatPK) {
        this.possedestockachatPK = possedestockachatPK;
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

    public Produitaacheter getProduitaacheter() {
        return produitaacheter;
    }

    public void setProduitaacheter(Produitaacheter produitaacheter) {
        this.produitaacheter = produitaacheter;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (possedestockachatPK != null ? possedestockachatPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Possedestockachat)) {
            return false;
        }
        Possedestockachat other = (Possedestockachat) object;
        if ((this.possedestockachatPK == null && other.possedestockachatPK != null) || (this.possedestockachatPK != null && !this.possedestockachatPK.equals(other.possedestockachatPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Possedestockachat[ possedestockachatPK=" + possedestockachatPK + " ]";
    }
    
}
