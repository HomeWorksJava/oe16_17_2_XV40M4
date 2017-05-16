package DBEntities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Raktar.class)
public abstract class Raktar_ {

	public static volatile SingularAttribute<Raktar, String> leiras;
	public static volatile ListAttribute<Raktar, RendelesRaktarra> rendelesRaktarraList;
	public static volatile SingularAttribute<Raktar, String> hely;
	public static volatile SingularAttribute<Raktar, Integer> id;
	public static volatile SingularAttribute<Raktar, Integer> terulet;
	public static volatile ListAttribute<Raktar, RaktarKeszulekek> raktarKeszulekekList;

}

