package DBEntities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Megrendelesek.class)
public abstract class Megrendelesek_ {

	public static volatile SingularAttribute<Megrendelesek, Keszulekek> keszulekId;
	public static volatile SingularAttribute<Megrendelesek, Vevok> vevoId;
	public static volatile SingularAttribute<Megrendelesek, String> megrendelescim;
	public static volatile SingularAttribute<Megrendelesek, Date> rendelesdatum;
	public static volatile SingularAttribute<Megrendelesek, Integer> id;
	public static volatile SingularAttribute<Megrendelesek, Date> utolsokarb;

}

