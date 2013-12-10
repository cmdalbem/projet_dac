
package ENTITYclass;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "produit")
@NamedQueries({
    @NamedQuery(name = "Produit.findAll", query = "SELECT p FROM Produit p"),
    @NamedQuery(name = "Produit.findByIdProduit", query = "SELECT p FROM Produit p WHERE p.idProduit = :idProduit"),
    @NamedQuery(name = "Produit.findByNom", query = "SELECT p FROM Produit p WHERE p.nom = :nom"),
    @NamedQuery(name = "Produit.findByPrix", query = "SELECT p FROM Produit p WHERE p.prix = :prix"),
    @NamedQuery(name = "Produit.findByPromotion", query = "SELECT p FROM Produit p WHERE p.promotion = :promotion")})
public class Produit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProduit")
    private Integer idProduit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom")
    private String nom;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    // @Max(value=?)  @Min(value=?)
    @Basic(optional = false)
    @NotNull
    @Column(name = "prix")
    private BigDecimal prix;
    @Column(name = "promotion")
    private Integer promotion;
    @JoinColumn(name = "idCategorie", referencedColumnName = "idCategorie")
    @ManyToOne(optional = false)
    private CategorieProduit idCategorie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produit")
    private Collection<Commente> commenteCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "produit")
    private ProduitStocke produitStocke;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "produit")
    private Service service;

    public Produit() {
    }

    public Produit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public Produit(Integer idProduit, String nom, BigDecimal prix) {
        this.idProduit = idProduit;
        this.nom = nom;
        this.prix = prix;
    }

    public Integer getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public Integer getPromotion() {
        return promotion;
    }

    public void setPromotion(Integer promotion) {
        this.promotion = promotion;
    }

    public CategorieProduit getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(CategorieProduit idCategorie) {
        this.idCategorie = idCategorie;
    }


    public Collection<Commente> getCommenteCollection() {
        return commenteCollection;
    }

    public void setCommenteCollection(Collection<Commente> commenteCollection) {
        this.commenteCollection = commenteCollection;
    }

    public ProduitStocke getProduitStocke() {
        return produitStocke;
    }

    public void setProduitStocke(ProduitStocke produitStocke) {
        this.produitStocke = produitStocke;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduit != null ? idProduit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        //  Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.idProduit == null && other.idProduit != null) || (this.idProduit != null && !this.idProduit.equals(other.idProduit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTITYclass.Produit[ idProduit=" + idProduit + " ]";
    }
    
}
