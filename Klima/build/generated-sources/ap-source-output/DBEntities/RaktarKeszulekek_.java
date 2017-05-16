package DBEntities;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RaktarKeszulekek.class)
public abstract class RaktarKeszulekek_ {

	public static volatile SingularAttribute<RaktarKeszulekek, Keszulekek> keszulekId;
	public static volatile SingularAttribute<RaktarKeszulekek, BigInteger> arres;
	public static volatile SingularAttribute<RaktarKeszulekek, Integer> mennyiseg;
	public static volatile SingularAttribute<RaktarKeszulekek, Integer> szabadmennyiseg;
	public static volatile SingularAttribute<RaktarKeszulekek, Integer> id;
	public static volatile SingularAttribute<RaktarKeszulekek, Raktar> raktarId;
	public static volatile SingularAttribute<RaktarKeszulekek, Integer> foglaltmennyiseg;
	public static volatile SingularAttribute<RaktarKeszulekek, Integer> minimalismennyiseg;

}

