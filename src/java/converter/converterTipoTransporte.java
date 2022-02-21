package converter;

import facade.TipoTransporteFacadeLocal;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.TipoTransporte;

@FacesConverter(forClass = TipoTransporte.class, value = "converterTipoTransporte")

public class converterTipoTransporte implements Converter {

    private TipoTransporteFacadeLocal tipoTransporteFL;

    public converterTipoTransporte() {
        tipoTransporteFL = CDI.current().select(TipoTransporteFacadeLocal.class).get();
    }

    public TipoTransporteFacadeLocal getTipoTransporteFL() {
        return tipoTransporteFL;
    }

    public void setTipoTransporteFL(TipoTransporteFacadeLocal tipoTransporteFL) {
        this.tipoTransporteFL = tipoTransporteFL;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.length() > 0) {
            return tipoTransporteFL.find(Integer.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof TipoTransporte) {
            TipoTransporte tipoTransporte = (TipoTransporte) value;
            return tipoTransporte.getIdTipoTransporte().toString();
        }
        return null;
    }

}
