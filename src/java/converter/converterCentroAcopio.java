package converter;

import facade.CentroAcopioFacadeLocal;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.CentroAcopio;

@FacesConverter(forClass = CentroAcopio.class, value = "converterCentroAcopio")
public class converterCentroAcopio implements Converter {

    private CentroAcopioFacadeLocal centroAcopioFL;

    public converterCentroAcopio() {
        centroAcopioFL = CDI.current().select(CentroAcopioFacadeLocal.class).get();
    }

    public CentroAcopioFacadeLocal getCentroAcopioFL() {
        return centroAcopioFL;
    }

    public void setCentroAcopioFL(CentroAcopioFacadeLocal centroAcopioFL) {
        this.centroAcopioFL = centroAcopioFL;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.length() > 0) {
            return centroAcopioFL.find(Integer.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof CentroAcopio) {
            CentroAcopio centroAcopio = (CentroAcopio) value;
            return centroAcopio.getIdCentroAcopio().toString();
        }
        return null;
    }

}
