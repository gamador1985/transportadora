package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.CentroAcopio;
import modelo.Transporte;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-02-21T07:42:48")
@StaticMetamodel(Envio.class)
public class Envio_ { 

    public static volatile SingularAttribute<Envio, Date> fechaIngreso;
    public static volatile SingularAttribute<Envio, Transporte> fkIdTransporte;
    public static volatile SingularAttribute<Envio, String> numeroGuia;
    public static volatile SingularAttribute<Envio, Double> valorDescuento;
    public static volatile SingularAttribute<Envio, Integer> porcentajeDescuento;
    public static volatile SingularAttribute<Envio, Date> fechaEntrega;
    public static volatile SingularAttribute<Envio, CentroAcopio> fkIdCentroAcopio;
    public static volatile SingularAttribute<Envio, Integer> idEnvio;
    public static volatile SingularAttribute<Envio, Double> valorEnvio;
    public static volatile SingularAttribute<Envio, Integer> cantidadEnvio;

}