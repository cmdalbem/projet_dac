
package ENTITYclass;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "possedeStock")
@NamedQueries({
    @NamedQuery(name = "PossedeStock.findAll", query = "SELECT p FROM PossedeStock p"),
    @NamedQuery(name = "PossedeStock.findByIdProduit", query = "SELECT p FROM PossedeStock p WHERE p.possedeStockPK.idProduit = :idProduit"),
    @NamedQuery(name = "PossedeStock.findByIdDimension", query = "SELECT p FROM PossedeStock p WHERE p.possedeStockPK.idDimension = :idDimension"),
    @NamedQuery(name = "PossedeStock.findByStock", query = "SELECT p FROM PossedeStock p WHERE p.stock = :stock")})
public class PossedeStock implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PossedeStockPK possedeStockPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock")
    private int stock;
    @JoinColumn(name = "idDimension", referencedColumnName = "idDimension", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Dimension dimension;
    @JoinColumn(name = "idProduit", referencedColumnName = "idProduit", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ProduitStocke produitStocke;

    public PossedeStock() {
    }

    public PossedeStock(PossedeStockPK possedeStockPK) {
        this.possedeStockPK = possedeStockPK;
    }

    public PossedeStock(PossedeStockPK possedeStockPK, int stock) {
        this.possedeStockPK = possedeStockPK;
        this.stock = stock;
    }

    public PossedeStock(int idProduit, int idDimension) {
        this.possedeStockPK = new PossedeStockPK(idProduit, idDimension);
    }

    public PossedeStockPK getPossedeStockPK() {
        return possedeStockPK;
    }

    public void setPossedeStockPK(PossedeStockPK possedeStockPK) {
        this.possedeStockPK = possedeStockPK;
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

    public ProduitStocke getProduitStocke() {
        return produitStocke;
    }

    public void setProduitStocke(ProduitStocke produitStocke) {
        this.produitStocke = produitStocke;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (possedeStockPK != null ? possedeStockPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PossedeStock)) {
            return false;
        }
        PossedeStock other = (PossedeStock) object;
        if ((this.possedeStockPK == null && other.possedeStockPK != null) || (this.possedeStockPK != null && !this.possedeStockPK.equals(other.possedeStockPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTITYclass.PossedeStock[ possedeStockPK=" + possedeStockPK + " ]";
    }
    
}
