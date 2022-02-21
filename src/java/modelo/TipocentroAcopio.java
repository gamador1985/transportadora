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
@Table(name = "tipocentroacopio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipocentroAcopio.findAll", query = "SELECT t FROM TipocentroAcopio t")
    , @NamedQuery(name = "TipocentroAcopio.findByIdTipoCentroAcopio", query = "SELECT t FROM TipocentroAcopio t WHERE t.idTipoCentroAcopio = :idTipoCentroAcopio")
    , @NamedQuery(name = "TipocentroAcopio.findByNombreTipoCentroAcopio", query = "SELECT t FROM TipocentroAcopio t WHERE t.nombreTipoCentroAcopio = :nombreTipoCentroAcopio")})
public class TipocentroAcopio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoCentroAcopio")
    private Integer idTipoCentroAcopio;
    @Size(max = 255)
    @Column(name = "nombreTipoCentroAcopio")
    private String nombreTipoCentroAcopio;
    @OneToMany(mappedBy = "fkIdTipoCentroAcopio", fetch = FetchType.LAZY)
    private List<CentroAcopio> centroAcopioList;

    public TipocentroAcopio() {
    }

    public TipocentroAcopio(Integer idTipoCentroAcopio) {
        this.idTipoCentroAcopio = idTipoCentroAcopio;
    }

    public Integer getIdTipoCentroAcopio() {
        return idTipoCentroAcopio;
    }

    public void setIdTipoCentroAcopio(Integer idTipoCentroAcopio) {
        this.idTipoCentroAcopio = idTipoCentroAcopio;
    }

    public String getNombreTipoCentroAcopio() {
        return nombreTipoCentroAcopio;
    }

    public void setNombreTipoCentroAcopio(String nombreTipoCentroAcopio) {
        this.nombreTipoCentroAcopio = nombreTipoCentroAcopio;
    }

    @XmlTransient
    public List<CentroAcopio> getCentroAcopioList() {
        return centroAcopioList;
    }

    public void setCentroAcopioList(List<CentroAcopio> centroAcopioList) {
        this.centroAcopioList = centroAcopioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoCentroAcopio != null ? idTipoCentroAcopio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipocentroAcopio)) {
            return false;
        }
        TipocentroAcopio other = (TipocentroAcopio) object;
        if ((this.idTipoCentroAcopio == null && other.idTipoCentroAcopio != null) || (this.idTipoCentroAcopio != null && !this.idTipoCentroAcopio.equals(other.idTipoCentroAcopio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TipocentroAcopio[ idTipoCentroAcopio=" + idTipoCentroAcopio + " ]";
    }
    
}
