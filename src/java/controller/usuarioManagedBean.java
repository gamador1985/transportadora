
package controller;

import javax.inject.Named;
import javax.enterprise.context.ConversationScoped;
import java.io.Serializable;


@Named(value = "usuarioManagedBean")
@ConversationScoped
public class usuarioManagedBean implements Serializable {

    
    public usuarioManagedBean() {
    }
    
}
