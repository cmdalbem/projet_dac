/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author DARK
 */
@Embeddable
public class PossedestocklocationPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProduit")
    private int idProduit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDimension")
    private int idDimension;

    public PossedestocklocationPK() {
    }

    public PossedestocklocationPK(int idProduit, int idDimension) {
        this.idProduit = idProduit;
        this.idDimension = idDimension;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public int getIdDimension() {
        return idDimension;
    }

    public void setIdDimension(int idDimension) {
        this.idDimension = idDimension;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProduit;
        hash += (int) idDimension;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PossedestocklocationPK)) {
            return false;
        }
        PossedestocklocationPK other = (PossedestocklocationPK) object;
        if (this.idProduit != other.idProduit) {
            return false;
        }
        if (this.idDimension != other.idDimension) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PossedestocklocationPK[ idProduit=" + idProduit + ", idDimension=" + idDimension + " ]";
    }
    
}
