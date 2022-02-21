package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Envio;
import modelo.Producto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-02-21T07:42:48")
@StaticMetamodel(DetalleEnvio.class)
public class DetalleEnvio_ { 

    public static volatile SingularAttribute<DetalleEnvio, Double> valorTotal;
    public static volatile SingularAttribute<DetalleEnvio, Integer> idDetalleEnvio;
    public static volatile SingularAttribute<DetalleEnvio, Double> valorUnidad;
    public static volatile SingularAttribute<DetalleEnvio, Double> cantidad;
    public static volatile SingularAttribute<DetalleEnvio, Envio> fkIdEnvio;
    public static volatile SingularAttribute<DetalleEnvio, Producto> fkidProducto;

}