/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.List;
import javax.ejb.Local;
import modelo.TipocentroAcopio;

/**
 *
 * @author edwin
 */
@Local
public interface TipocentroAcopioFacadeLocal {

    void create(TipocentroAcopio tipocentroAcopio);

    void edit(TipocentroAcopio tipocentroAcopio);

    void remove(TipocentroAcopio tipocentroAcopio);

    TipocentroAcopio find(Object id);

    List<TipocentroAcopio> findAll();

    List<TipocentroAcopio> findRange(int[] range);

    int count();
    
}
