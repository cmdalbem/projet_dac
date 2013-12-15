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
public class AchetePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProduit")
    private int idProduit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idClient")
    private int idClient;

    public AchetePK() {
    }

    public AchetePK(int idProduit, int idClient) {
        this.idProduit = idProduit;
        this.idClient = idClient;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProduit;
        hash += (int) idClient;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AchetePK)) {
            return false;
        }
        AchetePK other = (AchetePK) object;
        if (this.idProduit != other.idProduit) {
            return false;
        }
        if (this.idClient != other.idClient) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AchetePK[ idProduit=" + idProduit + ", idClient=" + idClient + " ]";
    }
    
}
