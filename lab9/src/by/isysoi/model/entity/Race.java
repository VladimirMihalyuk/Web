package by.isysoi.model.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * class that represent race entity
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
//@NamedQueries({
//        @NamedQuery(
//                name = "deleteRaces",
//                query = "delete from Race"
//        ),
//        @NamedQuery(
//                name = "deleteRace",
//                query = "delete from Race where id = :id"
//        ),
//        @NamedQuery(
//                name = "readRaces",
//                query = "select r from Race r"
//        ),
//        @NamedQuery(
//                name = "readRace",
//                query = "select r from Race r where r.id = :id"
//        ),
//        @NamedQuery(
//                name = "readHorsesInRace",
//                query = "select h.id, h.nikname from Race r join RaceInfo ri on ri.raceId = r.id join Horse h on ri.horseId = h.id where r.id = :id"
//        ),
//        @NamedQuery(
//                name = "readRaceByDate",
//                query = "select r from Race r where r.raceDate = :raceDate"
//        ),
//})
@Entity(name = "Race")
@Table(name = Race.tableName)
public class Race {

    public static final String tableName = "race";
    private static final String dateColumnName = "race_date";

    /**
     * id of race
     */
    @Id
    @GeneratedValue
    private int id;

    /**
     * distance of race
     */
    private double distance;

    /**
     * date of race
     */
    @Column(name = Race.dateColumnName)
    private Date raceDate;

    public Date getRaceDate() {
        return raceDate;
    }

    public void setRaceDate(Date raceDate) {
        this.raceDate = raceDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return String.format("Race:\n\tid - %d\n\tdistance - %.2f\n\tdate - %s", id, distance, raceDate.toString());
    }

}
