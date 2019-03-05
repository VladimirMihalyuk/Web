package by.isysoi.controller;

import by.isysoi.model.dao.BetDAO;
import by.isysoi.model.dao.HorseDAO;
import by.isysoi.model.dao.RaceDAO;
import by.isysoi.model.entity.Bet;
import by.isysoi.model.entity.Client;
import by.isysoi.model.entity.Horse;
import by.isysoi.model.entity.Race;
import by.isysoi.model.exception.DAOException;
import by.isysoi.model.exception.HorseRaceControllerException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * controller
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class HorseRaceController {

    private Logger logger = LogManager.getLogger("controller_layer");

    /**
     * get horses from specific race
     *
     * @param raceId id of race
     * @return list of horses
     * @throws HorseRaceControllerException if DAO got some exception
     */
    public List<Horse> getHorsesByRaceId(int raceId) throws HorseRaceControllerException {
        List<Horse> horses;
        try {
            HorseDAO horseDAO = new HorseDAO();
            horses = horseDAO.readHorcesInRace(raceId);
            logger.info("read horses by race");
        } catch (DAOException e) {
            throw new HorseRaceControllerException("Failed to get horses by race id", e);
        }
        return horses;
    }

    /**
     * get races with specific date
     *
     * @param date some date
     * @return list of races on specific date
     * @throws HorseRaceControllerException if DAO got some exception
     */
    public List<Race> getRacesByDate(Date date) throws HorseRaceControllerException {
        List<Race> races;
        try {
            RaceDAO raceDAO = new RaceDAO();
            races = raceDAO.readRacesByDate(date);
            logger.info("read races by date");
        } catch (DAOException e) {
            throw new HorseRaceControllerException("Failed to get races by date", e);
        }
        return races;
    }

    /**
     * get clients and theier bets
     *
     * @param raceId id of race
     * @return map client and bets
     * @throws HorseRaceControllerException if DAO got some exception
     */
    public Map<Client, List<Bet>> getWinnersByRaceId(int raceId) throws HorseRaceControllerException {
        Map<Client, List<Bet>> clientsAndBets;
        try {
            BetDAO raceDAO = new BetDAO();
            clientsAndBets = raceDAO.readWinnersByRace(raceId);
            logger.info("read winners by race");
        } catch (DAOException e) {
            throw new HorseRaceControllerException("Failed to get winners", e);
        }
        return clientsAndBets;
    }

    /**
     * update race info
     *
     * @param raceId   id of race
     * @param horseId  horse id
     * @param position horse position of race to set
     * @throws HorseRaceControllerException if DAO got some exception
     */
    public void updateResultForRace(int raceId, int horseId, int position) throws HorseRaceControllerException {
        try {
            RaceDAO raceDAO = new RaceDAO();
            raceDAO.setHoresPositionInRace(horseId, raceId, position);
            logger.info("update race result");
        } catch (DAOException e) {
            throw new HorseRaceControllerException("Failed to update race result", e);
        }
    }

    /**
     * add horse to race
     *
     * @param raceId  race id
     * @param horseId horse id
     * @throws HorseRaceControllerException if DAO got some exception
     */
    public void addHorceToRace(int raceId, int horseId) throws HorseRaceControllerException {
        try {
            RaceDAO raceDAO = new RaceDAO();
            raceDAO.addHorseToRace(horseId, raceId);
            logger.info("added horse tp race");
        } catch (DAOException e) {
            throw new HorseRaceControllerException("Failed add horse", e);
        }
    }

}
