/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Envio;

/**
 *
 * @author edwin
 */
@Stateless
public class EnvioFacade extends AbstractFacade<Envio> implements EnvioFacadeLocal {

    @PersistenceContext(unitName = "transportadoraPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnvioFacade() {
        super(Envio.class);
    }
    
}
