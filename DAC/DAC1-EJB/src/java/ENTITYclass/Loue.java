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
import javax.validation.constraints.Size;



@Entity
@Table(name = "loue")
@NamedQueries({
    @NamedQuery(name = "Loue.findAll", query = "SELECT l FROM Loue l"),
    @NamedQuery(name = "Loue.findByIdProduit", query = "SELECT l FROM Loue l WHERE l.louePK.idProduit = :idProduit"),
    @NamedQuery(name = "Loue.findByIdClient", query = "SELECT l FROM Loue l WHERE l.louePK.idClient = :idClient"),
    @NamedQuery(name = "Loue.findByDate", query = "SELECT l FROM Loue l WHERE l.date = :date"),
    @NamedQuery(name = "Loue.findByQuantite", query = "SELECT l FROM Loue l WHERE l.quantite = :quantite"),
    @NamedQuery(name = "Loue.findByPrix", query = "SELECT l FROM Loue l WHERE l.prix = :prix"),
    @NamedQuery(name = "Loue.findByPoints", query = "SELECT l FROM Loue l WHERE l.points = :points"),
    @NamedQuery(name = "Loue.findByEtat", query = "SELECT l FROM Loue l WHERE l.etat = :etat"),
    @NamedQuery(name = "Loue.findByDateDebut", query = "SELECT l FROM Loue l WHERE l.dateDebut = :dateDebut"),
    @NamedQuery(name = "Loue.findByDateFin", query = "SELECT l FROM Loue l WHERE l.dateFin = :dateFin")})
public class Loue implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LouePK louePK;
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
    @Size(min = 1, max = 11)
    @Column(name = "etat")
    private String etat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateDebut")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateFin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @JoinColumn(name = "idClient", referencedColumnName = "idClient", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Client client;
    @JoinColumn(name = "idProduit", referencedColumnName = "idProduit", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ProduitAAcheter produitAAcheter;

    public Loue() {
    }

    public Loue(LouePK louePK) {
        this.louePK = louePK;
    }

    public Loue(LouePK louePK, Date date, int quantite, BigDecimal prix, String etat, Date dateDebut, Date dateFin) {
        this.louePK = louePK;
        this.date = date;
        this.quantite = quantite;
        this.prix = prix;
        this.etat = etat;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Loue(int idProduit, int idClient) {
        this.louePK = new LouePK(idProduit, idClient);
    }

    public LouePK getLouePK() {
        return louePK;
    }

    public void setLouePK(LouePK louePK) {
        this.louePK = louePK;
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

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ProduitAAcheter getProduitAAcheter() {
        return produitAAcheter;
    }

    public void setProduitAAcheter(ProduitAAcheter produitAAcheter) {
        this.produitAAcheter = produitAAcheter;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (louePK != null ? louePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loue)) {
            return false;
        }
        Loue other = (Loue) object;
        if ((this.louePK == null && other.louePK != null) || (this.louePK != null && !this.louePK.equals(other.louePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTITYclass.Loue[ louePK=" + louePK + " ]";
    }
    
}
