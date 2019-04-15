package by.isysoi.model.entity;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Race.class)
public class Race_ {

    public static volatile SingularAttribute<Race, Integer> id;
    public static volatile SingularAttribute<Race, Double> distance;
    public static volatile SingularAttribute<Race, Date> raceDate;
    public static volatile ListAttribute<Race, Bet> bets;
    public static volatile ListAttribute<Race, Horse> horses;

}