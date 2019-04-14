package by.isysoi.model.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * class that represent race entity
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class Race implements Serializable {

    private static final long serialVersionUID = 1;

    public List<Horse> horses;

    public List<Bet> bets;

    /**
     * id of race
     */
    private int id;
    /**
     * distance of race
     */
    private double distance;

    /**
     * date of race
     */
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
