/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesionManagedBean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author edwin
 */
@Named(value = "sessionManagedBean")
@SessionScoped
public class sessionManagedBean implements Serializable {

    /**
     * Creates a new instance of NewJSFManagedBean
     */
    public sessionManagedBean() {
    }

    public String inicioSession() {
        return "administrador.xhtml?faces-redirect=true";
    }

}
