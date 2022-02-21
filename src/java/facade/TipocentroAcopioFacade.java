/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.TipocentroAcopio;

/**
 *
 * @author edwin
 */
@Stateless
public class TipocentroAcopioFacade extends AbstractFacade<TipocentroAcopio> implements TipocentroAcopioFacadeLocal {

    @PersistenceContext(unitName = "transportadoraPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipocentroAcopioFacade() {
        super(TipocentroAcopio.class);
    }
    
}
