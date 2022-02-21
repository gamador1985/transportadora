/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.CentroAcopio;

/**
 *
 * @author edwin
 */
@Stateless
public class CentroAcopioFacade extends AbstractFacade<CentroAcopio> implements CentroAcopioFacadeLocal {

    @PersistenceContext(unitName = "transportadoraPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CentroAcopioFacade() {
        super(CentroAcopio.class);
    }

    @Override
    public void crearCentroAcopio(String nombreCentroAcopio, String direccion, String locacion, int fkCliente, int tipoCentroAcopio) {
        CentroAcopio centroAcopio = null;
        try {
            Query q = getEntityManager().createNativeQuery(" INSERT INTO centroAcopio VALUES (null,?, ?, ?, ?, ?)");
            q.setParameter(1, nombreCentroAcopio);
            q.setParameter(2, direccion);
            q.setParameter(3, locacion);
            q.setParameter(4, fkCliente);
            q.setParameter(5, tipoCentroAcopio);
            q.executeUpdate();
        } catch (Exception e) {
        }
    }

    @Override
    public List<CentroAcopio> lstCentroAcopioNombre(String nombreCentroAcopio) {
        List<CentroAcopio> lstCentroAcopioNombre = null;
        try {
            Query q = getEntityManager().createNativeQuery(" SELECT *"
                    + " FROM centroAcopio ca "
                    + " WHERE ca.nombreCentroAcopio LIKE '%" + nombreCentroAcopio + "%'", CentroAcopio.class);
            q.setParameter(1, nombreCentroAcopio);
            lstCentroAcopioNombre = q.getResultList();
        } catch (Exception e) {
        }
        return lstCentroAcopioNombre;
    }

    @Override
    public List<CentroAcopio> lstCentroAcopioCLiente(int fkIdCliente) {
        List<CentroAcopio> lstCentroAcopioCliente = null;
        try {
            Query q = getEntityManager().createNativeQuery(" SELECT *"
                    + " FROM centroacopio ca"
                    + " WHERE ca.fkidCliente = ?;", CentroAcopio.class);
            q.setParameter(1, fkIdCliente);
            lstCentroAcopioCliente = q.getResultList();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return lstCentroAcopioCliente;
    }

}
