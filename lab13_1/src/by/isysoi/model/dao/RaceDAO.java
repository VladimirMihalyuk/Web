package by.isysoi.model.dao;

import by.isysoi.model.entity.Race;
import by.isysoi.model.entity.RaceInfo;
import by.isysoi.model.entity.RaceInfo_;
import by.isysoi.model.entity.Race_;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import javax.transaction.UserTransaction;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * race dao class
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class RaceDAO {

    protected Logger logger = LogManager.getLogger("dao_layer");

    @PersistenceContext(unitName = "Test_Local")
    private EntityManager entityManager;

    /**
     * DAO constructor
     */
    public RaceDAO(EntityManagerFactory emf) {
        entityManager = emf.createEntityManager();
        logger.info("RaceDAO created ");
    }

    public RaceDAO() {
    }

    /**
     * read races
     *
     * @return list of races
     */

    public List<Race> readRaces() {
        List races = null;

        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Race.class);
            Root raceRoot = criteriaQuery.from(Race.class);

            races = entityManager.createQuery(criteriaQuery)
                    .getResultList();
        } catch (Exception e) {
            logger.error("failed to insert bet", e);
        }
        return races;
    }

    /**
     * read race by id
     *
     * @param id id of race
     * @return race
     */

    public Race readRaceById(int id) {
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
            logger.error("failed to read race", e);
        }
        return race;
    }

    /**
     * insert race
     *
     * @param race race object
     */

    public void insertRace(Race race) {
        try {
            UserTransaction transaction = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
            transaction.begin();
            entityManager.joinTransaction();
            entityManager.persist(race);
            transaction.commit();
        } catch (Exception e) {
            logger.error("failed to insert race", e);
        }
    }

    /**
     * read races by date
     *
     * @param date date of race to select
     * @return list of races
     */

    public List<Race> readRacesByDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR_OF_DAY, 3);
        List races = null;

        try {

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Race.class);
            Root rootRace = criteriaQuery.from(Race.class);
            Predicate condition = criteriaBuilder.equal(rootRace.get(Race_.raceDate), cal.getTime());
            criteriaQuery.where(condition);

            races = entityManager.createQuery(criteriaQuery)
                    .getResultList();
        } catch (Exception e) {
            logger.error("failed to read race by date", e);
        }
        return races;
    }

    /**
     * added horse to race
     *
     * @param horseId id of horse
     * @param raceId  id of race
     */

    public void addHorseToRace(int horseId, int raceId) {
        RaceInfo raceInfo = new RaceInfo();

        raceInfo.setHorseId(horseId);
        raceInfo.setRaceId(raceId);
        raceInfo.setPosition(null);

        try {
            UserTransaction transaction = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
            transaction.begin();
            entityManager.joinTransaction();
            entityManager.persist(raceInfo);
            transaction.commit();
        } catch (Exception e) {
            logger.error("failed to add horse to race", e);
        }
    }

    /**
     * updated horse position
     *
     * @param horseId  id of horse
     * @param raceId   id of race
     * @param position position of horse
     */

    public void setHoresPositionInRace(int horseId, int raceId, int position) {
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaUpdate update = criteriaBuilder.createCriteriaUpdate(RaceInfo.class);
            Root rootRaceInfo = update.from(RaceInfo.class);
            update.set(rootRaceInfo.get(RaceInfo_.position), position);
            Predicate condition = criteriaBuilder.and(criteriaBuilder.equal(rootRaceInfo.get(RaceInfo_.raceId), raceId),
                    criteriaBuilder.equal(rootRaceInfo.get(RaceInfo_.horseId), horseId));
            update.where(condition);


            UserTransaction transaction = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
            transaction.begin();
            entityManager.joinTransaction();

            entityManager.createQuery(update)
                    .executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            logger.error("failed to update position of horse", e);
        }
    }

}
