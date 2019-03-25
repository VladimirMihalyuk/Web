package by.isysoi.controller;

import by.isysoi.entity.*;
import by.isysoi.dao.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * controller
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class Controller {

    //private Logger logger = LogManager.getLogger("controller_layer");

    private HorseDAOInterface horseDAO;
    private RaceDAOInterface raceDAO;
    private ClientDAOInterface clientDAO;
    private BetDAOInterface betDAO;

    public Controller(HorseDAOInterface _horseDAO,
                      RaceDAOInterface _raceDAO,
                      ClientDAOInterface _clientDAO,
                      BetDAOInterface _betDAO) {
        horseDAO = _horseDAO;
        raceDAO = _raceDAO;
        clientDAO = _clientDAO;
        betDAO = _betDAO;
    }

    /**
     * get horses from specific race
     *
     * @param raceId id of race
     * @return list of horses
     */
    public List<Horse> getHorsesByRaceId(int raceId) {
        List<Horse> horses;
        horses = horseDAO.readHorcesInRace(raceId);
        return horses;
    }

    /**
     * get races with specific date
     *
     * @param date some date
     * @return list of races on specific date
     */
    public List<Race> getRacesByDate(Date date) {
        List<Race> races;
        races = raceDAO.readRacesByDate(date);
        return races;
    }

    /**
     * get clients and theier bets
     *
     * @param raceId id of race
     * @return map client and bets
     */
    public Map<Client, Set<Bet>> getWinnersByRaceId(int raceId) {
        Map<Client, Set<Bet>> clientsAndBets;
        clientsAndBets = betDAO.readWinnersByRace(raceId);
        return clientsAndBets;
    }

    /**
     * update race info
     *
     * @param raceId   id of race
     * @param horseId  horse id
     * @param position horse position of race to set
     */
    public void updateResultForRace(int raceId, int horseId, int position) {
        raceDAO.setHoresPositionInRace(horseId, raceId, position);
    }

    /**
     * add horse to race
     *
     * @param raceId  race id
     * @param horseId horse id
     */
    public void addHorceToRace(int raceId, int horseId) {
        raceDAO.addHorseToRace(horseId, raceId);
    }

}
