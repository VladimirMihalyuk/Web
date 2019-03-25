package by.isysoi.dao;

import by.isysoi.entity.*;

import javax.ejb.Remote;
import java.util.Date;
import java.util.List;

@Remote
public interface RaceDAOInterface {

    /**
     * read races
     *
     * @return list of races
     */
    List<Race> readRaces();

    /**
     * read race by id
     *
     * @param id id of race
     * @return race
     */
    Race readRaceById(int id);

    /**
     * insert race
     *
     * @param race race object
     */
    void insertRace(Race race);

    /**
     * read races by date
     *
     * @param date date of race to select
     * @return list of races
     */
    List<Race> readRacesByDate(Date date);

    /**
     * added horse to race
     *
     * @param horseId id of horse
     * @param raceId  id of race
     */
    void addHorseToRace(int horseId, int raceId);

    /**
     * updated horse position
     *
     * @param horseId  id of horse
     * @param raceId   id of race
     * @param position position of horse
     */
    void setHoresPositionInRace(int horseId, int raceId, int position);


}
