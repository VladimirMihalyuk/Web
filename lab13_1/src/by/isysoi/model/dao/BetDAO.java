package by.isysoi.model.dao;

import by.isysoi.model.entity.Bet;
import by.isysoi.model.entity.Bet_;
import by.isysoi.model.entity.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;
import java.util.*;

/**
 * bet dao class
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
@WebService()
public class BetDAO {

    protected Logger logger = LogManager.getLogger("dao_layer");

    @PersistenceContext(unitName = "Test_Local")
    private EntityManager entityManager;

    /**
     * DAO constructor
     */
    public BetDAO(EntityManagerFactory emf) {
        entityManager = emf.createEntityManager();
        logger.info("BetDAO created ");
    }

    public BetDAO() {
    }

    /**
     * read bets
     *
     * @return bets
     */
    @WebMethod
    public List<Bet> readBet() {
        List bets = null;
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Bet.class);
            Root rootBet = criteriaQuery.from(Bet.class);

            bets = entityManager.createQuery(criteriaQuery)
                    .getResultList();
        } catch (Exception e) {
            logger.error("failed to insert bet", e);
        }
        return bets;
    }

    /**
     * read bet by id
     *
     * @param id bet id
     * @return bet
     */
    @WebMethod
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
            logger.error("failed to insert bet", e);
        }
        return bet;
    }

    /**
     * insety clients
     *
     * @param bet bet object
     */
    @WebMethod
    public void insertBet(Bet bet) {
        try {
            UserTransaction transaction = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
            transaction.begin();
            entityManager.persist(bet);
            transaction.commit();
        } catch (Exception e) {
            logger.error("failed to insert bet", e);
        }
    }

    /**
     * get winners by race
     *
     * @param raceId id of race
     * @return list of clients
     */
    @WebMethod
    //public Map<Client, Set<Bet>> readWinnersByRace(int raceId) {
    public Set<Client> readWinnersByRace(int raceId) {
        Map<Client, Set<Bet>> clientsWithBet = new HashMap<>();

        try {
//            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//            CriteriaQuery<Bet> criteriaQuery = criteriaBuilder.createQuery(Bet.class);
//            Root<Bet> rootBet = criteriaQuery.from(Bet.class);
//            Join<Bet, Horse> horseJoin = rootBet.join(Bet_.horse);
//
//            Subquery<Integer> subquery = criteriaQuery.subquery(Integer.class);
//            Root<RaceInfo> rootRaceInfo = subquery.from(RaceInfo.class);
//            subquery.select(rootRaceInfo.get(RaceInfo_.horseId))
//                    .where(criteriaBuilder.and(
//                            criteriaBuilder.equal(rootRaceInfo.get(RaceInfo_.position), 1),
//                            criteriaBuilder.equal(rootRaceInfo.get(RaceInfo_.raceId), raceId))
//                    );
//
//            Predicate condition = criteriaBuilder.and(
//                    criteriaBuilder.equal(rootBet.get(Bet_.race), raceId),
//                    criteriaBuilder.in(horseJoin.get(Horse_.id)).value(subquery)
//            );
//            criteriaQuery.where(condition);

//            List<Bet> bets = entityManager.createQuery(criteriaQuery).getResultList();

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
            logger.error("failed to read winners by race", e);
        }
        return clientsWithBet.keySet();
    }


}
