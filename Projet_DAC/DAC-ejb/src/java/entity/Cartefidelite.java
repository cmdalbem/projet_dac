/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DARK
 */
@Entity
@Table(name = "cartefidelite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cartefidelite.findAll", query = "SELECT c FROM Cartefidelite c"),
    @NamedQuery(name = "Cartefidelite.findByNumCarte", query = "SELECT c FROM Cartefidelite c WHERE c.numCarte = :numCarte"),
    @NamedQuery(name = "Cartefidelite.findByPoints", query = "SELECT c FROM Cartefidelite c WHERE c.points = :points")})
public class Cartefidelite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_carte")
    private Integer numCarte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "points")
    private int points;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "numCarte", fetch = FetchType.LAZY)
    private Collection<Client> clientCollection;

    public Cartefidelite() {
        points=0;
    }

    public Cartefidelite(Integer numCarte) {
        this.numCarte = numCarte;
    }

    public Cartefidelite(Integer numCarte, int points) {
        this.numCarte = numCarte;
        this.points = points;
    }

    public Integer getNumCarte() {
        return numCarte;
    }

    public void setNumCarte(Integer numCarte) {
        this.numCarte = numCarte;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @XmlTransient
    public Collection<Client> getClientCollection() {
        return clientCollection;
    }

    public void setClientCollection(Collection<Client> clientCollection) {
        this.clientCollection = clientCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numCarte != null ? numCarte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cartefidelite)) {
            return false;
        }
        Cartefidelite other = (Cartefidelite) object;
        if ((this.numCarte == null && other.numCarte != null) || (this.numCarte != null && !this.numCarte.equals(other.numCarte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Cartefidelite[ numCarte=" + numCarte + " ]";
    }
    
}
