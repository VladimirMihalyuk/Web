package by.isysoi.dao.impl;

import by.isysoi.dao.RaceDAOInterface;
import by.isysoi.entity.Race;
import by.isysoi.entity.RaceInfo;
import by.isysoi.entity.RaceInfo_;
import by.isysoi.entity.Race_;
import by.isysoi.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
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
public class RaceDAO implements RaceDAOInterface {

    protected Logger logger = LogManager.getLogger("dao_layer");

    @PersistenceContext(unitName = "Test_Local")
    private EntityManagerFactory factory;

    /**
     * DAO constructor
     */
    public RaceDAO(EntityManagerFactory emf) {
        factory = emf;
        logger.info("RaceDAO created ");
    }

    public RaceDAO() {
    }

    /**
     * read races
     *
     * @return list of races
     * @throws DAOException if query execution failed
     */
    public List<Race> readRaces() throws DAOException {
        EntityManager entityManager = null;
        List races = null;

        try {
            entityManager = factory.createEntityManager();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Race.class);
            Root raceRoot = criteriaQuery.from(Race.class);

            races = entityManager.createQuery(criteriaQuery)
                    .getResultList();
        } catch (Exception e) {
            throw new DAOException("failed to insert bet", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return races;
    }

    /**
     * read race by id
     *
     * @param id id of race
     * @return race
     * @throws DAOException if query execution failed
     */
    public Race readRaceById(int id) throws DAOException {
        EntityManager entityManager = null;
        Race race = null;

        try {
            entityManager = factory.createEntityManager();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Race.class);
            Root rootRace = criteriaQuery.from(Race.class);
            Predicate condition = criteriaBuilder.equal(rootRace.get(Race_.id), id);
            criteriaQuery.where(condition);

            race = (Race) entityManager.createQuery(criteriaQuery)
                    .getSingleResult();
        } catch (Exception e) {
            throw new DAOException("failed to read race", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return race;
    }

    /**
     * insert race
     *
     * @param race race object
     * @throws DAOException if query execution failed
     */
    public void insertRace(Race race) throws DAOException {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = factory.createEntityManager();
            transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.persist(race);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            throw new DAOException("failed to insert race", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
    }

    /**
     * delete race
     *
     * @param id id of race
     * @throws DAOException if query execution failed
     */
    public void deleteRace(int id) throws DAOException {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
//            entityManager = factory.createEntityManager();
//            transaction = entityManager.getTransaction();
//
//            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//            CriteriaDelete criteriaDelete = criteriaBuilder.createCriteriaDelete(Race.class);
//            Root rootRace = criteriaDelete.from(Race.class);
//            Predicate condition = criteriaBuilder.equal(rootRace.get(Race_.id), id);
//            criteriaDelete.where(condition);
//
//            transaction.begin();
//            entityManager.createQuery(criteriaDelete)
//                    .executeUpdate();
//            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            throw new DAOException("failed to delete race", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
    }

    /**
     * delete races
     *
     * @throws DAOException if query execution failed
     */
    public void deleteRaces() throws DAOException {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
//            entityManager = factory.createEntityManager();
//            transaction = entityManager.getTransaction();
//
//            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//            CriteriaDelete criteriaDelete = criteriaBuilder.createCriteriaDelete(Race.class);
//            Root rootRace = criteriaDelete.from(Race.class);
//
//            transaction.begin();
//            entityManager.createQuery(criteriaDelete)
//                    .executeUpdate();
//            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            throw new DAOException("failed to delete races", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
    }

    /**
     * read races by date
     *
     * @param date date of race to select
     * @return list of races
     * @throws DAOException if query execution failed
     */
    public List<Race> readRacesByDate(Date date) throws DAOException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR_OF_DAY, 3);

        EntityManager entityManager = null;
        List races = null;

        try {
            entityManager = factory.createEntityManager();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Race.class);
            Root rootRace = criteriaQuery.from(Race.class);
            Predicate condition = criteriaBuilder.equal(rootRace.get(Race_.raceDate), cal.getTime());
            criteriaQuery.where(condition);

            races = entityManager.createQuery(criteriaQuery)
                    .getResultList();
        } catch (Exception e) {
            throw new DAOException("failed to read race by date", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return races;
    }

    /**
     * added horse to race
     *
     * @param horseId id of horse
     * @param raceId  id of race
     * @throws DAOException if query execution failed
     */
    public void addHorseToRace(int horseId, int raceId) throws DAOException {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        RaceInfo raceInfo = new RaceInfo();

        raceInfo.setHorseId(horseId);
        raceInfo.setRaceId(raceId);
        raceInfo.setPosition(null);

        try {
            entityManager = factory.createEntityManager();
            transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.persist(raceInfo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            throw new DAOException("failed to add horse to race", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
    }

    /**
     * updated horse position
     *
     * @param horseId  id of horse
     * @param raceId   id of race
     * @param position position of horse
     * @throws DAOException if query execution failed
     */
    public void setHoresPositionInRace(int horseId, int raceId, int position) throws DAOException {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
//            entityManager = factory.createEntityManager();
//            transaction = entityManager.getTransaction();
//
//            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//            CriteriaUpdate update = criteriaBuilder.createCriteriaUpdate(RaceInfo.class);
//            Root rootRaceInfo = update.from(RaceInfo.class);
//            update.set(rootRaceInfo.get(RaceInfo_.position), position);
//            Predicate condition = criteriaBuilder.and(criteriaBuilder.equal(rootRaceInfo.get(RaceInfo_.raceId), raceId),
//                    criteriaBuilder.equal(rootRaceInfo.get(RaceInfo_.horseId), horseId));
//            update.where(condition);
//
//            transaction.begin();
//            entityManager.createQuery(update)
//                    .executeUpdate();
//            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            throw new DAOException("failed to update position of horse", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
    }

}
