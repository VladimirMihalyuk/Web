package by.isysoi.view;

import by.isysoi.controller.HorseRaceController;
import by.isysoi.model.exception.HorseRaceControllerException;
import by.isysoi.util.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;


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

/*
------------printing horses from race with id = 1------------
Horse:
	id - 1
	nikname - nik1
Horse:
	id - 3
	nikname - nik3

------------print winners from race 1------------
Client:
	id - 1
	fio - TEST1
Bet:
	id - 1
	amount - 12,00
	horseId - 1
	clientId - 1
	raceId - 1
Bet:
	id - 2
	amount - 2,00
	horseId - 3
	clientId - 1
	raceId - 1
Bet:
	id - 3
	amount - 6,00
	horseId - 1
	clientId - 1
	raceId - 1
Bet:
	id - 5
	amount - 21,00
	horseId - 3
	clientId - 1
	raceId - 1

------------print races 11-02-2019------------
Race:
	id - 1
	distance - 23,40
	date - 11-02-2019
Race:
	id - 3
	distance - 53,50
	date - 11-02-2019


Process finished with exit code 0



 */