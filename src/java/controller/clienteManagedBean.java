/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import facade.ClienteFacadeLocal;
import facade.ProductoFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import modelo.Cliente;
import modelo.Producto;

/**
 *
 * @author edwin
 */
@Named(value = "clienteManagedBean")
@ConversationScoped

public class clienteManagedBean implements Serializable {

    @EJB
    private ClienteFacadeLocal clienteFL;

    @EJB
    private ProductoFacadeLocal productoFL;

    @Inject
    Conversation conversacion;

    @Inject
    productoManagedBean productoMB;

    private List<Cliente> lstCliente;
    private Cliente clienteSeleccionado;
    private boolean bloqueo = true;
    private String nombreCliente;

    public clienteManagedBean() {
    }

    @PostConstruct
    public void init() {
        this.clienteSeleccionado = new Cliente();
        this.lstCliente = this.clienteFL.findAll();
    }

    public ClienteFacadeLocal getClienteFL() {
        return clienteFL;
    }

    public void setClienteFL(ClienteFacadeLocal clienteFL) {
        this.clienteFL = clienteFL;
    }

    public List<Cliente> getLstCliente() {
        return lstCliente;
    }

    public void setLstCliente(List<Cliente> lstCliente) {
        this.lstCliente = lstCliente;
    }

    public Cliente getClienteSeleccionado() {
        return clienteSeleccionado;
    }

    public void setClienteSeleccionado(Cliente clienteSeleccionado) {
        this.clienteSeleccionado = clienteSeleccionado;
    }

    public boolean isBloqueo() {
        return bloqueo;
    }

    public void setBloqueo(boolean bloqueo) {
        this.bloqueo = bloqueo;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
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

    public String iniciaCrearCliente() {
        return "crearCliente.xhtml?faces-redirect=true";
    }

    public String crearCliente() {
        FacesContext fc = FacesContext.getCurrentInstance();
        if (!this.clienteSeleccionado.getNombreCliente().isEmpty() && this.clienteSeleccionado.getNombreCliente().length() > 0) {
            if (!this.clienteSeleccionado.getDireccion().isEmpty() && this.clienteSeleccionado.getDireccion().length() > 0) {
                if (!this.clienteSeleccionado.getNombreContacto().isEmpty() && this.clienteSeleccionado.getNombreContacto().length() > 0) {
                    if (!this.clienteSeleccionado.getTelefonoContacto().isEmpty() && this.clienteSeleccionado.getTelefonoContacto().length() > 0) {
                        this.clienteFL.create(clienteSeleccionado);
                        return "lstCliente.xhtml?faces-redirect=true";
                    } else {
                        FacesMessage usuarioExiste = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ingrese el telefono de contacto", "");
                        fc.addMessage("formCreaCliente", usuarioExiste);
                    }
                } else {
                    FacesMessage usuarioExiste = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ingrese el nombre de contacto", "");
                    fc.addMessage("formCreaCliente", usuarioExiste);
                }
            } else {
                FacesMessage usuarioExiste = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ingrese la dirección del cliente", "");
                fc.addMessage("formCreaCliente", usuarioExiste);
            }
        } else {
            FacesMessage usuarioExiste = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ingrese el nombre del cliente", "");
            fc.addMessage("formCreaCliente", usuarioExiste);
        }
        return "";
    }

    public String alistarEditarCLiente(Cliente cliente) {
        iniciaConversacion();
        this.clienteSeleccionado = cliente;
        return "editarCliente.xhtml?faces-redirect=true";
    }

    public String guardarCambios() {
        FacesContext fc = FacesContext.getCurrentInstance();
        if (!this.clienteSeleccionado.getNombreCliente().isEmpty() && this.clienteSeleccionado.getNombreCliente().length() > 0) {
            if (!this.clienteSeleccionado.getDireccion().isEmpty() && this.clienteSeleccionado.getDireccion().length() > 0) {
                if (!this.clienteSeleccionado.getNombreContacto().isEmpty() && this.clienteSeleccionado.getNombreContacto().length() > 0) {
                    if (!this.clienteSeleccionado.getTelefonoContacto().isEmpty() && this.clienteSeleccionado.getTelefonoContacto().length() > 0) {
                        this.clienteFL.edit(clienteSeleccionado);
                        finalizaConversacion();
                        this.clienteSeleccionado = new Cliente();
                        return "lstCliente.xhtml?faces-redirect=true";
                    } else {
                        FacesMessage usuarioExiste = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ingrese el telefono de contacto", "");
                        fc.addMessage("formEditaCliente", usuarioExiste);
                    }
                } else {
                    FacesMessage usuarioExiste = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ingrese el nombre de contacto", "");
                    fc.addMessage("formEditaCliente", usuarioExiste);
                }
            } else {
                FacesMessage usuarioExiste = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ingrese la dirección del cliente", "");
                fc.addMessage("formEditaCliente", usuarioExiste);
            }
        } else {
            FacesMessage usuarioExiste = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ingrese el nombre del cliente", "");
            fc.addMessage("formEditaCliente", usuarioExiste);
        }
        return "";
    }

    public String cancelaGuardarCambios() {
        finalizaConversacion();
        this.clienteSeleccionado = new Cliente();
        return "lstCliente.xhtml?faces-redirect=true";
    }

    public String agregarArticulos(Cliente cliente) {
        iniciaConversacion();
        this.clienteSeleccionado = cliente;
        return "agregarArticulo.xhtml?faces-redirect=true";
    }

    public void buscarCliente() {
        FacesContext fc = FacesContext.getCurrentInstance();
        this.lstCliente = clienteFL.lstClienteNombre(nombreCliente);
        if (!this.nombreCliente.isEmpty() && this.nombreCliente != null) {
            if (this.lstCliente.size() != 0) {
                this.lstCliente = clienteFL.lstClienteNombre(nombreCliente);
            } else {
                FacesMessage usuarioExiste = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El cliente no existe", "");
                fc.addMessage("formLstCliente", usuarioExiste);
            }
        } else {
            FacesMessage usuarioExiste = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ingrese un nombre de cliente", "");
            fc.addMessage("formLstCliente", usuarioExiste);
        }
    }

    public void crearProductos() {
        FacesContext fc = FacesContext.getCurrentInstance();
        List<Producto> productos = productoMB.getLstProducto();
        if (!productos.isEmpty()) {
            for (Producto pd : productos) {
                pd.setFkCliente(clienteSeleccionado);
                productoFL.create(pd);
            }
            productoMB.setLstProducto(new ArrayList<>());
        } else {
            FacesMessage usuarioExiste = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No hay datos para crear una lista", "");
            fc.addMessage("formArticulo", usuarioExiste);
        }
    }

}
