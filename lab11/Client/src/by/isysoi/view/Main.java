package by.isysoi.view;

import by.isysoi.controller.Controller;
import by.isysoi.entity.*;
import by.isysoi.dao.*;
import by.isysoi.util.Utils;

import javax.ejb.EJB;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Main
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class Main {

    @EJB(beanName = "HorseDAO")
    static HorseDAOInterface horseDAO;

    @EJB
    static RaceDAOInterface raceDAO;

    @EJB
    static ClientDAOInterface clientDAO;

    @EJB
    static BetDAOInterface betDAO;

    //private static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        Controller controller = new Controller(horseDAO,
                raceDAO,
                clientDAO,
                betDAO);
        try {

            List<Horse> horses = controller.getHorsesByRaceId(1);
            Utils.printList(horses, "printing horses from race with id = 1");

            Map<Client, Set<Bet>> winners = controller.getWinnersByRaceId(1);
            Utils.printMapWithSet(winners, "print winners from race 1");

            controller.updateResultForRace(1, 1, 1);
            Utils.printList(new ArrayList<>(), "updated horse 1 in race 1 to 1 position ");

            SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
            Date date = ft.parse("11-02-2019");
            List<Race> races = controller.getRacesByDate(date);
            Utils.printList(races, "print races 11-02-2019");

            controller.addHorceToRace(2, 1);

        } catch (ParseException e) {
//            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
    }

}
