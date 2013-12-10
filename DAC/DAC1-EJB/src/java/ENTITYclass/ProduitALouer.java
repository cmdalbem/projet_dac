
package ENTITYclass;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "produitALouer")
@NamedQueries({
    @NamedQuery(name = "ProduitALouer.findAll", query = "SELECT p FROM ProduitALouer p"),
    @NamedQuery(name = "ProduitALouer.findByIdProduit", query = "SELECT p FROM ProduitALouer p WHERE p.idProduit = :idProduit")})
public class ProduitALouer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProduit")
    private Integer idProduit;
    @JoinColumn(name = "idProduit", referencedColumnName = "idProduit", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private ProduitStocke produitStocke;

    public ProduitALouer() {
    }

    public ProduitALouer(Integer idProduit) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduit != null ? idProduit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProduitALouer)) {
            return false;
        }
        ProduitALouer other = (ProduitALouer) object;
        if ((this.idProduit == null && other.idProduit != null) || (this.idProduit != null && !this.idProduit.equals(other.idProduit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTITYclass.ProduitALouer[ idProduit=" + idProduit + " ]";
    }
    
}
