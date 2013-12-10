
package ENTITYclass;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "acheteService")
@NamedQueries({
    @NamedQuery(name = "AcheteService.findAll", query = "SELECT a FROM AcheteService a"),
    @NamedQuery(name = "AcheteService.findByIdProduit", query = "SELECT a FROM AcheteService a WHERE a.acheteServicePK.idProduit = :idProduit"),
    @NamedQuery(name = "AcheteService.findByIdClient", query = "SELECT a FROM AcheteService a WHERE a.acheteServicePK.idClient = :idClient"),
    @NamedQuery(name = "AcheteService.findByDate", query = "SELECT a FROM AcheteService a WHERE a.date = :date"),
    @NamedQuery(name = "AcheteService.findByQuantite", query = "SELECT a FROM AcheteService a WHERE a.quantite = :quantite"),
    @NamedQuery(name = "AcheteService.findByPrix", query = "SELECT a FROM AcheteService a WHERE a.prix = :prix"),
    @NamedQuery(name = "AcheteService.findByPoints", query = "SELECT a FROM AcheteService a WHERE a.points = :points"),
    @NamedQuery(name = "AcheteService.findByDateService", query = "SELECT a FROM AcheteService a WHERE a.dateService = :dateService")})
public class AcheteService implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AcheteServicePK acheteServicePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantite")
    private int quantite;
    // @Max(value=?)  @Min(value=?)
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
    @ManyToOne(optional = false)
    private Client client;
    @JoinColumn(name = "idProduit", referencedColumnName = "idProduit", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Service service;

    public AcheteService() {
    }

    public AcheteService(AcheteServicePK acheteServicePK) {
        this.acheteServicePK = acheteServicePK;
    }

    public AcheteService(AcheteServicePK acheteServicePK, Date date, int quantite, BigDecimal prix, Date dateService) {
        this.acheteServicePK = acheteServicePK;
        this.date = date;
        this.quantite = quantite;
        this.prix = prix;
        this.dateService = dateService;
    }

    public AcheteService(int idProduit, int idClient) {
        this.acheteServicePK = new AcheteServicePK(idProduit, idClient);
    }

    public AcheteServicePK getAcheteServicePK() {
        return acheteServicePK;
    }

    public void setAcheteServicePK(AcheteServicePK acheteServicePK) {
        this.acheteServicePK = acheteServicePK;
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
        hash += (acheteServicePK != null ? acheteServicePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcheteService)) {
            return false;
        }
        AcheteService other = (AcheteService) object;
        if ((this.acheteServicePK == null && other.acheteServicePK != null) || (this.acheteServicePK != null && !this.acheteServicePK.equals(other.acheteServicePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTITYclass.AcheteService[ acheteServicePK=" + acheteServicePK + " ]";
    }
    
}
