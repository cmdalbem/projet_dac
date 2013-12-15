/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "commente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commente.findAll", query = "SELECT c FROM Commente c"),
    @NamedQuery(name = "Commente.findByIdProduit", query = "SELECT c FROM Commente c WHERE c.commentePK.idProduit = :idProduit"),
    @NamedQuery(name = "Commente.findByIdClient", query = "SELECT c FROM Commente c WHERE c.commentePK.idClient = :idClient"),
    @NamedQuery(name = "Commente.findByDate", query = "SELECT c FROM Commente c WHERE c.date = :date")})
public class Commente implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CommentePK commentePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "texte")
    private String texte;
    @JoinColumn(name = "idClient", referencedColumnName = "idClient", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Client client;
    @JoinColumn(name = "idProduit", referencedColumnName = "idProduit", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Produit produit;

    public Commente() {
    }

    public Commente(CommentePK commentePK) {
        this.commentePK = commentePK;
    }

    public Commente(CommentePK commentePK, Date date, String texte) {
        this.commentePK = commentePK;
        this.date = date;
        this.texte = texte;
    }

    public Commente(int idProduit, int idClient) {
        this.commentePK = new CommentePK(idProduit, idClient);
    }

    public CommentePK getCommentePK() {
        return commentePK;
    }

    public void setCommentePK(CommentePK commentePK) {
        this.commentePK = commentePK;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
        hash += (commentePK != null ? commentePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commente)) {
            return false;
        }
        Commente other = (Commente) object;
        if ((this.commentePK == null && other.commentePK != null) || (this.commentePK != null && !this.commentePK.equals(other.commentePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Commente[ commentePK=" + commentePK + " ]";
    }
    
}
