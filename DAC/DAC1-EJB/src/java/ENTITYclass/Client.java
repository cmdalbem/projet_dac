
package ENTITYclass;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name = "client")

@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByIdClient", query = "SELECT c FROM Client c WHERE c.idClient = :idClient"),
    @NamedQuery(name = "Client.findByNom", query = "SELECT c FROM Client c WHERE c.nom = :nom"),
    @NamedQuery(name = "Client.findByPrenom", query = "SELECT c FROM Client c WHERE c.prenom = :prenom"),
    @NamedQuery(name = "Client.findByAdresse", query = "SELECT c FROM Client c WHERE c.adresse = :adresse"),
    @NamedQuery(name = "Client.findByTelephone", query = "SELECT c FROM Client c WHERE c.telephone = :telephone"),
    @NamedQuery(name = "Client.findByMail", query = "SELECT c FROM Client c WHERE c.mail = :mail"),
    @NamedQuery(name = "Client.findByMdp", query = "SELECT c FROM Client c WHERE c.mdp = :mdp"),
    @NamedQuery(name = "Client.findByDateNaissance", query = "SELECT c FROM Client c WHERE c.dateNaissance = :dateNaissance"),
    @NamedQuery(name = "Client.findByDateCreation", query = "SELECT c FROM Client c WHERE c.dateCreation = :dateCreation")})
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idClient")
    private Integer idClient;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "prenom")
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "adresse")
    private String adresse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telephone")
    private long telephone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "mail")
    private String mail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "mdp")
    private String mdp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_naissance")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private Collection<AcheteService> acheteServiceCollection;
    @JoinColumn(name = "num_carte", referencedColumnName = "num_carte")
    @ManyToOne(optional = false)
    private CarteFidelite numCarte;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private Collection<Achete> acheteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private Collection<Commente> commenteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private Collection<Loue> loueCollection;

    public Client() {
    }

    public Client(Integer idClient) {
        this.idClient = idClient;
    }

    public Client(Integer idClient, String nom, String prenom, String adresse, long telephone, String mail, String mdp, Date dateNaissance, Date dateCreation) {
        this.idClient = idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.mail = mail;
        this.mdp = mdp;
        this.dateNaissance = dateNaissance;
        this.dateCreation = dateCreation;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }


    public Collection<AcheteService> getAcheteServiceCollection() {
        return acheteServiceCollection;
    }

    public void setAcheteServiceCollection(Collection<AcheteService> acheteServiceCollection) {
        this.acheteServiceCollection = acheteServiceCollection;
    }

    public CarteFidelite getNumCarte() {
        return numCarte;
    }

    public void setNumCarte(CarteFidelite numCarte) {
        this.numCarte = numCarte;
    }


    public Collection<Achete> getAcheteCollection() {
        return acheteCollection;
    }

    public void setAcheteCollection(Collection<Achete> acheteCollection) {
        this.acheteCollection = acheteCollection;
    }


    public Collection<Commente> getCommenteCollection() {
        return commenteCollection;
    }

    public void setCommenteCollection(Collection<Commente> commenteCollection) {
        this.commenteCollection = commenteCollection;
    }


    public Collection<Loue> getLoueCollection() {
        return loueCollection;
    }

    public void setLoueCollection(Collection<Loue> loueCollection) {
        this.loueCollection = loueCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClient != null ? idClient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.idClient == null && other.idClient != null) || (this.idClient != null && !this.idClient.equals(other.idClient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTITYclass.Client[ idClient=" + idClient + " ]";
    }
    
}
