package by.isysoi.model.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * class that represent race entity
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
@NamedQueries({
        @NamedQuery(
                name = "deleteRaces",
                query = "delete from Race"
        ),
        @NamedQuery(
                name = "deleteRace",
                query = "delete from Race where id = :id"
        ),
        @NamedQuery(
                name = "readRaces",
                query = "select r from Race r"
        ),
        @NamedQuery(
                name = "readRace",
                query = "select r from Race r where r.id = :id"
        ),
        @NamedQuery(
                name = "readRaceByDate",
                query = "select r from Race r where r.raceDate = :raceDate"
        ),
        @NamedQuery(
                name = "updateHorsePosition",
                query = "update RaceInfo set position = :position where raceId = :raceId and horseId = :horseId"
        ),
})
@Entity(name = "Race")
@Table(name = Race.tableName)
public class Race {

    public static final String tableName = "race";
    private static final String dateColumnName = "race_date";
    public static final String idColumnName = "id";

    /**
     * id of race
     */
    @Id
    @GeneratedValue
    private int id;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = RaceInfo.tableName,
            joinColumns = @JoinColumn(name = RaceInfo.raceColumnName),
            inverseJoinColumns = {@JoinColumn(name = RaceInfo.horseColumnName)}
    )
    public List<Horse> horses;


    @OneToMany(mappedBy = "race", cascade = CascadeType.ALL)
    public List<Bet> bets;

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
