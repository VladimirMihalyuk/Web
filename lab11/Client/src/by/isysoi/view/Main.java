package by.isysoi.view;

import by.isysoi.controller.Controller;
import by.isysoi.model.dao.BetDAOInterface;
import by.isysoi.model.dao.ClientDAOInterface;
import by.isysoi.model.dao.HorseDAOInterface;
import by.isysoi.model.dao.RaceDAOInterface;
import by.isysoi.model.entity.Bet;
import by.isysoi.model.entity.Client;
import by.isysoi.model.entity.Horse;
import by.isysoi.model.entity.Race;
import by.isysoi.model.exception.ControllerException;
import by.isysoi.util.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.EJB;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Main
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class Main {

    @EJB(beanName = "HorseDAO")
    static HorseDAOInterface horseDAO;

    @EJB(beanName = "RaceDAO")
    static RaceDAOInterface raceDAO;

    @EJB(beanName = "ClientDAO")
    static ClientDAOInterface clientDAO;

    @EJB(beanName = "BetDAO")
    static BetDAOInterface betDAO;

    private static Logger logger = LogManager.getLogger();

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
            List<Race> races = controller.getRacesByDate(ft.parse("11-02-2019"));
            Utils.printList(races, "print races 11-02-2019");

//            controller.addHorceToRace(2, 1);

        } catch (ParseException | ControllerException e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
    }

}
