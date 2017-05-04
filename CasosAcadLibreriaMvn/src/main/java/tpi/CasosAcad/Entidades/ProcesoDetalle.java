/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpi.CasosAcad.Entidades;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Manuel
 */
@Entity
@Table(name = "proceso_detalle", catalog = "CasosAcad_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcesoDetalle.findAll", query = "SELECT p FROM ProcesoDetalle p")
    , @NamedQuery(name = "ProcesoDetalle.findByIdProcesoDetalle", query = "SELECT p FROM ProcesoDetalle p WHERE p.idProcesoDetalle = :idProcesoDetalle")
    , @NamedQuery(name = "ProcesoDetalle.findByResponsable", query = "SELECT p FROM ProcesoDetalle p WHERE p.responsable = :responsable")})
public class ProcesoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProceso_Detalle")
    private Integer idProcesoDetalle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "responsable")
    private String responsable;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "procesoDetalle1", fetch = FetchType.EAGER)
    private ProcesoDetalle procesoDetalle;
    @JoinColumn(name = "idProceso_Detalle", referencedColumnName = "idProceso_Detalle", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private ProcesoDetalle procesoDetalle1;
    @JoinColumn(name = "idPaso", referencedColumnName = "idPaso")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Paso idPaso;
    @JoinColumn(name = "idProceso", referencedColumnName = "idProceso")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Proceso idProceso;

    public ProcesoDetalle() {
    }

    public ProcesoDetalle(Integer idProcesoDetalle) {
        this.idProcesoDetalle = idProcesoDetalle;
    }

    public ProcesoDetalle(Integer idProcesoDetalle, String responsable) {
        this.idProcesoDetalle = idProcesoDetalle;
        this.responsable = responsable;
    }

    public Integer getIdProcesoDetalle() {
        return idProcesoDetalle;
    }

    public void setIdProcesoDetalle(Integer idProcesoDetalle) {
        this.idProcesoDetalle = idProcesoDetalle;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public ProcesoDetalle getProcesoDetalle() {
        return procesoDetalle;
    }

    public void setProcesoDetalle(ProcesoDetalle procesoDetalle) {
        this.procesoDetalle = procesoDetalle;
    }

    public ProcesoDetalle getProcesoDetalle1() {
        return procesoDetalle1;
    }

    public void setProcesoDetalle1(ProcesoDetalle procesoDetalle1) {
        this.procesoDetalle1 = procesoDetalle1;
    }

    public Paso getIdPaso() {
        return idPaso;
    }

    public void setIdPaso(Paso idPaso) {
        this.idPaso = idPaso;
    }

    public Proceso getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(Proceso idProceso) {
        this.idProceso = idProceso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProcesoDetalle != null ? idProcesoDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcesoDetalle)) {
            return false;
        }
        ProcesoDetalle other = (ProcesoDetalle) object;
        if ((this.idProcesoDetalle == null && other.idProcesoDetalle != null) || (this.idProcesoDetalle != null && !this.idProcesoDetalle.equals(other.idProcesoDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tpi.CasosAcad.Entidades.ProcesoDetalle[ idProcesoDetalle=" + idProcesoDetalle + " ]";
    }
    
}
