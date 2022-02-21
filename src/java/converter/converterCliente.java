package converter;

import facade.ClienteFacadeLocal;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.Cliente;

@FacesConverter(forClass = Cliente.class, value = "converterCliente")
public class converterCliente implements Converter {

    private ClienteFacadeLocal clienteFL;

    public converterCliente() {
        clienteFL = CDI.current().select(ClienteFacadeLocal.class).get();
    }

    public ClienteFacadeLocal getClienteFL() {
        return clienteFL;
    }

    public void setClienteFL(ClienteFacadeLocal clienteFL) {
        this.clienteFL = clienteFL;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.length() > 0) {
            return clienteFL.find(Integer.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof Cliente) {
            Cliente cliente = (Cliente) value;
            return cliente.getIdCliente().toString();
        }
        return null;
    }

}
