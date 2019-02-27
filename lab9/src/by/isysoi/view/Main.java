package by.isysoi.view;

import by.isysoi.controller.HorseRaceController;
import by.isysoi.model.dao.BetDAO;
import by.isysoi.model.dao.ClientDAO;
import by.isysoi.model.dao.HorseDAO;
import by.isysoi.model.dao.RaceDAO;
import by.isysoi.util.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        var controller = new HorseRaceController();

//        var horses = controller.getHorsesByRaceId(1);
//        Utils.printList(horses);
//        var winners = controller.getWinnersByRaceId(2);
//        Utils.printListOfTuples(winners);
//
//        controller.updateResultForRace(1, 1, 3);
//
//        controller.addHorceToRace(3, 1);
//
//        try {
//
//
//            SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
//            var races = controller.getRacesByDate(ft.parse("11-02-2019"));
//            Utils.printList(races);
//
//
//
//        } catch (ParseException e) {
//            logger.error(e.getMessage(), e);
//            e.printStackTrace();
//        }

        var tmp = new ClientDAO();
        Utils.printList(tmp.readClients());
        System.out.println(tmp.readClientById(1));
//        var client = new Client();
//        client.setFIO("dsdswwwa 2211");
//        client.setId(5);
//        tmp.insertClient(client);

        var tmp1 = new HorseDAO();
        Utils.printList(tmp1.readHorses());
        System.out.println(tmp1.readHorseById(1));

        var tmp2 = new RaceDAO();
        Utils.printList(tmp2.readRaces());
        SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Utils.printList(tmp2.readRacesByDate(ft.parse("11-02-2019")));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(tmp2.readRaceById(1));
//        Utils.printList(tmp2.readHorcesInRace(1));


        var tmp3 = new BetDAO();
        Utils.printList(tmp3.readBet());
        System.out.println(tmp3.readBetById(1));
//        Utils.printList(tmp3.readWinnersByRace(1));
    }

}
