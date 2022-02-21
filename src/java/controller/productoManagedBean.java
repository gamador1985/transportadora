package controller;

import facade.ProductoFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import modelo.Producto;

/**
 *
 * @author edwin
 */
@Named(value = "productoManagedBean")
@ConversationScoped
public class productoManagedBean implements Serializable {

    @EJB
    private ProductoFacadeLocal productoFL;

    @Inject
    Conversation conversacion;

    @Inject
    clienteManagedBean clienteSeleccionado;

    private List<Producto> lstProducto;
    private Producto productoSeleccionado;
    private String nombreProducto;
    private int cliente;

    public productoManagedBean() {
    }

    @PostConstruct
    public void init() {
        this.productoSeleccionado = new Producto();
//        this.lstProducto = this.productoFL.findAll();
    }

    public ProductoFacadeLocal getProductoFL() {
        return productoFL;
    }

    public void setProductoFL(ProductoFacadeLocal productoFL) {
        this.productoFL = productoFL;
    }

    public List<Producto> getLstProducto() {
        return lstProducto;
    }

    public void setLstProducto(List<Producto> lstProducto) {
        this.lstProducto = lstProducto;
    }

    public Producto getProductoSeleccionado() {
        return productoSeleccionado;
    }

    public void setProductoSeleccionado(Producto productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void agregarDetalleProducto() {
        FacesContext fc = FacesContext.getCurrentInstance();
        this.cliente = clienteSeleccionado.getClienteSeleccionado().getIdCliente();
        if (!this.nombreProducto.isEmpty()) {
            this.productoSeleccionado.setFechaCreado(new Date());
            this.productoSeleccionado.setEstado(1);
            this.productoSeleccionado.setNombreProducto(nombreProducto.toUpperCase());
            this.lstProducto.add(productoSeleccionado);
            this.productoSeleccionado = new Producto();
            this.nombreProducto = null;
        } else {
            FacesMessage usuarioExiste = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ingrese un nombre de articulo", "");
            fc.addMessage("formArticulo", usuarioExiste);
        }
    }

    public void remonverProducto(int index) {
        this.lstProducto.remove(index);
    }
    
    public String cancelaCrearProductos(){
        lstProducto = new ArrayList<>();
        return "lstCliente.xhtml?faces-redirect=true";
    }

}
