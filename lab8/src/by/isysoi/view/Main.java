package by.isysoi.view;

import by.isysoi.controller.HorseRaceController;
import by.isysoi.model.exception.HorseRaceControllerException;
import by.isysoi.util.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        var controller = new HorseRaceController();
        try {
            var horses = controller.getHorsesByRaceId(1);
            Utils.printList(horses);

            SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
            var races = controller.getRacesByDate(ft.parse("11-02-2019"));
            Utils.printList(races);

            var winners = controller.getWinnersByRaceId(2);
            Utils.printListOfTuples(winners);

            controller.updateResultForRace(1, 1, 3);

        } catch (HorseRaceControllerException | ParseException e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }

    }

}
