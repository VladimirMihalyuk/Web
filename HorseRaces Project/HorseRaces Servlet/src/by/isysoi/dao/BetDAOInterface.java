package by.isysoi.dao;

import by.isysoi.entity.Bet;
import by.isysoi.entity.Client;
import by.isysoi.exception.DAOException;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface BetDAOInterface {

    /**
     * read bets
     *
     * @return bets
     */
    List readBet() throws DAOException;

    /**
     * read bet by id
     *
     * @param id bet id
     * @return bet
     */
    Bet readBetById(int id) throws DAOException;

    /**
     * insety clients
     *
     * @param bet bet object
     */
    void insertBet(Bet bet) throws DAOException;

    /**
     * get winners by race
     *
     * @param raceId id of race
     * @return list of clients
     */
    Map<Client, Set<Bet>> readWinnersByRace(int raceId) throws DAOException;

}
