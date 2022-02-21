package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Cliente;
import modelo.DetalleEnvio;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-02-21T07:42:48")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, Date> fechaCreado;
    public static volatile SingularAttribute<Producto, Integer> estado;
    public static volatile SingularAttribute<Producto, Cliente> fkCliente;
    public static volatile SingularAttribute<Producto, Integer> idProducto;
    public static volatile ListAttribute<Producto, DetalleEnvio> detalleEnvioList;
    public static volatile SingularAttribute<Producto, String> nombreProducto;

}