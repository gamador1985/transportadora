package controller;

import facade.CentroAcopioFacadeLocal;
import facade.EnvioFacadeLocal;
import facade.TransporteFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import modelo.CentroAcopio;
import modelo.Cliente;
import modelo.Envio;
import modelo.TipoTransporte;
import modelo.Transporte;

@Named(value = "envioManagedBean")
@SessionScoped
public class envioManagedBean implements Serializable {

    @EJB
    private EnvioFacadeLocal envioFL;

    @EJB
    private CentroAcopioFacadeLocal centroAcopioFL;

    @EJB
    private TransporteFacadeLocal transporteFL;

    @Inject
    Conversation conversacion;

    private List<Envio> lstEvnio;
    private List<CentroAcopio> lstCentroAcopio;
    private List<Transporte> lstTipoTransporte;
    private Cliente clienteSeleccionado;
    private TipoTransporte tipoTransporteSeleccionado;
    private Envio envioSeleccionado;
    private int cliente;
    private String codigoGuia;

    public envioManagedBean() {
    }

    @PostConstruct
    public void init() {
        this.envioSeleccionado = new Envio();
        this.lstEvnio = this.envioFL.findAll();
    }

    public EnvioFacadeLocal getEnvioFL() {
        return envioFL;
    }

    public void setEnvioFL(EnvioFacadeLocal envioFL) {
        this.envioFL = envioFL;
    }

    public List<Envio> getLstEvnio() {
        return lstEvnio;
    }

    public void setLstEvnio(List<Envio> lstEvnio) {
        this.lstEvnio = lstEvnio;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public Cliente getClienteSeleccionado() {
        return clienteSeleccionado;
    }

    public void setClienteSeleccionado(Cliente clienteSeleccionado) {
        this.clienteSeleccionado = clienteSeleccionado;
    }

    public List<CentroAcopio> getLstCentroAcopio() {
        return lstCentroAcopio;
    }

    public void setLstCentroAcopio(List<CentroAcopio> lstCentroAcopio) {
        this.lstCentroAcopio = lstCentroAcopio;
    }

    public TipoTransporte getTipoTransporteSeleccionado() {
        return tipoTransporteSeleccionado;
    }

    public void setTipoTransporteSeleccionado(TipoTransporte tipoTransporteSeleccionado) {
        this.tipoTransporteSeleccionado = tipoTransporteSeleccionado;
    }

    public List<Transporte> getLstTipoTransporte() {
        return lstTipoTransporte;
    }

    public void setLstTipoTransporte(List<Transporte> lstTipoTransporte) {
        this.lstTipoTransporte = lstTipoTransporte;
    }

    public String getCodigoGuia() {
        return codigoGuia;
    }

    public void setCodigoGuia(String codigoGuia) {
        this.codigoGuia = codigoGuia;
    }

    public Envio getEnvioSeleccionado() {
        return envioSeleccionado;
    }

    public void setEnvioSeleccionado(Envio envioSeleccionado) {
        this.envioSeleccionado = envioSeleccionado;
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

    public String iniciaCrearEnvio() {
        return "crearEnvio.xhtml?faces-redirect=true";
    }

    public void listaCentroAcopio() {
        this.lstCentroAcopio = this.centroAcopioFL.lstCentroAcopioCLiente(this.clienteSeleccionado.getIdCliente());
    }

    public void listaTransporte() {
        this.lstTipoTransporte = this.transporteFL.lstTransporteTipoTransporte(this.tipoTransporteSeleccionado.getIdTipoTransporte());
    }

    public String crearEnvio() {
        FacesContext fc = FacesContext.getCurrentInstance();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        formatoFecha.format(this.envioSeleccionado.getFechaEntrega());
        System.out.println("Cantidad: " + this.envioSeleccionado.getCantidadEnvio());
        if (!this.envioSeleccionado.getNumeroGuia().isEmpty() && this.envioSeleccionado.getNumeroGuia().length() > 0) {
            if (this.envioSeleccionado.getCantidadEnvio() != null) {
                if (this.envioSeleccionado.getValorEnvio() != null) {
                    if (this.envioSeleccionado.getFkIdTransporte().getFkidTipoTransporte().getIdTipoTransporte() == 1
                            && this.envioSeleccionado.getCantidadEnvio() > 10) {
                        this.envioSeleccionado.setPorcentajeDescuento(3);
                        this.envioSeleccionado.setValorDescuento((this.envioSeleccionado.getValorEnvio() * 3) / 100);
                        this.envioSeleccionado.setFechaIngreso(new Date());
                        this.envioFL.create(envioSeleccionado);
                        return "lstEnvio.xhtml?faces-redirect=true";
                    } else {
                        if (this.envioSeleccionado.getFkIdTransporte().getFkidTipoTransporte().getIdTipoTransporte() == 1
                                && this.envioSeleccionado.getCantidadEnvio() <= 10) {
                            this.envioSeleccionado.setPorcentajeDescuento(0);
                            this.envioSeleccionado.setValorDescuento(0.0);
                            this.envioSeleccionado.setFechaIngreso(new Date());
                            this.envioFL.create(envioSeleccionado);
                            return "lstEnvio.xhtml?faces-redirect=true";
                        }
                    }
                    if (this.envioSeleccionado.getFkIdTransporte().getFkidTipoTransporte().getIdTipoTransporte() == 2
                            && this.envioSeleccionado.getCantidadEnvio() > 10) {
                        this.envioSeleccionado.setPorcentajeDescuento(5);
                        this.envioSeleccionado.setValorDescuento((this.envioSeleccionado.getValorEnvio() * 5) / 100);
                        this.envioSeleccionado.setFechaIngreso(new Date());
                        this.envioFL.create(envioSeleccionado);
                        return "lstEnvio.xhtml?faces-redirect=true";
                    } else {
                        if (this.envioSeleccionado.getFkIdTransporte().getFkidTipoTransporte().getIdTipoTransporte() == 2
                                && this.envioSeleccionado.getCantidadEnvio() <= 10) {
                            this.envioSeleccionado.setPorcentajeDescuento(0);
                            this.envioSeleccionado.setValorDescuento(0.0);
                            this.envioSeleccionado.setFechaIngreso(new Date());
                            this.envioFL.create(envioSeleccionado);
                            return "lstEnvio.xhtml?faces-redirect=true";
                        }
                    }
                } else {
                    FacesMessage usuarioExiste = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ingrese el valor del envío", "");
                    fc.addMessage("frmEnvio", usuarioExiste);
                }
            } else {
                FacesMessage usuarioExiste = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ingrese la cantidad del envío", "");
                fc.addMessage("frmEnvio", usuarioExiste);
            }
        } else {
            FacesMessage usuarioExiste = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ingrese el codigo de guia del envío", "");
            fc.addMessage("frmEnvio", usuarioExiste);
        }
        return "";
    }
}
