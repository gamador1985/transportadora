/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.TipoTransporte;

/**
 *
 * @author edwin
 */
@Stateless
public class TipoTransporteFacade extends AbstractFacade<TipoTransporte> implements TipoTransporteFacadeLocal {

    @PersistenceContext(unitName = "transportadoraPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoTransporteFacade() {
        super(TipoTransporte.class);
    }
    
}
