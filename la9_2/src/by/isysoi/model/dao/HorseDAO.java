package by.isysoi.model.dao;

import by.isysoi.model.entity.Horse;
import by.isysoi.model.entity.Race;
import by.isysoi.model.exception.DAOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * horse dao class
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class HorseDAO extends DAO {

    /**
     * constructor
     */
    public HorseDAO() {
        super();
    }

    /**
     * read horses
     *
     * @return list of horses
     * @throws DAOException if query execution failed
     */
    public List<Horse> readHorses() throws DAOException {
        EntityManager entityManager = null;
        List horses = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();

            horses = entityManager.createNamedQuery("readHorses")
                    .getResultList();
        } catch (Exception e) {
            throw new DAOException("failed to read horses", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return horses;
    }

    /**
     * read horse by id
     *
     * @param id id of horse
     * @return horse
     * @throws DAOException if query execution failed
     */
    public Horse readHorseById(int id) throws DAOException {
        EntityManager entityManager = null;
        Horse horse = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();

            horse = entityManager.createNamedQuery("readHorse", Horse.class)
                    .getSingleResult();
        } catch (Exception e) {
            throw new DAOException("failed to read horse", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return horse;
    }

    /**
     * insert horse
     *
     * @param horse horse object
     * @throws DAOException if query execution failed
     */
    public void insertHorse(Horse horse) throws DAOException {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.persist(horse);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            throw new DAOException("failed to insert horse", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
    }

    /**
     * delete horse
     *
     * @param id id of horse
     * @throws DAOException if query execution failed
     */
    public void deleteHorse(int id) throws DAOException {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.createNamedQuery("deleteHorse")
                    .setParameter("id", id)
                    .executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            throw new DAOException("failed to delete horse", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
    }

    /**
     * delete Horses
     *
     * @throws DAOException if query execution failed
     */
    public void deleteHorses() throws DAOException {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.createNamedQuery("deleteHorses").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            throw new DAOException("failed to delete horses", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
    }

    /**
     * read horses in race
     *
     * @param raceId id of race
     * @throws DAOException if query execution failed
     */
    public List<Horse> readHorcesInRace(int raceId) throws DAOException {
        EntityManager entityManager = null;
        List<Horse> horses = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();

            horses = entityManager.createNamedQuery("readRace", Race.class)
                    .setParameter("id", raceId)
                    .getSingleResult().horses;
        } catch (Exception e) {
            throw new DAOException("failed to read horses in race", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return horses;
    }


}
