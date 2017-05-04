/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpi.CasosAcad.Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Manuel
 */
@Entity
@Table(name = "paso_requisito", catalog = "CasosAcad_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PasoRequisito.findAll", query = "SELECT p FROM PasoRequisito p")
    , @NamedQuery(name = "PasoRequisito.findByIdPasoRequisito", query = "SELECT p FROM PasoRequisito p WHERE p.idPasoRequisito = :idPasoRequisito")})
public class PasoRequisito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPaso_Requisito")
    private Integer idPasoRequisito;
    @JoinColumn(name = "idPaso", referencedColumnName = "idPaso")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Paso idPaso;
    @JoinColumn(name = "idRequisito", referencedColumnName = "idRequisito")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Requisito idRequisito;

    public PasoRequisito() {
    }

    public PasoRequisito(Integer idPasoRequisito) {
        this.idPasoRequisito = idPasoRequisito;
    }

    public Integer getIdPasoRequisito() {
        return idPasoRequisito;
    }

    public void setIdPasoRequisito(Integer idPasoRequisito) {
        this.idPasoRequisito = idPasoRequisito;
    }

    public Paso getIdPaso() {
        return idPaso;
    }

    public void setIdPaso(Paso idPaso) {
        this.idPaso = idPaso;
    }

    public Requisito getIdRequisito() {
        return idRequisito;
    }

    public void setIdRequisito(Requisito idRequisito) {
        this.idRequisito = idRequisito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPasoRequisito != null ? idPasoRequisito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PasoRequisito)) {
            return false;
        }
        PasoRequisito other = (PasoRequisito) object;
        if ((this.idPasoRequisito == null && other.idPasoRequisito != null) || (this.idPasoRequisito != null && !this.idPasoRequisito.equals(other.idPasoRequisito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tpi.CasosAcad.Entidades.PasoRequisito[ idPasoRequisito=" + idPasoRequisito + " ]";
    }
    
}
