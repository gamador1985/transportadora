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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "transporte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transporte.findAll", query = "SELECT t FROM Transporte t")
    , @NamedQuery(name = "Transporte.findByIdTransporte", query = "SELECT t FROM Transporte t WHERE t.idTransporte = :idTransporte")
    , @NamedQuery(name = "Transporte.findByIdentificacionTransporte", query = "SELECT t FROM Transporte t WHERE t.identificacionTransporte = :identificacionTransporte")
    , @NamedQuery(name = "Transporte.findByEstado", query = "SELECT t FROM Transporte t WHERE t.estado = :estado")})
public class Transporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTransporte")
    private Integer idTransporte;
    @Size(max = 8)
    @Column(name = "identificacionTransporte")
    private String identificacionTransporte;
    @Column(name = "estado")
    private Integer estado;
    @OneToMany(mappedBy = "fkIdTransporte", fetch = FetchType.LAZY)
    private List<Envio> envioList;
    @JoinColumn(name = "fkidTipoTransporte", referencedColumnName = "idTipoTransporte")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoTransporte fkidTipoTransporte;

    public Transporte() {
    }

    public Transporte(Integer idTransporte) {
        this.idTransporte = idTransporte;
    }

    public Integer getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(Integer idTransporte) {
        this.idTransporte = idTransporte;
    }

    public String getIdentificacionTransporte() {
        return identificacionTransporte;
    }

    public void setIdentificacionTransporte(String identificacionTransporte) {
        this.identificacionTransporte = identificacionTransporte;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Envio> getEnvioList() {
        return envioList;
    }

    public void setEnvioList(List<Envio> envioList) {
        this.envioList = envioList;
    }

    public TipoTransporte getFkidTipoTransporte() {
        return fkidTipoTransporte;
    }

    public void setFkidTipoTransporte(TipoTransporte fkidTipoTransporte) {
        this.fkidTipoTransporte = fkidTipoTransporte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransporte != null ? idTransporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transporte)) {
            return false;
        }
        Transporte other = (Transporte) object;
        if ((this.idTransporte == null && other.idTransporte != null) || (this.idTransporte != null && !this.idTransporte.equals(other.idTransporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Transporte[ idTransporte=" + idTransporte + " ]";
    }
    
}
