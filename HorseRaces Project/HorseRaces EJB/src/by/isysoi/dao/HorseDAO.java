package by.isysoi.dao;

import by.isysoi.entity.*;
import by.isysoi.exception.DAOException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import javax.ws.rs.Path;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * horse dao class
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
@Stateless
@Path("/horse")
public class HorseDAO { //implements HorseDAOInterface {

    //protected Logger logger = LogManager.getLogger("dao_layer");

    @PersistenceContext(unitName = "Test_Local")
    private EntityManager entityManager;

    /**
     * DAO constructor
     */
    public HorseDAO(EntityManagerFactory emf) {
        entityManager = emf.createEntityManager();
        //logger.info("HorseDAO created ");
    }

    public HorseDAO() {
    }


    /**
     * read horses
     *
     * @return list of horses
     */
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_XML)
    public List<Horse> readHorses() throws DAOException {
        List horses = null;

        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Horse.class);
            Root horseRoot = criteriaQuery.from(Horse.class);

            horses = entityManager.createQuery(criteriaQuery)
                    .getResultList();
        } catch (Exception e) {
            //logger.error("failed to read horses", e);
            throw new DAOException("Failed to read horses", e);
        }
        return horses;
        //WebApplicationException(Response.Status.NOT_FOUND);
    }

    /**
     * read horse by id
     *
     * @param id id of horse
     * @return horse
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Horse readHorseById(@PathParam("id") int id) throws DAOException {
        Horse horse = null;

        try {

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Horse.class);
            Root rootHorse = criteriaQuery.from(Horse.class);
            Predicate condition = criteriaBuilder.equal(rootHorse.get(Horse_.id), id);
            criteriaQuery.where(condition);

            horse = (Horse) entityManager.createQuery(criteriaQuery)
                    .getSingleResult();
        } catch (Exception e) {
            //logger.error("failed to read horse", e);
            throw new DAOException("Failed to read horse", e);
        }
        return horse;
    }

    /**
     * insert horse
     *
     * @param horse horse object
     */
    @POST
    @Path("/new")
    @Consumes(MediaType.APPLICATION_XML)
    public void insertHorse(Horse horse) throws DAOException {
        try {
            entityManager.persist(horse);
        } catch (Exception e) {
            //logger.error("failed to insert horse", e);
            throw new DAOException("Failed to insert horse", e);
        }
    }

    /**
     * read horses in race
     *
     * @param raceId id of race
     */
    @GET
    @Path("byRace/{raceId}")
    @Produces(MediaType.APPLICATION_XML)
    public List<Horse> readHorcesInRace(@PathParam("raceId") int raceId) throws DAOException {
        List horses = null;

        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Horse.class);
            Root rootHorse = criteriaQuery.from(Horse.class);
            Join<Horse, Race> raceJoin = rootHorse.join(Horse_.races);
            Predicate condition = criteriaBuilder.equal(raceJoin.get(Race_.id), raceId);
            criteriaQuery.where(condition);

            horses = entityManager.createQuery(criteriaQuery)
                    .getResultList();
        } catch (Exception e) {
            //logger.error("failed to read horses in race", e);
            throw new DAOException("Failed to read horses in race", e);
        }
        return horses;
    }

    /**
     * delete horse
     *
     * @param id id of horse
     * @throws DAOException if query execution failed
     */
    @DELETE
    @Path("{id}")
    public void deleteHorse(@PathParam("id") int id, @QueryParam("raceId") int raceId) throws DAOException {
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaDelete delete = criteriaBuilder.createCriteriaDelete(RaceInfo.class);
            Root rootRaceInfo = delete.from(RaceInfo.class);
            Predicate condition = criteriaBuilder.and(criteriaBuilder.equal(rootRaceInfo.get(RaceInfo_.raceId), raceId),
                    criteriaBuilder.equal(rootRaceInfo.get(RaceInfo_.horseId), id));
            delete.where(condition);


            entityManager.createQuery(delete)
                    .executeUpdate();

        } catch (Exception e) {
            //logger.error("failed to update position of horse", e);
            throw new DAOException("Failed to delete horse from race", e);
        }
    }


}
