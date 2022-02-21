/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import facade.TransporteFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import modelo.TipoTransporte;
import modelo.Transporte;

/**
 *
 * @author edwin
 */
@Named(value = "vehiculoManagedBean")
@SessionScoped
public class vehiculoManagedBean implements Serializable {

    @EJB
    private TransporteFacadeLocal transporteFL;

    @Inject
    Conversation conversacion;

    private Transporte transporteSeleccionado;
    private List<Transporte> lstTransporte;
    private String identificacionTransporte;

    public vehiculoManagedBean() {
    }

    @PostConstruct
    public void init() {
        this.transporteSeleccionado = new Transporte();
        this.lstTransporte = this.transporteFL.findAll();
    }

    public TransporteFacadeLocal getTransporteFL() {
        return transporteFL;
    }

    public void setTransporteFL(TransporteFacadeLocal transporteFL) {
        this.transporteFL = transporteFL;
    }

    public Transporte getTransporteSeleccionado() {
        return transporteSeleccionado;
    }

    public void setTransporteSeleccionado(Transporte transporteSeleccionado) {
        this.transporteSeleccionado = transporteSeleccionado;
    }

    public List<Transporte> getLstTransporte() {
        return lstTransporte;
    }

    public void setLstTransporte(List<Transporte> lstTransporte) {
        this.lstTransporte = lstTransporte;
    }

    public String getIdentificacionTransporte() {
        return identificacionTransporte;
    }

    public void setIdentificacionTransporte(String identificacionTransporte) {
        this.identificacionTransporte = identificacionTransporte;
    }

    public void iniciaConversacion() {
        if (conversacion.isTransient()) {
            conversacion.begin();
        }
    }

    public void finalizaConversacion() {
        if (conversacion.isTransient()) {
            conversacion.end();
        }
    }

    public String inciarCrearVehiculo() {
        return "crearVehiculo.xhtml?faces-redirect=true";
    }

    public String crearVehiculo() {
        FacesContext fc = FacesContext.getCurrentInstance();
        if (this.transporteSeleccionado.getFkidTipoTransporte().getIdTipoTransporte() == 1) {
            if (this.identificacionTransporte.length() > 0) {
                String path = "[a-zA-Z]{3}[0-9]{4}[a-zA-Z]{1}";
                if (this.identificacionTransporte.matches(path)) {
                    this.transporteSeleccionado.setIdentificacionTransporte(identificacionTransporte.toUpperCase());
                    this.transporteSeleccionado.setEstado(1);
                    this.transporteFL.create(transporteSeleccionado);
                    return "lstVehiculo.xhtml?faces-redirect=true";
                } else {
                    FacesMessage usuarioExiste = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Para transporte maritimo: "
                            + "El formato debe corresponder a 3 letras iniciales, seguidas de 4 números y finalizando con una letra", "");
                    fc.addMessage("formCreaVehiculo", usuarioExiste);
                }
            } else {
                FacesMessage usuarioExiste = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ingrese un codigo de identificacion", " para transporte maritimo");
                fc.addMessage("formCreaVehiculo", usuarioExiste);
            }
        } else {
            if (this.identificacionTransporte.length() > 0) {
                String path = "[a-zA-Z]{3}[0-9]{3}";
                if (this.identificacionTransporte.matches(path)) {
                    this.transporteSeleccionado.setIdentificacionTransporte(identificacionTransporte.toUpperCase());
                    this.transporteSeleccionado.setEstado(1);
                    this.transporteFL.create(transporteSeleccionado);
                    return "lstVehiculo.xhtml?faces-redirect=true";
                } else {
                    FacesMessage usuarioExiste = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Para transporte terrestre: "
                            + "El formato debe corresponder a 3 letras iniciales y 3 números finales", "");
                    fc.addMessage("formCreaVehiculo", usuarioExiste);
                }
            } else {
                FacesMessage usuarioExiste = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ingrese un codigo de identificacion", " para transporte terrestre");
                fc.addMessage("formCreaVehiculo", usuarioExiste);
            }
        }
        return "";
    }

    public void buscarTransporte() {
        FacesContext fc = FacesContext.getCurrentInstance();
        this.lstTransporte = this.transporteFL.lstTransporteIdentificacion(identificacionTransporte);
        if (!this.identificacionTransporte.isEmpty()) {
            if (this.lstTransporte.size() > 0) {
                this.lstTransporte = this.transporteFL.lstTransporteIdentificacion(identificacionTransporte);
            } else {
                FacesMessage usuarioExiste = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se encontraron registros", " con los datos ingresados");
                fc.addMessage("formLstCliente", usuarioExiste);
            }
        } else {
            FacesMessage usuarioExiste = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ingrese un codigo de identificacion", " para realizar la busqueda");
            fc.addMessage("formLstCliente", usuarioExiste);
        }
    }

}
