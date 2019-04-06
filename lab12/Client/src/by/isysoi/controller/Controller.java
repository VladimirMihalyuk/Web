package by.isysoi.controller;

import by.isysoi.dao.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * controller
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class Controller {

    private HorseDAO horseDAO;
    private RaceDAO raceDAO;
    private ClientDAO clientDAO;
    private BetDAO betDAO;

    public Controller(HorseDAO _horseDAO,
                      RaceDAO _raceDAO,
                      ClientDAO _clientDAO,
                      BetDAO _betDAO) {
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
        List<Race> races = null;
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(date);
        try {
            races = raceDAO.readRacesByDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();

        }
        return races;
    }

    /**
     * get clients and theier bets
     *
     * @param raceId id of race
     * @return map client and bets
     */
    public List<Client> getWinnersByRaceId(int raceId) {
        List clientsAndBets;
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
