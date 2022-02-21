/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
 * @author edwin
 */
@Entity
@Table(name = "detalleenvio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleEnvio.findAll", query = "SELECT d FROM DetalleEnvio d")
    , @NamedQuery(name = "DetalleEnvio.findByIdDetalleEnvio", query = "SELECT d FROM DetalleEnvio d WHERE d.idDetalleEnvio = :idDetalleEnvio")
    , @NamedQuery(name = "DetalleEnvio.findByValorUnidad", query = "SELECT d FROM DetalleEnvio d WHERE d.valorUnidad = :valorUnidad")
    , @NamedQuery(name = "DetalleEnvio.findByCantidad", query = "SELECT d FROM DetalleEnvio d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "DetalleEnvio.findByValorTotal", query = "SELECT d FROM DetalleEnvio d WHERE d.valorTotal = :valorTotal")})
public class DetalleEnvio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDetalleEnvio")
    private Integer idDetalleEnvio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorUnidad")
    private Double valorUnidad;
    @Column(name = "cantidad")
    private Double cantidad;
    @Column(name = "valorTotal")
    private Double valorTotal;
    @JoinColumn(name = "fkIdEnvio", referencedColumnName = "idEnvio")
    @ManyToOne(fetch = FetchType.LAZY)
    private Envio fkIdEnvio;
    @JoinColumn(name = "fkidProducto", referencedColumnName = "idProducto")
    @ManyToOne(fetch = FetchType.LAZY)
    private Producto fkidProducto;

    public DetalleEnvio() {
    }

    public DetalleEnvio(Integer idDetalleEnvio) {
        this.idDetalleEnvio = idDetalleEnvio;
    }

    public Integer getIdDetalleEnvio() {
        return idDetalleEnvio;
    }

    public void setIdDetalleEnvio(Integer idDetalleEnvio) {
        this.idDetalleEnvio = idDetalleEnvio;
    }

    public Double getValorUnidad() {
        return valorUnidad;
    }

    public void setValorUnidad(Double valorUnidad) {
        this.valorUnidad = valorUnidad;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Envio getFkIdEnvio() {
        return fkIdEnvio;
    }

    public void setFkIdEnvio(Envio fkIdEnvio) {
        this.fkIdEnvio = fkIdEnvio;
    }

    public Producto getFkidProducto() {
        return fkidProducto;
    }

    public void setFkidProducto(Producto fkidProducto) {
        this.fkidProducto = fkidProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleEnvio != null ? idDetalleEnvio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleEnvio)) {
            return false;
        }
        DetalleEnvio other = (DetalleEnvio) object;
        if ((this.idDetalleEnvio == null && other.idDetalleEnvio != null) || (this.idDetalleEnvio != null && !this.idDetalleEnvio.equals(other.idDetalleEnvio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.DetalleEnvio[ idDetalleEnvio=" + idDetalleEnvio + " ]";
    }
    
}
