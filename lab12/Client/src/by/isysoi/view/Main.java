package by.isysoi.view;

import by.isysoi.controller.Controller;
import by.isysoi.dao.*;
import by.isysoi.util.Utils;

import javax.xml.ws.WebServiceRef;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Main
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class Main {

    @WebServiceRef(wsdlLocation = "http://desktop-03g58vn:8080/Server_lab12_war_exploded/HorseDAOService?wsdl")
    private static HorseDAOService horseDAOService;

    @WebServiceRef(wsdlLocation = "http://desktop-03g58vn:8080/Server_lab12_war_exploded/RaceDAOService?wsdl")
    private static RaceDAOService raceDAOService;

    @WebServiceRef(wsdlLocation = "http://desktop-03g58vn:8080/Server_lab12_war_exploded/BetDAOService?wsdl")
    private static BetDAOService betDAOService;

    @WebServiceRef(wsdlLocation = "http://desktop-03g58vn:8080/Server_lab12_war_exploded/ClientDAOService?wsdl")
    private static ClientDAOService clientDAOService;

    public static void main(String[] args) {
        Controller controller = new Controller(horseDAOService.getHorseDAOPort(),
                raceDAOService.getRaceDAOPort(),
                clientDAOService.getClientDAOPort(),
                betDAOService.getBetDAOPort());
        try {

            List<Horse> horses = controller.getHorsesByRaceId(1);
            Utils.printList(horses, "printing horses from race with id = 1");

            List<Client> winners = controller.getWinnersByRaceId(1);
            Utils.printList(winners, "print winners from race 1");

            controller.updateResultForRace(1, 1, 1);
            Utils.printList(new ArrayList<>(), "updated horse 1 in race 1 to 1 position ");

            SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
            Date date = ft.parse("11-02-2019");
            List<Race> races = controller.getRacesByDate(date);
            Utils.printList(races, "print races 11-02-2019");

            //controller.addHorceToRace(2, 1);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
