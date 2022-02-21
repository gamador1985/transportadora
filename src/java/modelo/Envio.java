/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author edwin
 */
@Entity
@Table(name = "envio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Envio.findAll", query = "SELECT e FROM Envio e")
    , @NamedQuery(name = "Envio.findByIdEnvio", query = "SELECT e FROM Envio e WHERE e.idEnvio = :idEnvio")
    , @NamedQuery(name = "Envio.findByNumeroGuia", query = "SELECT e FROM Envio e WHERE e.numeroGuia = :numeroGuia")
    , @NamedQuery(name = "Envio.findByFechaIngreso", query = "SELECT e FROM Envio e WHERE e.fechaIngreso = :fechaIngreso")
    , @NamedQuery(name = "Envio.findByFechaEntrega", query = "SELECT e FROM Envio e WHERE e.fechaEntrega = :fechaEntrega")
    , @NamedQuery(name = "Envio.findByCantidadEnvio", query = "SELECT e FROM Envio e WHERE e.cantidadEnvio = :cantidadEnvio")
    , @NamedQuery(name = "Envio.findByValorEnvio", query = "SELECT e FROM Envio e WHERE e.valorEnvio = :valorEnvio")
    , @NamedQuery(name = "Envio.findByPorcentajeDescuento", query = "SELECT e FROM Envio e WHERE e.porcentajeDescuento = :porcentajeDescuento")
    , @NamedQuery(name = "Envio.findByValorDescuento", query = "SELECT e FROM Envio e WHERE e.valorDescuento = :valorDescuento")})
public class Envio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEnvio")
    private Integer idEnvio;
    @Size(max = 10)
    @Column(name = "numeroGuia")
    private String numeroGuia;
    @Column(name = "fechaIngreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Column(name = "fechaEntrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @Column(name = "cantidadEnvio")
    private Integer cantidadEnvio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorEnvio")
    private Double valorEnvio;
    @Column(name = "porcentajeDescuento")
    private Integer porcentajeDescuento;
    @Column(name = "valorDescuento")
    private Double valorDescuento;
    @JoinColumn(name = "fkIdCentroAcopio", referencedColumnName = "idCentroAcopio")
    @ManyToOne
    private CentroAcopio fkIdCentroAcopio;
    @JoinColumn(name = "fkIdTransporte", referencedColumnName = "idTransporte")
    @ManyToOne
    private Transporte fkIdTransporte;

    public Envio() {
    }

    public Envio(Integer idEnvio) {
        this.idEnvio = idEnvio;
    }

    public Integer getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(Integer idEnvio) {
        this.idEnvio = idEnvio;
    }

    public String getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(String numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Integer getCantidadEnvio() {
        return cantidadEnvio;
    }

    public void setCantidadEnvio(Integer cantidadEnvio) {
        this.cantidadEnvio = cantidadEnvio;
    }

    public Double getValorEnvio() {
        return valorEnvio;
    }

    public void setValorEnvio(Double valorEnvio) {
        this.valorEnvio = valorEnvio;
    }

    public Integer getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(Integer porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public Double getValorDescuento() {
        return valorDescuento;
    }

    public void setValorDescuento(Double valorDescuento) {
        this.valorDescuento = valorDescuento;
    }

    public CentroAcopio getFkIdCentroAcopio() {
        return fkIdCentroAcopio;
    }

    public void setFkIdCentroAcopio(CentroAcopio fkIdCentroAcopio) {
        this.fkIdCentroAcopio = fkIdCentroAcopio;
    }

    public Transporte getFkIdTransporte() {
        return fkIdTransporte;
    }

    public void setFkIdTransporte(Transporte fkIdTransporte) {
        this.fkIdTransporte = fkIdTransporte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEnvio != null ? idEnvio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Envio)) {
            return false;
        }
        Envio other = (Envio) object;
        if ((this.idEnvio == null && other.idEnvio != null) || (this.idEnvio != null && !this.idEnvio.equals(other.idEnvio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Envio[ idEnvio=" + idEnvio + " ]";
    }
    
}
