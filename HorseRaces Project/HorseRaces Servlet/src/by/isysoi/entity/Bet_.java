package by.isysoi.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;

@StaticMetamodel(Bet.class)
public class Bet_ {

    public static volatile SingularAttribute<Bet, Integer> id;
    public static volatile SingularAttribute<Bet, BigDecimal> amount;
    public static volatile SingularAttribute<Bet, Race> race;
    public static volatile SingularAttribute<Bet, Horse> horse;
    public static volatile SingularAttribute<Bet, Client> client;

}