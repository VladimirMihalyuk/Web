package by.isysoi.model.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(RaceInfo.class)
public class RaceInfo_ {

    public static volatile SingularAttribute<RaceInfo, Integer> raceId;
    public static volatile SingularAttribute<RaceInfo, Integer> horseId;
    public static volatile SingularAttribute<RaceInfo, Integer> position;

}