package by.isysoi.Model.Entity;

import java.util.Date;

/**
 * class that represent race entity
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class Race {

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

    /**
     * constructor to create race
     * @param id id of race
     * @param distance distance of race
     * @param raceDate date of race
     */
    public Race(int id, double distance, Date raceDate) {
        setId(id);
        setDistance(distance);
        setRaceDate(raceDate);
    }


}
