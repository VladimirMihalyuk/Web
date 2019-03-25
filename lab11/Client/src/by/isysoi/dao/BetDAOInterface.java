package by.isysoi.dao;

import by.isysoi.entity.*;

import javax.ejb.Remote;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Remote
public interface BetDAOInterface {

    /**
     * read bets
     *
     * @return bets
     */
    List<Bet> readBet();

    /**
     * read bet by id
     *
     * @param id bet id
     * @return bet
     */
    Bet readBetById(int id);

    /**
     * insety clients
     *
     * @param bet bet object
     */
    void insertBet(Bet bet);

    /**
     * get winners by race
     *
     * @param raceId id of race
     * @return list of clients
     */
    Map<Client, Set<Bet>> readWinnersByRace(int raceId);

}
