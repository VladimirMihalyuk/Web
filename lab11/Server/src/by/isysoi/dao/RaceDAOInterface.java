package by.isysoi.dao;

import by.isysoi.entity.Race;
import by.isysoi.exception.DAOException;

import javax.ejb.Remote;
import java.util.Date;
import java.util.List;

@Remote
public interface RaceDAOInterface {

    /**
     * read races
     *
     * @return list of races
     * @throws DAOException if query execution failed
     */
    List<Race> readRaces() throws DAOException;

    /**
     * read race by id
     *
     * @param id id of race
     * @return race
     * @throws DAOException if query execution failed
     */
    Race readRaceById(int id) throws DAOException;

    /**
     * insert race
     *
     * @param race race object
     * @throws DAOException if query execution failed
     */
    void insertRace(Race race) throws DAOException;

    /**
     * delete race
     *
     * @param id id of race
     * @throws DAOException if query execution failed
     */
    void deleteRace(int id) throws DAOException;

    /**
     * delete races
     *
     * @throws DAOException if query execution failed
     */
    void deleteRaces() throws DAOException;

    /**
     * read races by date
     *
     * @param date date of race to select
     * @return list of races
     * @throws DAOException if query execution failed
     */
    List<Race> readRacesByDate(Date date) throws DAOException;

    /**
     * added horse to race
     *
     * @param horseId id of horse
     * @param raceId  id of race
     * @throws DAOException if query execution failed
     */
    void addHorseToRace(int horseId, int raceId) throws DAOException;

    /**
     * updated horse position
     *
     * @param horseId  id of horse
     * @param raceId   id of race
     * @param position position of horse
     * @throws DAOException if query execution failed
     */
    void setHoresPositionInRace(int horseId, int raceId, int position) throws DAOException;


}
