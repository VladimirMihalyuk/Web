package by.isysoi.dao.impl;

import by.isysoi.dao.protocol.BetDAOInterface;
import by.isysoi.entity.*;
import by.isysoi.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.*;

/**
 * bet dao class
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
@Stateless
public class BetDAO implements BetDAOInterface {

    protected Logger logger = LogManager.getLogger("dao_layer");

    @PersistenceContext
    private EntityManagerFactory factory;

    /**
     * DAO constructor
     */
    public BetDAO(EntityManagerFactory emf) {
        factory = emf;
        logger.info("BetDAO created ");
    }
    
    /**
     * read bets
     *
     * @return bets
     */
    public List<Bet> readBet() throws DAOException {
        EntityManager entityManager = null;
        List bets = null;

        try {
            entityManager = factory.createEntityManager();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Bet.class);
            Root rootBet = criteriaQuery.from(Bet.class);

            bets = entityManager.createQuery(criteriaQuery)
                    .getResultList();
        } catch (Exception e) {
            throw new DAOException("failed to insert bet", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return bets;
    }

    /**
     * read bet by id
     *
     * @param id bet id
     * @return bet
     */
    public Bet readBetById(int id) throws DAOException {
        EntityManager entityManager = null;
        Bet bet = null;

        try {
            entityManager = factory.createEntityManager();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Bet.class);
            Root rootBet = criteriaQuery.from(Bet.class);
            Predicate condition = criteriaBuilder.equal(rootBet.get(Bet_.id), id);
            criteriaQuery.where(condition);

            bet = (Bet) entityManager.createQuery(criteriaQuery)
                    .getSingleResult();
        } catch (Exception e) {
            throw new DAOException("failed to insert bet", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return bet;
    }

    /**
     * insety clients
     *
     * @param bet bet object
     * @throws DAOException if query execution failed
     */
    public void insertBet(Bet bet) throws DAOException {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = factory.createEntityManager();
            transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.persist(bet);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            throw new DAOException("failed to insert bet", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
    }

    /**
     * delete clients
     *
     * @param id id of bet
     * @throws DAOException if query execution failed
     */
    public void deleteBet(int id) throws DAOException {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = factory.createEntityManager();
            transaction = entityManager.getTransaction();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaDelete criteriaDelete = criteriaBuilder.createCriteriaDelete(Bet.class);
            Root rootBet = criteriaDelete.from(Bet.class);
            Predicate condition = criteriaBuilder.equal(rootBet.get(Bet_.id), id);
            criteriaDelete.where(condition);

            transaction.begin();
            entityManager.createQuery(criteriaDelete)
                    .executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            throw new DAOException("failed to delete bet", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
    }

    /**
     * delete clients
     *
     * @throws DAOException if query execution failed
     */
    public void deleteBets() throws DAOException {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = factory.createEntityManager();
            transaction = entityManager.getTransaction();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaDelete criteriaDelete = criteriaBuilder.createCriteriaDelete(Bet.class);
            Root rootBet = criteriaDelete.from(Bet.class);

            transaction.begin();
            entityManager.createQuery(criteriaDelete)
                    .executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            throw new DAOException("failed to delete bets", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
    }

    /**
     * get winners by race
     *
     * @param raceId id of race
     * @return list of clients
     * @throws DAOException if query execution failed
     */
    public Map<Client, Set<Bet>> readWinnersByRace(int raceId) throws DAOException {
        EntityManager entityManager = null;
        Map<Client, Set<Bet>> clientsWithBet = new HashMap<>();

        try {
            entityManager = factory.createEntityManager();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Bet> criteriaQuery = criteriaBuilder.createQuery(Bet.class);
            Root<Bet> rootBet = criteriaQuery.from(Bet.class);
            Join<Bet, Horse> horseJoin = rootBet.join(Bet_.horse);

            Subquery<Integer> subquery = criteriaQuery.subquery(Integer.class);
            Root<RaceInfo> rootRaceInfo = subquery.from(RaceInfo.class);
            subquery.select(rootRaceInfo.get(RaceInfo_.horseId))
                    .where(criteriaBuilder.and(
                            criteriaBuilder.equal(rootRaceInfo.get(RaceInfo_.position), 1),
                            criteriaBuilder.equal(rootRaceInfo.get(RaceInfo_.raceId), raceId))
                    );

            Predicate condition = criteriaBuilder.and(
                    criteriaBuilder.equal(rootBet.get(Bet_.race), raceId),
                    criteriaBuilder.in(horseJoin.get(Horse_.id)).value(subquery)
            );
            criteriaQuery.where(condition);

            List<Bet> bets = entityManager.createQuery(criteriaQuery).getResultList();

            for (Bet bet : bets) {
                var client = bet.getClient();
                if (!clientsWithBet.containsKey(client)) {
                    clientsWithBet.put(client, new HashSet<>());
                }
                clientsWithBet.get(client).add(bet);
            }
        } catch (Exception e) {
            throw new DAOException("failed to read winners by race", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return clientsWithBet;
    }


}
