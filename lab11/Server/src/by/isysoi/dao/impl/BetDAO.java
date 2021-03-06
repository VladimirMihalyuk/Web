package by.isysoi.dao.impl;

import by.isysoi.dao.BetDAOInterface;
import by.isysoi.entity.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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

//    protected Logger logger = LogManager.getLogger("dao_layer");

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
    public List<Bet> readBet() {
        List bets = null;
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Bet.class);
            Root rootBet = criteriaQuery.from(Bet.class);

            bets = entityManager.createQuery(criteriaQuery)
                    .getResultList();
        } catch (Exception e) {
            //logger.error("failed to insert bet", e);
        }
        return bets;
    }

    /**
     * read bet by id
     *
     * @param id bet id
     * @return bet
     */
    public Bet readBetById(int id) {
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
        }
        return bet;
    }

    /**
     * insety clients
     *
     * @param bet bet object
     */
    public void insertBet(Bet bet) {
        try {
            entityManager.persist(bet);
        } catch (Exception e) {
            //logger.error("failed to insert bet", e);
        }
    }

    /**
     * get winners by race
     *
     * @param raceId id of race
     * @return list of clients
     */
    public Map<Client, Set<Bet>> readWinnersByRace(int raceId) {
        Map<Client, Set<Bet>> clientsWithBet = new HashMap<>();

        try {
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
                Client client = bet.getClient();
                if (!clientsWithBet.containsKey(client)) {
                    clientsWithBet.put(client, new HashSet<>());
                }
                clientsWithBet.get(client).add(bet);
            }
        } catch (Exception e) {
            //logger.error("failed to read winners by race", e);
        }
        return clientsWithBet;
    }


}
