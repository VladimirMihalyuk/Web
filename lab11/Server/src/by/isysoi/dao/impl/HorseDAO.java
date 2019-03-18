package by.isysoi.dao.impl;

import by.isysoi.dao.protocol.HorseDAOInterface;
import by.isysoi.entity.Horse;
import by.isysoi.entity.Horse_;
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
import java.util.List;

/**
 * horse dao class
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
@Stateless
public class HorseDAO implements HorseDAOInterface {

    protected Logger logger = LogManager.getLogger("dao_layer");

    @PersistenceContext
    private EntityManagerFactory factory;

    /**
     * DAO constructor
     */
    public HorseDAO(EntityManagerFactory emf) {
        factory = emf;
        logger.info("HorseDAO created ");
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
            entityManager = factory.createEntityManager();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Horse.class);
            Root horseRoot = criteriaQuery.from(Horse.class);

            horses = entityManager.createQuery(criteriaQuery)
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
            entityManager = factory.createEntityManager();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Horse.class);
            Root rootHorse = criteriaQuery.from(Horse.class);
            Predicate condition = criteriaBuilder.equal(rootHorse.get(Horse_.id), id);
            criteriaQuery.where(condition);

            horse = (Horse) entityManager.createQuery(criteriaQuery)
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
            entityManager = factory.createEntityManager();
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
            entityManager = factory.createEntityManager();
            transaction = entityManager.getTransaction();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaDelete criteriaDelete = criteriaBuilder.createCriteriaDelete(Horse.class);
            Root rootHorse = criteriaDelete.from(Horse.class);
            Predicate condition = criteriaBuilder.equal(rootHorse.get(Horse_.id), id);
            criteriaDelete.where(condition);

            transaction.begin();
            entityManager.createQuery(criteriaDelete)
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
            entityManager = factory.createEntityManager();
            transaction = entityManager.getTransaction();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaDelete criteriaDelete = criteriaBuilder.createCriteriaDelete(Horse.class);
            Root horseRoot = criteriaDelete.from(Horse.class);

            transaction.begin();
            entityManager.createQuery(criteriaDelete)
                    .executeUpdate();
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
        List horses = null;

        try {
            entityManager = factory.createEntityManager();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Horse.class);
            Root rootHorse = criteriaQuery.from(Horse.class);
            Join raceJoin = rootHorse.join(Horse_.races);
            Predicate condition = criteriaBuilder.equal(raceJoin.get(Race_.id), raceId);
            raceJoin.on(condition);


            horses = entityManager.createQuery(criteriaQuery)
                    .getResultList();
        } catch (Exception e) {
            throw new DAOException("failed to read horses in race", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return horses;
    }


}
