package by.isysoi.Controller;

import by.isysoi.Model.DAO.BetDAO;
import by.isysoi.Model.DAO.RaceDAO;
import by.isysoi.Model.Entity.Bet;
import by.isysoi.Model.Entity.Client;
import by.isysoi.Model.Entity.Horse;
import by.isysoi.Model.Entity.Race;
import by.isysoi.Model.Exception.DAOException;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * controller
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class HorseRaceController {

    public List<Horse> getHorsesByRaceId(int raceId) throws HorseRaceControllerException {
        List<Horse> horses;
        try {
            RaceDAO tmp = new RaceDAO();
            horses = tmp.readHorcesInRace(raceId);
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
        } catch (DAOException e) {
            throw new HorseRaceControllerException("Failed to get winners", e);
        }
        return clientsAndBets;
    }

}
