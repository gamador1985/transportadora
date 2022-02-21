package controller;

import facade.TipocentroAcopioFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.ConversationScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import modelo.TipocentroAcopio;

@Named(value = "tipoCentroAcopio")
@ConversationScoped
public class tipoCentroAcopio implements Serializable {

    @EJB
    private TipocentroAcopioFacadeLocal tipoCentroAcopioFL;
    
    private List<TipocentroAcopio> lstTipoCentroAcopio;

    public tipoCentroAcopio() {
    }
    
    @PostConstruct
    public void init(){
        this.lstTipoCentroAcopio = this.tipoCentroAcopioFL.findAll();
    }

    public TipocentroAcopioFacadeLocal getTipoCentroAcopioFL() {
        return tipoCentroAcopioFL;
    }

    public void setTipoCentroAcopioFL(TipocentroAcopioFacadeLocal tipoCentroAcopioFL) {
        this.tipoCentroAcopioFL = tipoCentroAcopioFL;
    }

    public List<TipocentroAcopio> getLstTipoCentroAcopio() {
        return lstTipoCentroAcopio;
    }

    public void setLstTipoCentroAcopio(List<TipocentroAcopio> lstTipoCentroAcopio) {
        this.lstTipoCentroAcopio = lstTipoCentroAcopio;
    }
    
    

}
