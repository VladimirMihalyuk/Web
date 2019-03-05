package by.isysoi.model.entity;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Client.class)
public class Client_ {

    public static volatile SingularAttribute<Client, Integer> id;
    public static volatile SingularAttribute<Client, String> FIO;
    public static volatile ListAttribute<Client, Bet> bets;

}
