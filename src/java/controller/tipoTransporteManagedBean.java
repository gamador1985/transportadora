package controller;

import facade.TipoTransporteFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import modelo.TipoTransporte;

/**
 *
 * @author edwin
 */
@Named(value = "tipoTransporteManagedBean")
@ConversationScoped
public class tipoTransporteManagedBean implements Serializable {

    @EJB
    private TipoTransporteFacadeLocal tipoTransporteFL;
    private List<TipoTransporte> lstTipoTransporte = new ArrayList<>();

    public tipoTransporteManagedBean() {
    }

    @PostConstruct
    public void init() {
        this.lstTipoTransporte = this.tipoTransporteFL.findAll();
    }

    public TipoTransporteFacadeLocal getTipoTransporteFL() {
        return tipoTransporteFL;
    }

    public void setTipoTransporteFL(TipoTransporteFacadeLocal tipoTransporteFL) {
        this.tipoTransporteFL = tipoTransporteFL;
    }

    public List<TipoTransporte> getLstTipoTransporte() {
        return lstTipoTransporte;
    }

    public void setLstTipoTransporte(List<TipoTransporte> lstTipoTransporte) {
        this.lstTipoTransporte = lstTipoTransporte;
    }

}
