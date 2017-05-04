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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Manuel
 */
@Entity
@Table(name = "requisito", catalog = "CasosAcad_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requisito.findAll", query = "SELECT r FROM Requisito r")
    , @NamedQuery(name = "Requisito.findByIdRequisito", query = "SELECT r FROM Requisito r WHERE r.idRequisito = :idRequisito")
    , @NamedQuery(name = "Requisito.findByRequisito", query = "SELECT r FROM Requisito r WHERE r.requisito = :requisito")
    , @NamedQuery(name = "Requisito.findByDescripcion", query = "SELECT r FROM Requisito r WHERE r.descripcion = :descripcion")
    , @NamedQuery(name = "Requisito.findByTextoPublico", query = "SELECT r FROM Requisito r WHERE r.textoPublico = :textoPublico")
    , @NamedQuery(name = "Requisito.findByObligatorio", query = "SELECT r FROM Requisito r WHERE r.obligatorio = :obligatorio")
    , @NamedQuery(name = "Requisito.findByActivo", query = "SELECT r FROM Requisito r WHERE r.activo = :activo")})
public class Requisito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRequisito")
    private Integer idRequisito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "requisito")
    private String requisito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "textoPublico")
    private String textoPublico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "obligatorio")
    private boolean obligatorio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @JoinColumn(name = "idTipo_Requisito", referencedColumnName = "idTipo_Requisito")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoRequisito idTipoRequisito;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRequisito", fetch = FetchType.EAGER)
    private List<PasoRequisito> pasoRequisitoList;

    public Requisito() {
    }

    public Requisito(Integer idRequisito) {
        this.idRequisito = idRequisito;
    }

    public Requisito(Integer idRequisito, String requisito, String descripcion, String textoPublico, boolean obligatorio, boolean activo) {
        this.idRequisito = idRequisito;
        this.requisito = requisito;
        this.descripcion = descripcion;
        this.textoPublico = textoPublico;
        this.obligatorio = obligatorio;
        this.activo = activo;
    }

    public Integer getIdRequisito() {
        return idRequisito;
    }

    public void setIdRequisito(Integer idRequisito) {
        this.idRequisito = idRequisito;
    }

    public String getRequisito() {
        return requisito;
    }

    public void setRequisito(String requisito) {
        this.requisito = requisito;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTextoPublico() {
        return textoPublico;
    }

    public void setTextoPublico(String textoPublico) {
        this.textoPublico = textoPublico;
    }

    public boolean getObligatorio() {
        return obligatorio;
    }

    public void setObligatorio(boolean obligatorio) {
        this.obligatorio = obligatorio;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public TipoRequisito getIdTipoRequisito() {
        return idTipoRequisito;
    }

    public void setIdTipoRequisito(TipoRequisito idTipoRequisito) {
        this.idTipoRequisito = idTipoRequisito;
    }

    @XmlTransient
    public List<PasoRequisito> getPasoRequisitoList() {
        return pasoRequisitoList;
    }

    public void setPasoRequisitoList(List<PasoRequisito> pasoRequisitoList) {
        this.pasoRequisitoList = pasoRequisitoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRequisito != null ? idRequisito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requisito)) {
            return false;
        }
        Requisito other = (Requisito) object;
        if ((this.idRequisito == null && other.idRequisito != null) || (this.idRequisito != null && !this.idRequisito.equals(other.idRequisito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tpi.CasosAcad.Entidades.Requisito[ idRequisito=" + idRequisito + " ]";
    }
    
}
