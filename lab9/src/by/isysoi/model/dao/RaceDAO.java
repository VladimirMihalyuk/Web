package by.isysoi.model.dao;

import by.isysoi.model.entity.Race;
import by.isysoi.model.entity.RaceInfo;
import by.isysoi.model.exception.DAOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * race dao class
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class RaceDAO extends DAO {

    /**
     * constructor
     */
    public RaceDAO() {
        super();
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
            entityManager = getEntityManagerFactory().createEntityManager();

            races = entityManager.createNamedQuery("readRaces")
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
            entityManager = getEntityManagerFactory().createEntityManager();

            race = entityManager.createNamedQuery("readRace", Race.class)
                    .setParameter("id", id)
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
            entityManager = getEntityManagerFactory().createEntityManager();
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
            entityManager = getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.createNamedQuery("deleteRace")
                    .setParameter("id", id)
                    .executeUpdate();
            transaction.commit();
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
            entityManager = getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.createNamedQuery("deleteRaces").executeUpdate();
            transaction.commit();
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
            entityManager = getEntityManagerFactory().createEntityManager();

            races = entityManager.createNamedQuery("readRaceByDate")
                    .setParameter("raceDate", cal.getTime())
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
        var raceInfo = new RaceInfo();

        raceInfo.setHorseId(horseId);
        raceInfo.setRaceId(raceId);
        raceInfo.setPosition(null);

        try {
            entityManager = getEntityManagerFactory().createEntityManager();
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
            entityManager = getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.createNamedQuery("updateHorsePosition")
                    .setParameter("horseId", horseId)
                    .setParameter("raceId", raceId)
                    .setParameter("position", position)
                    .executeUpdate();
            transaction.commit();
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
