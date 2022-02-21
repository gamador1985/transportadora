/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Transporte;

/**
 *
 * @author edwin
 */
@Stateless
public class TransporteFacade extends AbstractFacade<Transporte> implements TransporteFacadeLocal {

    @PersistenceContext(unitName = "transportadoraPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransporteFacade() {
        super(Transporte.class);
    }

    @Override
    public List<Transporte> lstTransporteIdentificacion(String codPlacaFlota) {
        List<Transporte> lstListTransporte = new ArrayList<>();
        try {
            Query q = getEntityManager().createNativeQuery(" SELECT *"
                    + " FROM transporte ts"
                    + " WHERE ts.identificacionTransporte LIKE '%" + codPlacaFlota + "%'", Transporte.class);
            lstListTransporte = q.getResultList();
        } catch (Exception e) {
        }
        return lstListTransporte;
    }

    @Override
    public List<Transporte> lstTransporteTipoTransporte(int fkIdTipoTransporte) {
        List<Transporte> lstTransporteTipoTransporte = null;
        try {
            Query q = getEntityManager().createNativeQuery(" SELECT *"
                    + " FROM transporte t"
                    + " WHERE t.fkIdTipoTransporte = ?;", Transporte.class);
            q.setParameter(1, fkIdTipoTransporte);
            lstTransporteTipoTransporte = q.getResultList();
        } catch (Exception e) {
        }
        return lstTransporteTipoTransporte;
    }

}
