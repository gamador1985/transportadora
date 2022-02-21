/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.List;
import javax.ejb.Local;
import modelo.CentroAcopio;

/**
 *
 * @author edwin
 */
@Local
public interface CentroAcopioFacadeLocal {

    void create(CentroAcopio centroAcopio);

    void edit(CentroAcopio centroAcopio);

    void remove(CentroAcopio centroAcopio);

    CentroAcopio find(Object id);

    List<CentroAcopio> findAll();

    List<CentroAcopio> findRange(int[] range);

    int count();
    
    void crearCentroAcopio(String nombreCentroAcopio, String direccion, String locacion, int fkCliente, int tipoCentroAcopio);
    
    List<CentroAcopio> lstCentroAcopioNombre(String nombreCentroAcopio);
    
    List<CentroAcopio> lstCentroAcopioCLiente(int fkIdCliente);
    
}
