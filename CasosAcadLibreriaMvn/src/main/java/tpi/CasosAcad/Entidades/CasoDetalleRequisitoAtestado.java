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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Manuel
 */
@Entity
@Table(name = "caso_detalle_requisito_atestado", catalog = "CasosAcad_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CasoDetalleRequisitoAtestado.findAll", query = "SELECT c FROM CasoDetalleRequisitoAtestado c")
    , @NamedQuery(name = "CasoDetalleRequisitoAtestado.findByIdCasoDetalleRequisitoAtestado", query = "SELECT c FROM CasoDetalleRequisitoAtestado c WHERE c.idCasoDetalleRequisitoAtestado = :idCasoDetalleRequisitoAtestado")
    , @NamedQuery(name = "CasoDetalleRequisitoAtestado.findByDocumento", query = "SELECT c FROM CasoDetalleRequisitoAtestado c WHERE c.documento = :documento")})
public class CasoDetalleRequisitoAtestado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCaso_Detalle_Requisito_Atestado")
    private Integer idCasoDetalleRequisitoAtestado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "documento")
    private String documento;
    @JoinColumn(name = "idCaso_Detalle_Requisito", referencedColumnName = "idCaso_Detalle_Requisito")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private CasoDetalleRequisito idCasoDetalleRequisito;

    public CasoDetalleRequisitoAtestado() {
    }

    public CasoDetalleRequisitoAtestado(Integer idCasoDetalleRequisitoAtestado) {
        this.idCasoDetalleRequisitoAtestado = idCasoDetalleRequisitoAtestado;
    }

    public CasoDetalleRequisitoAtestado(Integer idCasoDetalleRequisitoAtestado, String documento) {
        this.idCasoDetalleRequisitoAtestado = idCasoDetalleRequisitoAtestado;
        this.documento = documento;
    }

    public Integer getIdCasoDetalleRequisitoAtestado() {
        return idCasoDetalleRequisitoAtestado;
    }

    public void setIdCasoDetalleRequisitoAtestado(Integer idCasoDetalleRequisitoAtestado) {
        this.idCasoDetalleRequisitoAtestado = idCasoDetalleRequisitoAtestado;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public CasoDetalleRequisito getIdCasoDetalleRequisito() {
        return idCasoDetalleRequisito;
    }

    public void setIdCasoDetalleRequisito(CasoDetalleRequisito idCasoDetalleRequisito) {
        this.idCasoDetalleRequisito = idCasoDetalleRequisito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCasoDetalleRequisitoAtestado != null ? idCasoDetalleRequisitoAtestado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CasoDetalleRequisitoAtestado)) {
            return false;
        }
        CasoDetalleRequisitoAtestado other = (CasoDetalleRequisitoAtestado) object;
        if ((this.idCasoDetalleRequisitoAtestado == null && other.idCasoDetalleRequisitoAtestado != null) || (this.idCasoDetalleRequisitoAtestado != null && !this.idCasoDetalleRequisitoAtestado.equals(other.idCasoDetalleRequisitoAtestado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tpi.CasosAcad.Entidades.CasoDetalleRequisitoAtestado[ idCasoDetalleRequisitoAtestado=" + idCasoDetalleRequisitoAtestado + " ]";
    }
    
}
