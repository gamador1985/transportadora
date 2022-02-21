/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.List;
import javax.ejb.Local;
import modelo.DetalleEnvio;

/**
 *
 * @author edwin
 */
@Local
public interface DetalleEnvioFacadeLocal {

    void create(DetalleEnvio detalleEnvio);

    void edit(DetalleEnvio detalleEnvio);

    void remove(DetalleEnvio detalleEnvio);

    DetalleEnvio find(Object id);

    List<DetalleEnvio> findAll();

    List<DetalleEnvio> findRange(int[] range);

    int count();
    
}
