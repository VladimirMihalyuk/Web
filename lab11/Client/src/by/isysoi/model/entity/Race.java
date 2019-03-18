package by.isysoi.model.entity;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * class that represent race entity
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
@Entity(name = "Race")
@Table(name = Race.tableName)
public class Race {

    public static final String tableName = "race";
    public static final String idColumnName = "id";
    private static final String dateColumnName = "race_date";
    @ManyToMany(cascade = {CascadeType.ALL},
            fetch = FetchType.EAGER)
    @JoinTable(
            name = RaceInfo.tableName,
            joinColumns = @JoinColumn(name = RaceInfo.raceColumnName),
            inverseJoinColumns = {@JoinColumn(name = RaceInfo.horseColumnName)}
    )
    public List<Horse> horses;
    @OneToMany(mappedBy = "race",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    public List<Bet> bets;
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
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return String.format("Race:" +
                        "\n\tid - %d" +
                        "\n\tdistance - %.2f" +
                        "\n\tdate - %s",
                id, distance, formatter.format(raceDate));
    }

}
