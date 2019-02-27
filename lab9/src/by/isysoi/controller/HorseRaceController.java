package by.isysoi.controller;

import by.isysoi.model.dao.BetDAO;
import by.isysoi.model.dao.RaceDAO;
import by.isysoi.model.entity.Bet;
import by.isysoi.model.entity.Client;
import by.isysoi.model.entity.Horse;
import by.isysoi.model.entity.Race;
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

    public List<Horse> getHorsesByRaceId(int raceId) {
        List<Horse> horses;
        RaceDAO tmp = new RaceDAO();
        horses = tmp.readHorcesInRace(raceId);
        logger.info("read horses by race");
        return horses;
    }

    public List<Race> getRacesByDate(Date date) {
        List<Race> races;
        RaceDAO tmp = new RaceDAO();
        races = tmp.readRacesByDate(date);
        logger.info("read races by date");
        return races;
    }

    public List<Map.Entry<Client, Bet>> getWinnersByRaceId(int raceId) {
        List<Map.Entry<Client, Bet>> clientsAndBets;
        BetDAO tmp = new BetDAO();
        clientsAndBets = tmp.readWinnersByRace(raceId);
        logger.info("read winners by race");
        return clientsAndBets;
    }

    public void updateResultForRace(int raceId, int horseId, int position) {
        RaceDAO tmp = new RaceDAO();
        tmp.setHoresPositionInRace(horseId, raceId, position);
        logger.info("update race result");

    }

    public void addHorceToRace(int raceId, int horseId) {
        RaceDAO tmp = new RaceDAO();
        tmp.addHorseToRace(horseId, raceId);
        logger.info("added horse tp race");
    }

}
