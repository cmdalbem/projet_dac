
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
import javax.validation.constraints.Size;

@Entity
@Table(name = "produitStocke")
@NamedQueries({
    @NamedQuery(name = "ProduitStocke.findAll", query = "SELECT p FROM ProduitStocke p"),
    @NamedQuery(name = "ProduitStocke.findByIdProduit", query = "SELECT p FROM ProduitStocke p WHERE p.idProduit = :idProduit"),
    @NamedQuery(name = "ProduitStocke.findByPhoto", query = "SELECT p FROM ProduitStocke p WHERE p.photo = :photo")})
public class ProduitStocke implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProduit")
    private Integer idProduit;
    @Size(max = 100)
    @Column(name = "photo")
    private String photo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "produitStocke")
    private ProduitAAcheter produitAAcheter;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "produitStocke")
    private ProduitALouer produitALouer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produitStocke")
    private Collection<PossedeStock> possedeStockCollection;
    @JoinColumn(name = "idProduit", referencedColumnName = "idProduit", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Produit produit;

    public ProduitStocke() {
    }

    public ProduitStocke(Integer idProduit) {
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

    public ProduitAAcheter getProduitAAcheter() {
        return produitAAcheter;
    }

    public void setProduitAAcheter(ProduitAAcheter produitAAcheter) {
        this.produitAAcheter = produitAAcheter;
    }

    public ProduitALouer getProduitALouer() {
        return produitALouer;
    }

    public void setProduitALouer(ProduitALouer produitALouer) {
        this.produitALouer = produitALouer;
    }


    public Collection<PossedeStock> getPossedeStockCollection() {
        return possedeStockCollection;
    }

    public void setPossedeStockCollection(Collection<PossedeStock> possedeStockCollection) {
        this.possedeStockCollection = possedeStockCollection;
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
        if (!(object instanceof ProduitStocke)) {
            return false;
        }
        ProduitStocke other = (ProduitStocke) object;
        if ((this.idProduit == null && other.idProduit != null) || (this.idProduit != null && !this.idProduit.equals(other.idProduit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTITYclass.ProduitStocke[ idProduit=" + idProduit + " ]";
    }
    
}
