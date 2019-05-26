package by.isysoi.dao.impl;

import by.isysoi.dao.HorseRacesEndPointConstants;
import by.isysoi.dao.RaceDAOInterface;
import by.isysoi.entity.Race;
import by.isysoi.exception.DAOException;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * race dao wrapper class
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class RaceDAORestfulWrapper implements RaceDAOInterface {

    //protected Logger logger = LogManager.getLogger("dao_layer");

    private WebTarget target;

    public RaceDAORestfulWrapper() {
        target = ClientBuilder.newClient().target(HorseRacesEndPointConstants.raceEndPoint);
    }

    /**
     * read races
     *
     * @return list of races
     */
    public List<Race> readRaces() throws DAOException {
        List races = null;
        try {
            races = target.path("all")
                    .request(MediaType.APPLICATION_XML)
                    .get(new GenericType<List<Race>>() {
                    });
        } catch (Exception e) {
            throw new DAOException("Failed request to find all races", e);
        }
        return races;
    }

    /**
     * read race by id
     *
     * @param id id of race
     * @return race
     */
    public Race readRaceById(int id) throws DAOException {
        Race race = null;
        try {
            race = target.path(String.valueOf(id))
                    .request(MediaType.APPLICATION_XML)
                    .get(Race.class);
        } catch (Exception e) {
            throw new DAOException("Failed request to find race with id - " + id, e);
        }
        return race;
    }

    /**
     * insert race
     *
     * @param race race object
     */
    public void insertRace(Race race) throws DAOException {
        try {
            target.path("new")
                    .request()
                    .post(Entity.entity(race, MediaType.APPLICATION_XML));
        } catch (Exception e) {
            throw new DAOException("Failed request to insert race", e);
        }
    }

    /**
     * read races by date
     *
     * @param date date of race to select
     * @return list of races
     */
    public List<Race> readRacesByDate(Date date) throws DAOException {
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String dateString = format.format(date);

        List races = null;
        try {
            races = target.path("byDate")
                    .path(dateString)
                    .request(MediaType.APPLICATION_XML)
                    .get(new GenericType<List<Race>>() {
                    });
        } catch (Exception e) {
            throw new DAOException("Failed request to find all races", e);
        }

        return races;
    }

    /**
     * added horse to race
     *
     * @param horseId id of horse
     * @param raceId  id of race
     */
    public void addHorseToRace(int horseId, int raceId) throws DAOException {
        try {
            target.path("newHorse")
                    .queryParam("horseId", horseId)
                    .queryParam("raceId", raceId)
                    .request()
                    .post(Entity.text(""));
        } catch (Exception e) {
            throw new DAOException("Failed request to register user", e);
        }
    }

    /**
     * updated horse position
     *
     * @param horseId  id of horse
     * @param raceId   id of race
     * @param position position of horse
     */
    public void setHoresPositionInRace(int horseId, int raceId, int position) throws DAOException {
        try {
            target.path("updatePosition")
                    .queryParam("horseId", horseId)
                    .queryParam("raceId", raceId)
                    .queryParam("position", position)
                    .request()
                    .put(Entity.text(""));
        } catch (Exception e) {
            throw new DAOException("Failed request to register user", e);
        }
    }

}
