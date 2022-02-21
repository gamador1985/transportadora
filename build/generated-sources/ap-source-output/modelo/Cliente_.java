package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.CentroAcopio;
import modelo.Producto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-02-21T07:42:48")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> nombreContacto;
    public static volatile SingularAttribute<Cliente, Integer> idCliente;
    public static volatile SingularAttribute<Cliente, String> nombreCliente;
    public static volatile ListAttribute<Cliente, Producto> productoList;
    public static volatile SingularAttribute<Cliente, String> direccion;
    public static volatile SingularAttribute<Cliente, String> telefonoContacto;
    public static volatile ListAttribute<Cliente, CentroAcopio> centroAcopioList;

}