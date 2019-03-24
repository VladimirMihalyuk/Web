package by.isysoi.controller;

import by.isysoi.model.dao.BetDAOInterface;
import by.isysoi.model.dao.ClientDAOInterface;
import by.isysoi.model.dao.HorseDAOInterface;
import by.isysoi.model.dao.RaceDAOInterface;
import by.isysoi.model.entity.Bet;
import by.isysoi.model.entity.Client;
import by.isysoi.model.entity.Horse;
import by.isysoi.model.entity.Race;
import by.isysoi.model.exception.ControllerException;
import by.isysoi.model.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

    public Controller(HorseDAOInterface horseDAO,
                      RaceDAOInterface raceDAO,
                      ClientDAOInterface clientDAO,
                      BetDAOInterface betDAO) {
        this.horseDAO = horseDAO;
        this.raceDAO = raceDAO;
        this.clientDAO = clientDAO;
        this.betDAO = betDAO;
    }

    /**
     * get horses from specific race
     *
     * @param raceId id of race
     * @return list of horses
     * @throws ControllerException if DAO got some exception
     */
    public List<Horse> getHorsesByRaceId(int raceId) throws ControllerException {
        List<Horse> horses;
        try {
            horses = horseDAO.readHorcesInRace(raceId);
            //logger.info("read horses by race");
        } catch (DAOException e) {
            throw new ControllerException("Failed to get horses by race id", e);
        }
        return horses;
    }

    /**
     * get races with specific date
     *
     * @param date some date
     * @return list of races on specific date
     * @throws ControllerException if DAO got some exception
     */
    public List<Race> getRacesByDate(Date date) throws ControllerException {
        List<Race> races;
        try {
            races = raceDAO.readRacesByDate(date);
            //logger.info("read races by date");
        } catch (DAOException e) {
            throw new ControllerException("Failed to get races by date", e);
        }
        return races;
    }

    /**
     * get clients and theier bets
     *
     * @param raceId id of race
     * @return map client and bets
     * @throws ControllerException if DAO got some exception
     */
    public Map<Client, Set<Bet>> getWinnersByRaceId(int raceId) throws ControllerException {
        Map<Client, Set<Bet>> clientsAndBets;
        try {
            clientsAndBets = betDAO.readWinnersByRace(raceId);
            //logger.info("read winners by race");
        } catch (DAOException e) {
            throw new ControllerException("Failed to get winners", e);
        }
        return clientsAndBets;
    }

    /**
     * update race info
     *
     * @param raceId   id of race
     * @param horseId  horse id
     * @param position horse position of race to set
     * @throws ControllerException if DAO got some exception
     */
    public void updateResultForRace(int raceId, int horseId, int position) throws ControllerException {
        try {
            raceDAO.setHoresPositionInRace(horseId, raceId, position);
            //logger.info("update race result");
        } catch (DAOException e) {
            throw new ControllerException("Failed to update race result", e);
        }
    }

    /**
     * add horse to race
     *
     * @param raceId  race id
     * @param horseId horse id
     * @throws ControllerException if DAO got some exception
     */
    public void addHorceToRace(int raceId, int horseId) throws ControllerException {
        try {
            raceDAO.addHorseToRace(horseId, raceId);
            //logger.info("added horse tp race");
        } catch (DAOException e) {
            throw new ControllerException("Failed add horse", e);
        }
    }

}
