/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.List;
import javax.ejb.Local;
import modelo.Envio;

/**
 *
 * @author edwin
 */
@Local
public interface EnvioFacadeLocal {

    void create(Envio envio);

    void edit(Envio envio);

    void remove(Envio envio);

    Envio find(Object id);

    List<Envio> findAll();

    List<Envio> findRange(int[] range);

    int count();
    
}
