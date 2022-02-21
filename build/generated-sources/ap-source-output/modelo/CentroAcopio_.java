package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Cliente;
import modelo.Envio;
import modelo.TipocentroAcopio;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-02-21T07:42:48")
@StaticMetamodel(CentroAcopio.class)
public class CentroAcopio_ { 

    public static volatile SingularAttribute<CentroAcopio, String> locacion;
    public static volatile SingularAttribute<CentroAcopio, Integer> idCentroAcopio;
    public static volatile SingularAttribute<CentroAcopio, Cliente> fkidCliente;
    public static volatile SingularAttribute<CentroAcopio, String> direccion;
    public static volatile SingularAttribute<CentroAcopio, String> nombreCentroAcopio;
    public static volatile ListAttribute<CentroAcopio, Envio> envioList;
    public static volatile SingularAttribute<CentroAcopio, TipocentroAcopio> fkIdTipoCentroAcopio;

}