package facade;

import java.util.List;
import javax.ejb.Local;
import modelo.Transporte;

@Local
public interface TransporteFacadeLocal {

    void create(Transporte transporte);

    void edit(Transporte transporte);

    void remove(Transporte transporte);

    Transporte find(Object id);

    List<Transporte> findAll();

    List<Transporte> findRange(int[] range);

    int count();
    
    List<Transporte> lstTransporteIdentificacion(String codPlacaFlota);
    
    List<Transporte> lstTransporteTipoTransporte(int fkIdTipoTransporte);

}
