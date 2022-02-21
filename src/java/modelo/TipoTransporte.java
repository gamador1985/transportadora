/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author edwin
 */
@Entity
@Table(name = "tipotransporte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoTransporte.findAll", query = "SELECT t FROM TipoTransporte t")
    , @NamedQuery(name = "TipoTransporte.findByIdTipoTransporte", query = "SELECT t FROM TipoTransporte t WHERE t.idTipoTransporte = :idTipoTransporte")
    , @NamedQuery(name = "TipoTransporte.findByNombreTipoTransporte", query = "SELECT t FROM TipoTransporte t WHERE t.nombreTipoTransporte = :nombreTipoTransporte")})
public class TipoTransporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoTransporte")
    private Integer idTipoTransporte;
    @Size(max = 255)
    @Column(name = "nombreTipoTransporte")
    private String nombreTipoTransporte;
    @OneToMany(mappedBy = "fkidTipoTransporte", fetch = FetchType.LAZY)
    private List<Transporte> transporteList;

    public TipoTransporte() {
    }

    public TipoTransporte(Integer idTipoTransporte) {
        this.idTipoTransporte = idTipoTransporte;
    }

    public Integer getIdTipoTransporte() {
        return idTipoTransporte;
    }

    public void setIdTipoTransporte(Integer idTipoTransporte) {
        this.idTipoTransporte = idTipoTransporte;
    }

    public String getNombreTipoTransporte() {
        return nombreTipoTransporte;
    }

    public void setNombreTipoTransporte(String nombreTipoTransporte) {
        this.nombreTipoTransporte = nombreTipoTransporte;
    }

    @XmlTransient
    public List<Transporte> getTransporteList() {
        return transporteList;
    }

    public void setTransporteList(List<Transporte> transporteList) {
        this.transporteList = transporteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoTransporte != null ? idTipoTransporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoTransporte)) {
            return false;
        }
        TipoTransporte other = (TipoTransporte) object;
        if ((this.idTipoTransporte == null && other.idTipoTransporte != null) || (this.idTipoTransporte != null && !this.idTipoTransporte.equals(other.idTipoTransporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TipoTransporte[ idTipoTransporte=" + idTipoTransporte + " ]";
    }

}
