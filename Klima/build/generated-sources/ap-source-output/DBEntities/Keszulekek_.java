package DBEntities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Keszulekek.class)
public abstract class Keszulekek_ {

	public static volatile SingularAttribute<Keszulekek, Double> futoteljesitmeny;
	public static volatile SingularAttribute<Keszulekek, String> gyarto;
	public static volatile ListAttribute<Keszulekek, Megrendelesek> megrendelesekList;
	public static volatile SingularAttribute<Keszulekek, String> leiras;
	public static volatile ListAttribute<Keszulekek, RendelesRaktarra> rendelesRaktarraList;
	public static volatile SingularAttribute<Keszulekek, Double> hutoteljesitmeny;
	public static volatile SingularAttribute<Keszulekek, Integer> id;
	public static volatile SingularAttribute<Keszulekek, String> kivitel;
	public static volatile SingularAttribute<Keszulekek, String> energiaosztaly;
	public static volatile SingularAttribute<Keszulekek, String> garancia;
	public static volatile ListAttribute<Keszulekek, RaktarKeszulekek> raktarKeszulekekList;
	public static volatile SingularAttribute<Keszulekek, String> elnevezes;

}

