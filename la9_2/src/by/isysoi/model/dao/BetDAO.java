package by.isysoi.model.dao;

import by.isysoi.model.entity.*;
import by.isysoi.model.exception.DAOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * bet dao class
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class BetDAO extends DAO {

    /**
     * constructor
     */
    public BetDAO() {
        super();
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
            entityManager = getEntityManagerFactory().createEntityManager();

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
            entityManager = getEntityManagerFactory().createEntityManager();

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
            entityManager = getEntityManagerFactory().createEntityManager();
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
            entityManager = getEntityManagerFactory().createEntityManager();
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
            entityManager = getEntityManagerFactory().createEntityManager();
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
    public Map<Client, List<Bet>> readWinnersByRace(int raceId) throws DAOException {
        EntityManager entityManager = null;
        Map<Client, List<Bet>> clientsWithBet = new HashMap<>();

        try {
            entityManager = getEntityManagerFactory().createEntityManager();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Client.class);
            Root rootClient = criteriaQuery.from(Client.class);
            Join betJoin = rootClient.join(Client_.bets);
            Join raceJoin = betJoin.join(Bet_.race);

            Subquery subquery = criteriaQuery.subquery(Integer.class);
            Root rootRaceInfo = subquery.from(RaceInfo.class);

            subquery.select(rootRaceInfo.get(RaceInfo_.raceId))
                    .where(criteriaBuilder.equal(rootRaceInfo.get(RaceInfo_.position), 1));

            Predicate condition = criteriaBuilder.and(criteriaBuilder.equal(raceJoin.get(Race_.id), raceId),
                    criteriaBuilder.in(raceJoin.get(Race_.id)).value(subquery));
            raceJoin.on(condition);

            List<Client> clients = entityManager.createQuery(criteriaQuery).getResultList();

            for (Client client : clients) {
                var bets = client.bets;
                if (!clientsWithBet.containsKey(client)) {
                    clientsWithBet.put(client, new ArrayList<>());
                }
                for (Bet bet : bets) {
                    if (clientsWithBet.get(client).contains(bet))
                        continue;
                    clientsWithBet.get(client).add(bet);
                }
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
