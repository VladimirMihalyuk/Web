package by.isysoi.model.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.List;

@StaticMetamodel(Client.class)
public class Client_ {

    public static volatile SingularAttribute<Client, Integer> id;
    public static volatile SingularAttribute<Client, String> FIO;
    public static volatile SingularAttribute<Client, List<Bet>> bets;

}
