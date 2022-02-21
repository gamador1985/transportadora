package converter;

import facade.TipocentroAcopioFacadeLocal;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.TipocentroAcopio;

@FacesConverter(forClass = TipocentroAcopio.class, value = "converterTipoCentroAcopio")

public class converterTipoCentroAcopio implements Converter {

    private TipocentroAcopioFacadeLocal tipoCentroAcopioFL;

    public converterTipoCentroAcopio() {
        tipoCentroAcopioFL = CDI.current().select(TipocentroAcopioFacadeLocal.class).get();
    }

    public TipocentroAcopioFacadeLocal getTipoCentroAcopioFL() {
        return tipoCentroAcopioFL;
    }

    public void setTipoCentroAcopioFL(TipocentroAcopioFacadeLocal tipoCentroAcopioFL) {
        this.tipoCentroAcopioFL = tipoCentroAcopioFL;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.length()>0) {
            return tipoCentroAcopioFL.find(Integer.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof TipocentroAcopio) {
            TipocentroAcopio tipoCentroAcopio = (TipocentroAcopio) value;
            tipoCentroAcopio.getIdTipoCentroAcopio().toString();
        }
        return null;
    }

}
