package by.isysoi.model.dao;

import by.isysoi.model.entity.Bet;
import by.isysoi.model.entity.Client;
import by.isysoi.model.exception.DAOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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

            bets = entityManager.createNamedQuery("readBets")
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

            bet = entityManager.createNamedQuery("readBet", Bet.class)
                    .setParameter("id", id)
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

            transaction.begin();
            entityManager.createNamedQuery("deleteBet")
                    .setParameter("id", id)
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

            transaction.begin();
            entityManager.createNamedQuery("deleteBets").executeUpdate();
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

            List<Bet> bets = entityManager.createNamedQuery("readWinners", Bet.class)
                    .setParameter("raceId", raceId)
                    .getResultList();
            for (Bet bet : bets) {
                var client = bet.getClient();
                if (!clientsWithBet.containsKey(client)) {
                    clientsWithBet.put(client, new ArrayList<>());
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
