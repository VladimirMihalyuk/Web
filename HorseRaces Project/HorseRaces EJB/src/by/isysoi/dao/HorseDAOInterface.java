package by.isysoi.dao;

import by.isysoi.entity.Horse;
import by.isysoi.exception.DAOException;

import javax.ejb.Remote;
import java.util.List;

/*
 * Data Access Interface provide access to Answer class
 */
@Remote
public interface HorseDAOInterface {

    List<Horse> readHorses() throws DAOException;

    /**
     * read horse by id
     *
     * @param id id of horse
     * @return horse
     */
    Horse readHorseById(int id) throws DAOException;

    /**
     * insert horse
     *
     * @param horse horse object
     */
    void insertHorse(Horse horse) throws DAOException;

    /**
     * read horses in race
     *
     * @param raceId id of race
     */
    List<Horse> readHorcesInRace(int raceId) throws DAOException;

    /**
     * delete horse
     *
     * @param id id of horse
     * @throws DAOException if query execution failed
     */
    public void deleteHorse(int id) throws DAOException;
}
