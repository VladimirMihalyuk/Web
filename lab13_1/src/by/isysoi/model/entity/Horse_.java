package by.isysoi.model.entity;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Horse.class)
public class Horse_ {

    public static volatile SingularAttribute<Horse, Integer> id;
    public static volatile SingularAttribute<Horse, String> nikname;
    public static volatile ListAttribute<Horse, Bet> bets;
    public static volatile ListAttribute<Horse, Race> races;

}