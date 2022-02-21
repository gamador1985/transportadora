package converter;

import facade.TransporteFacadeLocal;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.Transporte;

@FacesConverter(forClass = Transporte.class, value = "converterTransporte")
public class converterTransporte implements Converter {

    private TransporteFacadeLocal transporteFL;

    public converterTransporte() {
        this.transporteFL = CDI.current().select(TransporteFacadeLocal.class).get();
    }

    public TransporteFacadeLocal getTransporteFL() {
        return transporteFL;
    }

    public void setTransporteFL(TransporteFacadeLocal transporteFL) {
        this.transporteFL = transporteFL;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.length()>0) {
            return this.transporteFL.find(Integer.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof Transporte) {
            Transporte transporte = (Transporte) value;
            return transporte.getIdTransporte().toString();
        }
        return null;
    }

}
