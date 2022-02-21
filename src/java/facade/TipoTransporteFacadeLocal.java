/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.List;
import javax.ejb.Local;
import modelo.TipoTransporte;

/**
 *
 * @author edwin
 */
@Local
public interface TipoTransporteFacadeLocal {

    void create(TipoTransporte tipoTransporte);

    void edit(TipoTransporte tipoTransporte);

    void remove(TipoTransporte tipoTransporte);

    TipoTransporte find(Object id);

    List<TipoTransporte> findAll();

    List<TipoTransporte> findRange(int[] range);

    int count();
    
}
