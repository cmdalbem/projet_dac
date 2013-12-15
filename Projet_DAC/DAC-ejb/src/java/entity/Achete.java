/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DARK
 */
@Entity
@Table(name = "achete")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Achete.findAll", query = "SELECT a FROM Achete a"),
    @NamedQuery(name = "Achete.findByIdProduit", query = "SELECT a FROM Achete a WHERE a.achetePK.idProduit = :idProduit"),
    @NamedQuery(name = "Achete.findByIdClient", query = "SELECT a FROM Achete a WHERE a.achetePK.idClient = :idClient"),
    @NamedQuery(name = "Achete.findByDate", query = "SELECT a FROM Achete a WHERE a.date = :date"),
    @NamedQuery(name = "Achete.findByQuantite", query = "SELECT a FROM Achete a WHERE a.quantite = :quantite"),
    @NamedQuery(name = "Achete.findByPrix", query = "SELECT a FROM Achete a WHERE a.prix = :prix"),
    @NamedQuery(name = "Achete.findByPoints", query = "SELECT a FROM Achete a WHERE a.points = :points"),
    @NamedQuery(name = "Achete.findByNote", query = "SELECT a FROM Achete a WHERE a.note = :note"),
    @NamedQuery(name = "Achete.findByTypeLivraison", query = "SELECT a FROM Achete a WHERE a.typeLivraison = :typeLivraison"),
    @NamedQuery(name = "Achete.findBySuiviCommande", query = "SELECT a FROM Achete a WHERE a.suiviCommande = :suiviCommande")})
public class Achete implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AchetePK achetePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantite")
    private int quantite;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "prix")
    private BigDecimal prix;
    @Column(name = "points")
    private Integer points;
    @Column(name = "note")
    private BigDecimal note;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "typeLivraison")
    private String typeLivraison;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "suiviCommande")
    private String suiviCommande;
    @JoinColumn(name = "idClient", referencedColumnName = "idClient", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Client client;
    @JoinColumn(name = "idProduit", referencedColumnName = "idProduit", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Produitaacheter produitaacheter;

    public Achete() {
    }

    public Achete(AchetePK achetePK) {
        this.achetePK = achetePK;
    }

    public Achete(AchetePK achetePK, Date date, int quantite, BigDecimal prix, String typeLivraison, String suiviCommande) {
        this.achetePK = achetePK;
        this.date = date;
        this.quantite = quantite;
        this.prix = prix;
        this.typeLivraison = typeLivraison;
        this.suiviCommande = suiviCommande;
    }

    public Achete(int idProduit, int idClient) {
        this.achetePK = new AchetePK(idProduit, idClient);
    }

    public AchetePK getAchetePK() {
        return achetePK;
    }

    public void setAchetePK(AchetePK achetePK) {
        this.achetePK = achetePK;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public BigDecimal getNote() {
        return note;
    }

    public void setNote(BigDecimal note) {
        this.note = note;
    }

    public String getTypeLivraison() {
        return typeLivraison;
    }

    public void setTypeLivraison(String typeLivraison) {
        this.typeLivraison = typeLivraison;
    }

    public String getSuiviCommande() {
        return suiviCommande;
    }

    public void setSuiviCommande(String suiviCommande) {
        this.suiviCommande = suiviCommande;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
        hash += (achetePK != null ? achetePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Achete)) {
            return false;
        }
        Achete other = (Achete) object;
        if ((this.achetePK == null && other.achetePK != null) || (this.achetePK != null && !this.achetePK.equals(other.achetePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Achete[ achetePK=" + achetePK + " ]";
    }
    
}
