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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DARK
 */
@Entity
@Table(name = "acheteservice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acheteservice.findAll", query = "SELECT a FROM Acheteservice a"),
    @NamedQuery(name = "Acheteservice.findByIdProduit", query = "SELECT a FROM Acheteservice a WHERE a.acheteservicePK.idProduit = :idProduit"),
    @NamedQuery(name = "Acheteservice.findByIdClient", query = "SELECT a FROM Acheteservice a WHERE a.acheteservicePK.idClient = :idClient"),
    @NamedQuery(name = "Acheteservice.findByDate", query = "SELECT a FROM Acheteservice a WHERE a.date = :date"),
    @NamedQuery(name = "Acheteservice.findByQuantite", query = "SELECT a FROM Acheteservice a WHERE a.quantite = :quantite"),
    @NamedQuery(name = "Acheteservice.findByPrix", query = "SELECT a FROM Acheteservice a WHERE a.prix = :prix"),
    @NamedQuery(name = "Acheteservice.findByPoints", query = "SELECT a FROM Acheteservice a WHERE a.points = :points"),
    @NamedQuery(name = "Acheteservice.findByDateService", query = "SELECT a FROM Acheteservice a WHERE a.dateService = :dateService")})
public class Acheteservice implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AcheteservicePK acheteservicePK;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateService")
    @Temporal(TemporalType.DATE)
    private Date dateService;
    @JoinColumn(name = "idClient", referencedColumnName = "idClient", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Client client;
    @JoinColumn(name = "idProduit", referencedColumnName = "idProduit", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Service service;

    public Acheteservice() {
    }

    public Acheteservice(AcheteservicePK acheteservicePK) {
        this.acheteservicePK = acheteservicePK;
    }

    public Acheteservice(AcheteservicePK acheteservicePK, Date date, int quantite, BigDecimal prix, Date dateService) {
        this.acheteservicePK = acheteservicePK;
        this.date = date;
        this.quantite = quantite;
        this.prix = prix;
        this.dateService = dateService;
    }

    public Acheteservice(int idProduit, int idClient) {
        this.acheteservicePK = new AcheteservicePK(idProduit, idClient);
    }

    public AcheteservicePK getAcheteservicePK() {
        return acheteservicePK;
    }

    public void setAcheteservicePK(AcheteservicePK acheteservicePK) {
        this.acheteservicePK = acheteservicePK;
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

    public Date getDateService() {
        return dateService;
    }

    public void setDateService(Date dateService) {
        this.dateService = dateService;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
        hash += (acheteservicePK != null ? acheteservicePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acheteservice)) {
            return false;
        }
        Acheteservice other = (Acheteservice) object;
        if ((this.acheteservicePK == null && other.acheteservicePK != null) || (this.acheteservicePK != null && !this.acheteservicePK.equals(other.acheteservicePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Acheteservice[ acheteservicePK=" + acheteservicePK + " ]";
    }
    
}
