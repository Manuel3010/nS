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
@Table(name = "caso_detalle", catalog = "CasosAcad_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CasoDetalle.findAll", query = "SELECT c FROM CasoDetalle c")
    , @NamedQuery(name = "CasoDetalle.findByIdCasoDetalle", query = "SELECT c FROM CasoDetalle c WHERE c.idCasoDetalle = :idCasoDetalle")
    , @NamedQuery(name = "CasoDetalle.findByIdProcesoDetalle", query = "SELECT c FROM CasoDetalle c WHERE c.idProcesoDetalle = :idProcesoDetalle")})
public class CasoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCaso_Detalle")
    private Integer idCasoDetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProceso_Detalle")
    private int idProcesoDetalle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCasoDetalle", fetch = FetchType.EAGER)
    private List<CasoDetalleRequisito> casoDetalleRequisitoList;
    @JoinColumn(name = "idCaso", referencedColumnName = "idCaso")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Caso idCaso;

    public CasoDetalle() {
    }

    public CasoDetalle(Integer idCasoDetalle) {
        this.idCasoDetalle = idCasoDetalle;
    }

    public CasoDetalle(Integer idCasoDetalle, int idProcesoDetalle) {
        this.idCasoDetalle = idCasoDetalle;
        this.idProcesoDetalle = idProcesoDetalle;
    }

    public Integer getIdCasoDetalle() {
        return idCasoDetalle;
    }

    public void setIdCasoDetalle(Integer idCasoDetalle) {
        this.idCasoDetalle = idCasoDetalle;
    }

    public int getIdProcesoDetalle() {
        return idProcesoDetalle;
    }

    public void setIdProcesoDetalle(int idProcesoDetalle) {
        this.idProcesoDetalle = idProcesoDetalle;
    }

    @XmlTransient
    public List<CasoDetalleRequisito> getCasoDetalleRequisitoList() {
        return casoDetalleRequisitoList;
    }

    public void setCasoDetalleRequisitoList(List<CasoDetalleRequisito> casoDetalleRequisitoList) {
        this.casoDetalleRequisitoList = casoDetalleRequisitoList;
    }

    public Caso getIdCaso() {
        return idCaso;
    }

    public void setIdCaso(Caso idCaso) {
        this.idCaso = idCaso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCasoDetalle != null ? idCasoDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CasoDetalle)) {
            return false;
        }
        CasoDetalle other = (CasoDetalle) object;
        if ((this.idCasoDetalle == null && other.idCasoDetalle != null) || (this.idCasoDetalle != null && !this.idCasoDetalle.equals(other.idCasoDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tpi.CasosAcad.Entidades.CasoDetalle[ idCasoDetalle=" + idCasoDetalle + " ]";
    }
    
}
