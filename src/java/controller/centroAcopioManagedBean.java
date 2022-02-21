package controller;

import facade.CentroAcopioFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.ConversationScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import modelo.CentroAcopio;

@Named(value = "centroAcopioManagedBean")
@ConversationScoped
public class centroAcopioManagedBean implements Serializable {

    @EJB
    private CentroAcopioFacadeLocal centroAcopioFL;

    @Inject
    Conversation conversacion;

    private List<CentroAcopio> lstCentroAcopio;
    private List<CentroAcopio> lstCentroCliente;
    private CentroAcopio centroAcopioSeleccionado;
    private int tipoCentroAcopio;

    public centroAcopioManagedBean() {
    }

    @PostConstruct
    public void init() {
        this.centroAcopioSeleccionado = new CentroAcopio();
        this.lstCentroAcopio = this.centroAcopioFL.findAll();
    }

    public CentroAcopioFacadeLocal getCentroAcopioFL() {
        return centroAcopioFL;
    }

    public void setCentroAcopioFL(CentroAcopioFacadeLocal centroAcopioFL) {
        this.centroAcopioFL = centroAcopioFL;
    }

    public List<CentroAcopio> getLstCentroAcopio() {
        return lstCentroAcopio;
    }

    public void setLstCentroAcopio(List<CentroAcopio> lstCentroAcopio) {
        this.lstCentroAcopio = lstCentroAcopio;
    }

    public CentroAcopio getCentroAcopioSeleccionado() {
        return centroAcopioSeleccionado;
    }

    public void setCentroAcopioSeleccionado(CentroAcopio centroAcopioSeleccionado) {
        this.centroAcopioSeleccionado = centroAcopioSeleccionado;
    }

    public int getTipoCentroAcopio() {
        return tipoCentroAcopio;
    }

    public void setTipoCentroAcopio(int tipoCentroAcopio) {
        this.tipoCentroAcopio = tipoCentroAcopio;
    }

    public List<CentroAcopio> getLstCentroCliente() {
        return lstCentroCliente;
    }

    public void setLstCentroCliente(List<CentroAcopio> lstCentroCliente) {
        this.lstCentroCliente = lstCentroCliente;
    }

    public void inciaConversacion() {
        if (conversacion.isTransient()) {
            conversacion.begin();
        }
    }

    public void finalizaConversacion() {
        if (conversacion.isTransient()) {
            conversacion.end();
        }
    }

    public String iniciarCrearCentroAcopio() {
        return "crearCentroAcopio.xhtml?faces-redirect=true";
    }

    public String crearCentroAcopio() {
        FacesContext fc = FacesContext.getCurrentInstance();
        if (!this.centroAcopioSeleccionado.getNombreCentroAcopio().isEmpty() && this.centroAcopioSeleccionado.getNombreCentroAcopio().length() > 0) {
            if (!this.centroAcopioSeleccionado.getDireccion().isEmpty() && this.centroAcopioSeleccionado.getDireccion().length() > 0) {
                if (!this.centroAcopioSeleccionado.getLocacion().isEmpty() && this.centroAcopioSeleccionado.getLocacion().length() > 0) {
                    this.centroAcopioFL.crearCentroAcopio(this.centroAcopioSeleccionado.getNombreCentroAcopio(),
                            this.centroAcopioSeleccionado.getDireccion(),
                            this.centroAcopioSeleccionado.getLocacion(),
                            this.centroAcopioSeleccionado.getFkidCliente().getIdCliente(),
                            tipoCentroAcopio);
                    return "lstCentroAcopio.xhtml?faces-redirect=true";
                } else {
                    FacesMessage usuarioExiste = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ingrese la locacion del centro de acopio", "");
                    fc.addMessage("formCreaCentroAcopio", usuarioExiste);
                }
            } else {
                FacesMessage usuarioExiste = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ingrese la direccion del centro de acopio", "");
                fc.addMessage("formCreaCentroAcopio", usuarioExiste);
            }
        } else {
            FacesMessage usuarioExiste = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ingrese el nombre del centro de acopio", "");
            fc.addMessage("formCreaCentroAcopio", usuarioExiste);
        }
        return "";
    }

    public void buscarCentroAcopio() {
        FacesContext fc = FacesContext.getCurrentInstance();
        if (!this.centroAcopioSeleccionado.getNombreCentroAcopio().isEmpty()) {
            this.lstCentroAcopio = this.centroAcopioFL.lstCentroAcopioNombre(this.centroAcopioSeleccionado.getNombreCentroAcopio());
            if (this.lstCentroAcopio.size() > 0) {
                this.lstCentroAcopio = this.centroAcopioFL.lstCentroAcopioNombre(this.centroAcopioSeleccionado.getNombreCentroAcopio());
            } else {
                FacesMessage usuarioExiste = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No existen registros para los datos ingresados", "");
                fc.addMessage("formCentroAcopio", usuarioExiste);
            }
        } else {
            FacesMessage usuarioExiste = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ingrese el nombre del centro de acopio", "");
            fc.addMessage("formCentroAcopio", usuarioExiste);
        }
    }

}
