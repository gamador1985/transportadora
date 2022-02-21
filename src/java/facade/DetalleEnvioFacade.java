/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.DetalleEnvio;

/**
 *
 * @author edwin
 */
@Stateless
public class DetalleEnvioFacade extends AbstractFacade<DetalleEnvio> implements DetalleEnvioFacadeLocal {

    @PersistenceContext(unitName = "transportadoraPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleEnvioFacade() {
        super(DetalleEnvio.class);
    }
    
}
