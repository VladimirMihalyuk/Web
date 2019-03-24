package by.isysoi.model.dao;

import by.isysoi.model.entity.Horse;
import by.isysoi.model.exception.DAOException;

import javax.ejb.Local;
import javax.ejb.Remote;
import java.util.List;

@Remote
/*
 * Data Access Interface provide access to Answer class
 */
public interface HorseDAOInterface {

    List<Horse> readHorses() throws DAOException;

    /**
     * read horse by id
     *
     * @param id id of horse
     * @return horse
     * @throws DAOException if query execution failed
     */
    Horse readHorseById(int id) throws DAOException;

    /**
     * insert horse
     *
     * @param horse horse object
     * @throws DAOException if query execution failed
     */
    void insertHorse(Horse horse) throws DAOException;

    /**
     * delete horse
     *
     * @param id id of horse
     * @throws DAOException if query execution failed
     */
    void deleteHorse(int id) throws DAOException;

    /**
     * delete Horses
     *
     * @throws DAOException if query execution failed
     */
    void deleteHorses() throws DAOException;

    /**
     * read horses in race
     *
     * @param raceId id of race
     * @throws DAOException if query execution failed
     */
    List<Horse> readHorcesInRace(int raceId) throws DAOException;

}
