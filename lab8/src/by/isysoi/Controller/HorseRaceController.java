package by.isysoi.Controller;

import by.isysoi.Model.DAO.RaceDAO;
import by.isysoi.Model.Entity.Client;
import by.isysoi.Model.Entity.Horse;
import by.isysoi.Model.Entity.Race;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * controller
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class HorseRaceController {

    List<Horse> getHorsesByRaceId(int raceId) throws HorseRaceControllerException {

        return  new LinkedList<>();
    }

    List<Race> getRacesByDate(Date date) throws HorseRaceControllerException {

        return  new LinkedList<>();
    }

    List<Client> getWinnersByRaceId(int raceId) throws HorseRaceControllerException {

        return  new LinkedList<>();
    }

}
