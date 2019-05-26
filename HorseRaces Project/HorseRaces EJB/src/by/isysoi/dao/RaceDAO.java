package by.isysoi.dao;

import by.isysoi.entity.Race;
import by.isysoi.entity.RaceInfo;
import by.isysoi.entity.RaceInfo_;
import by.isysoi.entity.Race_;
import by.isysoi.exception.DAOException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import javax.ws.rs.Path;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * race dao class
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
@Stateless
@Path("/race")
public class RaceDAO {

    //protected Logger logger = LogManager.getLogger("dao_layer");

    @PersistenceContext(unitName = "Test_Local")
    private EntityManager entityManager;

    /**
     * DAO constructor
     */
    public RaceDAO(EntityManagerFactory emf) {
        entityManager = emf.createEntityManager();
        //logger.info("RaceDAO created ");
    }

    public RaceDAO() {
    }

    /**
     * read races
     *
     * @return list of races
     */
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_XML)
    public List<Race> readRaces() throws DAOException {
        List races = null;

        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Race.class);
            Root raceRoot = criteriaQuery.from(Race.class);

            races = entityManager.createQuery(criteriaQuery)
                    .getResultList();
        } catch (Exception e) {
            //logger.error("failed to insert bet", e);
            throw new DAOException("Failed to read races", e);
        }
        return races;
    }

    /**
     * read race by id
     *
     * @param id id of race
     * @return race
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Race readRaceById(@PathParam("id") int id) throws DAOException {
        Race race = null;

        try {

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Race.class);
            Root rootRace = criteriaQuery.from(Race.class);
            Predicate condition = criteriaBuilder.equal(rootRace.get(Race_.id), id);
            criteriaQuery.where(condition);

            race = (Race) entityManager.createQuery(criteriaQuery)
                    .getSingleResult();
        } catch (Exception e) {
            //logger.error("failed to read race", e);
            throw new DAOException("Failed to read race by id", e);
        }
        return race;
    }

    /**
     * insert race
     *
     * @param race race object
     */
    @POST
    @Path("/new")
    @Consumes(MediaType.APPLICATION_XML)
    public void insertRace(Race race) throws DAOException {
        try {
            entityManager.persist(race);
        } catch (Exception e) {
            //logger.error("failed to insert race", e);
            throw new DAOException("Failed to insert race", e);
        }
    }

    /**
     * read races by date
     *
     * @param stringDate date in format dd-MM-yyyy of race to select
     * @return list of race
     */
    @GET
    @Path("byDate/{date}")
    @Produces(MediaType.APPLICATION_XML)
    public List<Race> readRacesByDate(@PathParam("date") String stringDate) throws DAOException {
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = format.parse(stringDate);
        } catch (ParseException e) {
            throw new DAOException("Failed to parse date", e);
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR_OF_DAY, 3);
        List races = null;

        try {

            races = entityManager.createNamedQuery("readRaceByDate", Race.class)
                    .setParameter("raceDate", cal.getTime())
                    .getResultList();
        } catch (Exception e) {
            //logger.error("failed to read race by date", e);
            throw new DAOException("Failed  to read race by date", e);
        }
        return races;
    }

    /**
     * added horse to race
     *
     * @param horseId id of horse
     * @param raceId  id of race
     */
    @POST
    @Path("newHorse")
    public void addHorseToRace(@QueryParam("horseId") int horseId, @QueryParam("raceId") int raceId) throws DAOException {
        RaceInfo raceInfo = new RaceInfo();

        raceInfo.setHorseId(horseId);
        raceInfo.setRaceId(raceId);
        raceInfo.setPosition(null);

        try {
            entityManager.persist(raceInfo);
        } catch (Exception e) {
            //logger.error("failed to add horse to race", e);
            throw new DAOException("Failed to add horse to race", e);
        }
    }

    /**
     * updated horse position
     *
     * @param horseId  id of horse
     * @param raceId   id of race
     * @param position position of horse
     */
    @PUT
    @Path("updatePosition")
    public void setHoresPositionInRace(@QueryParam("horseId") int horseId, @QueryParam("raceId") int raceId, @QueryParam("position") int position) throws DAOException {
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaUpdate update = criteriaBuilder.createCriteriaUpdate(RaceInfo.class);
            Root rootRaceInfo = update.from(RaceInfo.class);
            update.set(rootRaceInfo.get(RaceInfo_.position), position);
            Predicate condition = criteriaBuilder.and(criteriaBuilder.equal(rootRaceInfo.get(RaceInfo_.raceId), raceId),
                    criteriaBuilder.equal(rootRaceInfo.get(RaceInfo_.horseId), horseId));
            update.where(condition);


            entityManager.createQuery(update)
                    .executeUpdate();

        } catch (Exception e) {
            //logger.error("failed to update position of horse", e);
            throw new DAOException("Failed to update position of horse", e);
        }
    }
}
