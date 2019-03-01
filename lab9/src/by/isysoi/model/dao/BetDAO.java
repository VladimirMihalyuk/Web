package by.isysoi.model.dao;

import by.isysoi.model.entity.Bet;
import by.isysoi.model.entity.Client;
import by.isysoi.model.exception.DAOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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
        EntityManager em = getEntityManager();
        List bets = em.createNamedQuery("readBets").getResultList();
        return bets;
    }

    /**
     * read bet by id
     *
     * @return bet
     */
    public Bet readBetById(int id) throws DAOException {
        EntityManager em = getEntityManager();
        Bet bet = em.createNamedQuery("readBet", Bet.class)
                .setParameter("id", id)
                .getSingleResult();
        return bet;
    }

    /**
     * insety clients
     */
    public void insertBet(Bet bet) throws DAOException {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(bet);
        transaction.commit();
    }

    /**
     * delete clients
     */
    public void deleteBet(Bet bet) throws DAOException {
        EntityManager em = getEntityManager();
        em.createNamedQuery("deleteBet")
                .setParameter("id", bet.getId())
                .executeUpdate();
    }

    /**
     * delete clients
     */
    public void deleteBets() throws DAOException {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.createNamedQuery("deleteBets").executeUpdate();
        transaction.commit();
    }

    /**
     * get winners by race
     *
     * @return list of clients
     */
    public List<Map.Entry<Client, Bet>> readWinnersByRace(int raceId) throws DAOException {
        EntityManager em = getEntityManager();
        List clientsWithBet = em.createNamedQuery("readWinners")
                .setParameter("raceId", raceId)
                .getResultList();
        return clientsWithBet;
    }


}
