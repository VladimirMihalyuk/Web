package by.isysoi.dao.impl;

import by.isysoi.dao.HorseDAOInterface;
import by.isysoi.dao.HorseRacesEndPointConstants;
import by.isysoi.entity.Horse;
import by.isysoi.exception.DAOException;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * horse dao wrapper class
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class HorseDAORestfulWrapper implements HorseDAOInterface {

    //protected Logger logger = LogManager.getLogger("dao_layer");

    private WebTarget target;

    public HorseDAORestfulWrapper() {
        target = ClientBuilder.newClient().target(HorseRacesEndPointConstants.horseEndPoint);
    }

    /**
     * read horses
     *
     * @return list of horses
     */
    public List<Horse> readHorses() throws DAOException {
        List horses = null;
        try {
            horses = target.path("all")
                    .request(MediaType.APPLICATION_XML)
                    .get(new GenericType<List<Horse>>() {
                    });
        } catch (Exception e) {
            throw new DAOException("Failed request to find all horses", e);
        }
        return horses;
    }

    /**
     * read horse by id
     *
     * @param id id of horse
     * @return horse
     */
    public Horse readHorseById(int id) throws DAOException {
        Horse horse = null;
        try {
            horse = target.path(String.valueOf(id))
                    .request(MediaType.APPLICATION_XML)
                    .get(Horse.class);
        } catch (Exception e) {
            throw new DAOException("Failed request to find horse with id - " + id, e);
        }
        return horse;
    }

    /**
     * insert horse
     *
     * @param horse horse object
     */
    public void insertHorse(Horse horse) throws DAOException {
        try {
            target.path("new")
                    .request()
                    .post(Entity.entity(horse, MediaType.APPLICATION_XML));
        } catch (Exception e) {
            throw new DAOException("Failed request to insert horse", e);
        }
    }

    /**
     * read horses in race
     *
     * @param raceId id of race
     */
    public List<Horse> readHorcesInRace(int raceId) throws DAOException {
        List horses = null;
        try {
            horses = target.path("byRace")
                    .path(String.valueOf(raceId))
                    .request(MediaType.APPLICATION_XML)
                    .get(new GenericType<List<Horse>>() {
                    });
        } catch (Exception e) {
            throw new DAOException("Failed request to find horses in race with id - " + raceId, e);
        }
        return horses;
    }

    /**
     * delete horse
     *
     * @param id id of horse
     * @throws DAOException if query execution failed
     */
    public void deleteHorse(int id, int raceId) throws DAOException {
        try {
            target.path(String.valueOf(id))
                    .queryParam("raceId", raceId)
                    .request()
                    .delete();
        } catch (Exception e) {
            throw new DAOException("Failed request to remove horse", e);
        }
    }


}
