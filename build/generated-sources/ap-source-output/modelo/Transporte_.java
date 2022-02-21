package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Envio;
import modelo.TipoTransporte;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-02-21T07:42:48")
@StaticMetamodel(Transporte.class)
public class Transporte_ { 

    public static volatile SingularAttribute<Transporte, String> identificacionTransporte;
    public static volatile SingularAttribute<Transporte, Integer> estado;
    public static volatile SingularAttribute<Transporte, Integer> idTransporte;
    public static volatile ListAttribute<Transporte, Envio> envioList;
    public static volatile SingularAttribute<Transporte, TipoTransporte> fkidTipoTransporte;

}