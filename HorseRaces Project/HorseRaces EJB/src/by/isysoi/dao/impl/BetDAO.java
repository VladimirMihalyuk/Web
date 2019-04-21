package by.isysoi.dao.impl;

import by.isysoi.dao.BetDAOInterface;
import by.isysoi.entity.Bet;
import by.isysoi.entity.Bet_;
import by.isysoi.entity.Client;
import by.isysoi.exception.DAOException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

/**
 * bet dao class
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
@Stateless
public class BetDAO implements BetDAOInterface {

    //protected Logger logger = LogManager.getLogger("dao_layer");

    @PersistenceContext(unitName = "Test_Local")
    private EntityManager entityManager;

    /**
     * DAO constructor
     */
    public BetDAO(EntityManagerFactory emf) {
        entityManager = emf.createEntityManager();
        //logger.info("BetDAO created ");
    }

    public BetDAO() {
    }

    /**
     * read bets
     *
     * @return bets
     */
    public List<Bet> readBet() throws DAOException {
        List bets = null;
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Bet.class);
            Root rootBet = criteriaQuery.from(Bet.class);

            bets = entityManager.createQuery(criteriaQuery)
                    .getResultList();
        } catch (Exception e) {
            //logger.error("failed to insert bet", e);
            throw new DAOException("Failed to read bets", e);
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
        Bet bet = null;
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Bet.class);
            Root rootBet = criteriaQuery.from(Bet.class);
            Predicate condition = criteriaBuilder.equal(rootBet.get(Bet_.id), id);
            criteriaQuery.where(condition);

            bet = (Bet) entityManager.createQuery(criteriaQuery)
                    .getSingleResult();
        } catch (Exception e) {
            //logger.error("failed to insert bet", e);
            throw new DAOException("Failed to read bet by id", e);
        }
        return bet;
    }

    /**
     * insety clients
     *
     * @param bet bet object
     */
    public void insertBet(Bet bet) throws DAOException {
        try {
            entityManager.persist(bet);
        } catch (Exception e) {
            //logger.error("failed to insert bet", e);
            throw new DAOException("Failed to insert bet", e);
        }
    }

    /**
     * get winners by race
     *
     * @param raceId id of race
     * @return list of clients
     */
    public Map<Client, Set<Bet>> readWinnersByRace(int raceId) throws DAOException {
        Map<Client, Set<Bet>> clientsWithBet = new HashMap<>();

        try {

            List<Bet> bets = entityManager.createNamedQuery("readWinningBets", Bet.class)
                    .setParameter("raceId", raceId)
                    .getResultList();

            for (Bet bet : bets) {
                Client client = bet.getClient();
                if (!clientsWithBet.containsKey(client)) {
                    clientsWithBet.put(client, new HashSet<>());
                }
                clientsWithBet.get(client).add(bet);
            }
        } catch (Exception e) {
            //logger.error("failed to read winners by race", e);
            throw new DAOException("Failed to read winners", e);
        }
        return clientsWithBet;
    }


}
