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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DARK
 */
@Entity
@Table(name = "dimension")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dimension.findAll", query = "SELECT d FROM Dimension d"),
    @NamedQuery(name = "Dimension.findByIdDimension", query = "SELECT d FROM Dimension d WHERE d.idDimension = :idDimension"),
    @NamedQuery(name = "Dimension.findByLabel", query = "SELECT d FROM Dimension d WHERE d.label = :label"),
    @NamedQuery(name = "Dimension.findByValeur", query = "SELECT d FROM Dimension d WHERE d.valeur = :valeur")})
public class Dimension implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDimension")
    private Integer idDimension;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "label")
    private String label;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "valeur")
    private String valeur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dimension", fetch = FetchType.LAZY)
    private Collection<Possedestockachat> possedestockachatCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dimension", fetch = FetchType.LAZY)
    private Collection<Possedestocklocation> possedestocklocationCollection;

    public Dimension() {
    }

    public Dimension(Integer idDimension) {
        this.idDimension = idDimension;
    }

    public Dimension(Integer idDimension, String label, String valeur) {
        this.idDimension = idDimension;
        this.label = label;
        this.valeur = valeur;
    }

    public Integer getIdDimension() {
        return idDimension;
    }

    public void setIdDimension(Integer idDimension) {
        this.idDimension = idDimension;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    @XmlTransient
    public Collection<Possedestockachat> getPossedestockachatCollection() {
        return possedestockachatCollection;
    }

    public void setPossedestockachatCollection(Collection<Possedestockachat> possedestockachatCollection) {
        this.possedestockachatCollection = possedestockachatCollection;
    }

    @XmlTransient
    public Collection<Possedestocklocation> getPossedestocklocationCollection() {
        return possedestocklocationCollection;
    }

    public void setPossedestocklocationCollection(Collection<Possedestocklocation> possedestocklocationCollection) {
        this.possedestocklocationCollection = possedestocklocationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDimension != null ? idDimension.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dimension)) {
            return false;
        }
        Dimension other = (Dimension) object;
        if ((this.idDimension == null && other.idDimension != null) || (this.idDimension != null && !this.idDimension.equals(other.idDimension))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Dimension[ idDimension=" + idDimension + " ]";
    }
    
}
