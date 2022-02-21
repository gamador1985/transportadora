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
import modelo.Cliente;

/**
 *
 * @author edwin
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> implements ClienteFacadeLocal {

    @PersistenceContext(unitName = "transportadoraPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }

    @Override
    public List<Cliente> lstClienteNombre(String nombreCliente) {
        List<Cliente> lstCliente = null;
        try {
            Query q = getEntityManager().createNativeQuery(" SELECT *"
                    + " FROM cliente cl"
                    + " WHERE cl.nombreCliente LIKE '%" + nombreCliente + "%'", Cliente.class);
            lstCliente = q.getResultList();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lstCliente;
    }

}
