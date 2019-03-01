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

    public List<Horse> getHorsesByRaceId(int raceId) throws HorseRaceControllerException {
        List<Horse> horses;
        try {
            HorseDAO tmp = new HorseDAO();
            horses = tmp.readHorcesInRace(raceId);
            logger.info("read horses by race");
        } catch (DAOException e) {
            throw new HorseRaceControllerException("Failed to get horses by race id", e);
        }
        return horses;
    }

    public List<Race> getRacesByDate(Date date) throws HorseRaceControllerException {
        List<Race> races;
        try {
            RaceDAO tmp = new RaceDAO();
            races = tmp.readRacesByDate(date);
            logger.info("read races by date");
        } catch (DAOException e) {
            throw new HorseRaceControllerException("Failed to get races by date", e);
        }
        return races;
    }

    public List<Map.Entry<Client, Bet>> getWinnersByRaceId(int raceId) throws HorseRaceControllerException {
        List<Map.Entry<Client, Bet>> clientsAndBets;
        try {
            BetDAO tmp = new BetDAO();
            clientsAndBets = tmp.readWinnersByRace(raceId);
            logger.info("read winners by race");
        } catch (DAOException e) {
            throw new HorseRaceControllerException("Failed to get winners", e);
        }
        return clientsAndBets;
    }

    public void updateResultForRace(int raceId, int horseId, int position) throws HorseRaceControllerException {
        try {
            RaceDAO tmp = new RaceDAO();
            tmp.setHoresPositionInRace(horseId, raceId, position);
            logger.info("update race result");
        } catch (DAOException e) {
            throw new HorseRaceControllerException("Failed to get winners", e);
        }
    }

    public void addHorceToRace(int raceId, int horseId) throws HorseRaceControllerException {
        try {
            RaceDAO tmp = new RaceDAO();
            tmp.addHorseToRace(horseId, raceId);
            logger.info("added horse tp race");
        } catch (DAOException e) {
            throw new HorseRaceControllerException("Failed add horse", e);
        }
    }

}
