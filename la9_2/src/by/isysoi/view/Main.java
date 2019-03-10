package by.isysoi.view;

import by.isysoi.controller.HorseRaceController;
import by.isysoi.model.exception.HorseRaceControllerException;
import by.isysoi.util.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


/**
 * Main
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class Main {

    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        var controller = new HorseRaceController();
        try {

            var horses = controller.getHorsesByRaceId(1);
            Utils.printList(horses, "printing horses from race with id = 1");

            var winners = controller.getWinnersByRaceId(1);
            Utils.printMapWithList(winners, "print winners from race 1");

            controller.updateResultForRace(1, 1, 1);
            Utils.printList(new ArrayList<>(), "updated horse 1 in race 1 to 1 position ");

            SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
            var races = controller.getRacesByDate(ft.parse("11-02-2019"));
            Utils.printList(races, "print races 11-02-2019");

//            controller.addHorceToRace(2, 1);

        } catch (ParseException | HorseRaceControllerException e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
    }

}
