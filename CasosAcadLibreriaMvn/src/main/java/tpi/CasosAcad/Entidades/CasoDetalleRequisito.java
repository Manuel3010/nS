/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpi.CasosAcad.Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Manuel
 */
@Entity
@Table(name = "caso_detalle_requisito", catalog = "CasosAcad_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CasoDetalleRequisito.findAll", query = "SELECT c FROM CasoDetalleRequisito c")
    , @NamedQuery(name = "CasoDetalleRequisito.findByIdCasoDetalleRequisito", query = "SELECT c FROM CasoDetalleRequisito c WHERE c.idCasoDetalleRequisito = :idCasoDetalleRequisito")
    , @NamedQuery(name = "CasoDetalleRequisito.findByIdPasoRequisito", query = "SELECT c FROM CasoDetalleRequisito c WHERE c.idPasoRequisito = :idPasoRequisito")})
public class CasoDetalleRequisito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCaso_Detalle_Requisito")
    private Integer idCasoDetalleRequisito;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPaso_Requisito")
    private int idPasoRequisito;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCasoDetalleRequisito", fetch = FetchType.EAGER)
    private List<CasoDetalleRequisitoAtestado> casoDetalleRequisitoAtestadoList;
    @JoinColumn(name = "idCaso_Detalle", referencedColumnName = "idCaso_Detalle")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private CasoDetalle idCasoDetalle;

    public CasoDetalleRequisito() {
    }

    public CasoDetalleRequisito(Integer idCasoDetalleRequisito) {
        this.idCasoDetalleRequisito = idCasoDetalleRequisito;
    }

    public CasoDetalleRequisito(Integer idCasoDetalleRequisito, int idPasoRequisito) {
        this.idCasoDetalleRequisito = idCasoDetalleRequisito;
        this.idPasoRequisito = idPasoRequisito;
    }

    public Integer getIdCasoDetalleRequisito() {
        return idCasoDetalleRequisito;
    }

    public void setIdCasoDetalleRequisito(Integer idCasoDetalleRequisito) {
        this.idCasoDetalleRequisito = idCasoDetalleRequisito;
    }

    public int getIdPasoRequisito() {
        return idPasoRequisito;
    }

    public void setIdPasoRequisito(int idPasoRequisito) {
        this.idPasoRequisito = idPasoRequisito;
    }

    @XmlTransient
    public List<CasoDetalleRequisitoAtestado> getCasoDetalleRequisitoAtestadoList() {
        return casoDetalleRequisitoAtestadoList;
    }

    public void setCasoDetalleRequisitoAtestadoList(List<CasoDetalleRequisitoAtestado> casoDetalleRequisitoAtestadoList) {
        this.casoDetalleRequisitoAtestadoList = casoDetalleRequisitoAtestadoList;
    }

    public CasoDetalle getIdCasoDetalle() {
        return idCasoDetalle;
    }

    public void setIdCasoDetalle(CasoDetalle idCasoDetalle) {
        this.idCasoDetalle = idCasoDetalle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCasoDetalleRequisito != null ? idCasoDetalleRequisito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CasoDetalleRequisito)) {
            return false;
        }
        CasoDetalleRequisito other = (CasoDetalleRequisito) object;
        if ((this.idCasoDetalleRequisito == null && other.idCasoDetalleRequisito != null) || (this.idCasoDetalleRequisito != null && !this.idCasoDetalleRequisito.equals(other.idCasoDetalleRequisito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tpi.CasosAcad.Entidades.CasoDetalleRequisito[ idCasoDetalleRequisito=" + idCasoDetalleRequisito + " ]";
    }
    
}
