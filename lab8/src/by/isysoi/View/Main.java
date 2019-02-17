package by.isysoi.View;

import by.isysoi.Controller.HorseRaceController;
import by.isysoi.Controller.HorseRaceControllerException;
import by.isysoi.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

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

        } catch (HorseRaceControllerException | ParseException e) {
            e.printStackTrace();
        }

    }

}
