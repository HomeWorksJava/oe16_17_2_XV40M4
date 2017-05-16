package DBEntities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RendelesRaktarra.class)
public abstract class RendelesRaktarra_ {

	public static volatile SingularAttribute<RendelesRaktarra, Keszulekek> keszulekId;
	public static volatile SingularAttribute<RendelesRaktarra, Date> rendelesDatuma;
	public static volatile SingularAttribute<RendelesRaktarra, Integer> mennyiseg;
	public static volatile SingularAttribute<RendelesRaktarra, Integer> id;
	public static volatile SingularAttribute<RendelesRaktarra, Date> mikorra;
	public static volatile SingularAttribute<RendelesRaktarra, Raktar> raktarId;
	public static volatile SingularAttribute<RendelesRaktarra, Integer> foglaltmennyiseg;

}

