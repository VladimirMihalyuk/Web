package by.isysoi.model.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * class that represent race entity
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
@NamedQueries({
        @NamedQuery(
                name = "deleteRaces",
                query = "delete from race"
        ),
        @NamedQuery(
                name = "deleteRace",
                query = "delete from race where id = :id"
        ),
        @NamedQuery(
                name = "readRaces",
                query = "select * from race"
        ),
        @NamedQuery(
                name = "readRace",
                query = "select * from race where id = :id"
        ),
        @NamedQuery(
                name = "readHorsesInRace",
                query = "select h.id, h.nikname from race r join race_info on race_id = r.id join horse h on horse_id = h.id where r.id = :id"
        ),
        @NamedQuery(
                name = "readRaceByDate",
                query = "select * from race where race_date = :raceDate"
        ),
        @NamedQuery(
                name = "addHorseToRace",
                query = "insert into race_info (horse_id, race_id) values(:horseId, :raceId)"
        ),
        @NamedQuery(
                name = "updateHorsePosition",
                query = "update race_info set position = :position where race_id = :raceId and horse_id = :horseId"
        )
})
@Entity(name = "Race")
@Table(name = "race")
public class Race {

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
    private Date raceDate;

    /**
     * constructor to create race
     *
     * @param id       id of race
     * @param distance distance of race
     * @param raceDate date of race
     */
    public Race(int id, double distance, Date raceDate) {
        setId(id);
        setDistance(distance);
        setRaceDate(raceDate);
    }

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
