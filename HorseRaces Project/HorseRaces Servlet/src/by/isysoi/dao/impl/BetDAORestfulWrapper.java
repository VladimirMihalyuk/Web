package by.isysoi.dao.impl;

import by.isysoi.dao.BetDAOInterface;
import by.isysoi.dao.HorseRacesEndPointConstants;
import by.isysoi.entity.Bet;
import by.isysoi.entity.Client;
import by.isysoi.exception.DAOException;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.*;

/**
 * bet dao wrapper class
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class BetDAORestfulWrapper implements BetDAOInterface {

    //protected Logger logger = LogManager.getLogger("dao_layer");

    private WebTarget target;

    public BetDAORestfulWrapper() {
        target = ClientBuilder.newClient().target(HorseRacesEndPointConstants.betEndPoint);
    }

    /**
     * read bets
     *
     * @return bets
     */
    public List<Bet> readBet() throws DAOException {
        List bets = null;
        try {
            bets = target.path("all")
                    .request(MediaType.APPLICATION_XML)
                    .get(new GenericType<List<Bet>>() {});
        } catch (Exception e) {
            throw new DAOException("Failed request to find all bets", e);
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
            bet = target.path(String.valueOf(id))
                    .request(MediaType.APPLICATION_XML)
                    .get(Bet.class);
        } catch (Exception e) {
            throw new DAOException("Failed request to find bet with id - " + id, e);
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
            target.path("new")
                    .request()
                    .post(Entity.entity(bet, MediaType.APPLICATION_XML));
        } catch (Exception e) {
            throw new DAOException("Failed request to insert bet", e);
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
        Set<Client> winners = null;
        try {
            winners = target.path("winnersByRace")
                    .path(String.valueOf(raceId))
                    .request(MediaType.APPLICATION_XML)
                    .get(new GenericType<Set<Client>>() {});
        } catch (Exception e) {
            throw new DAOException("Failed request to find all bets", e);
        }

        for (Client client: winners) {
            clientsWithBet.put(client, new HashSet<>());
        }

        return clientsWithBet;
    }


}
