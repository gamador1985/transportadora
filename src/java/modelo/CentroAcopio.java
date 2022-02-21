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
@Table(name = "centroacopio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CentroAcopio.findAll", query = "SELECT c FROM CentroAcopio c")
    , @NamedQuery(name = "CentroAcopio.findByIdCentroAcopio", query = "SELECT c FROM CentroAcopio c WHERE c.idCentroAcopio = :idCentroAcopio")
    , @NamedQuery(name = "CentroAcopio.findByNombreCentroAcopio", query = "SELECT c FROM CentroAcopio c WHERE c.nombreCentroAcopio = :nombreCentroAcopio")
    , @NamedQuery(name = "CentroAcopio.findByDireccion", query = "SELECT c FROM CentroAcopio c WHERE c.direccion = :direccion")
    , @NamedQuery(name = "CentroAcopio.findByLocacion", query = "SELECT c FROM CentroAcopio c WHERE c.locacion = :locacion")})
public class CentroAcopio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCentroAcopio")
    private Integer idCentroAcopio;
    @Size(max = 255)
    @Column(name = "nombreCentroAcopio")
    private String nombreCentroAcopio;
    @Size(max = 255)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 255)
    @Column(name = "locacion")
    private String locacion;
    @OneToMany(mappedBy = "fkIdCentroAcopio", fetch = FetchType.LAZY)
    private List<Envio> envioList;
    @JoinColumn(name = "fkidCliente", referencedColumnName = "idCliente")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente fkidCliente;
    @JoinColumn(name = "fkIdTipoCentroAcopio", referencedColumnName = "idTipoCentroAcopio")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipocentroAcopio fkIdTipoCentroAcopio;

    public CentroAcopio() {
    }

    public CentroAcopio(Integer idCentroAcopio) {
        this.idCentroAcopio = idCentroAcopio;
    }

    public Integer getIdCentroAcopio() {
        return idCentroAcopio;
    }

    public void setIdCentroAcopio(Integer idCentroAcopio) {
        this.idCentroAcopio = idCentroAcopio;
    }

    public String getNombreCentroAcopio() {
        return nombreCentroAcopio;
    }

    public void setNombreCentroAcopio(String nombreCentroAcopio) {
        this.nombreCentroAcopio = nombreCentroAcopio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocacion() {
        return locacion;
    }

    public void setLocacion(String locacion) {
        this.locacion = locacion;
    }

    @XmlTransient
    public List<Envio> getEnvioList() {
        return envioList;
    }

    public void setEnvioList(List<Envio> envioList) {
        this.envioList = envioList;
    }

    public Cliente getFkidCliente() {
        return fkidCliente;
    }

    public void setFkidCliente(Cliente fkidCliente) {
        this.fkidCliente = fkidCliente;
    }

    public TipocentroAcopio getFkIdTipoCentroAcopio() {
        return fkIdTipoCentroAcopio;
    }

    public void setFkIdTipoCentroAcopio(TipocentroAcopio fkIdTipoCentroAcopio) {
        this.fkIdTipoCentroAcopio = fkIdTipoCentroAcopio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCentroAcopio != null ? idCentroAcopio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CentroAcopio)) {
            return false;
        }
        CentroAcopio other = (CentroAcopio) object;
        if ((this.idCentroAcopio == null && other.idCentroAcopio != null) || (this.idCentroAcopio != null && !this.idCentroAcopio.equals(other.idCentroAcopio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.CentroAcopio[ idCentroAcopio=" + idCentroAcopio + " ]";
    }
    
}
