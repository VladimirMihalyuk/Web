package by.isysoi.util;

import by.isysoi.dao.Bet;
import by.isysoi.dao.Client;
import by.isysoi.dao.Horse;
import by.isysoi.dao.Race;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * helper to print lists
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class Utils {

    /**
     * print list of Genetic object
     *
     * @param list  list of some values
     * @param title some text to printed before list
     */
    public static <T extends Iterable<E>, E> void printList(T list, String title) {
        System.out.println("------------" + title + "------------");
        for (E element : list) {
            printObject(element);
        }
        System.out.println();
    }

    /**
     * print list of Map.Entry
     *
     * @param list  list of some values
     * @param title some text to printed before list
     */
    public static <T extends Iterable<Map.Entry<E, K>>, E, K> void printListOfTuples(T list, String title) {
        System.out.println("------------" + title + "------------");
        for (Map.Entry<E, K> element : list) {
            printObject(element.getKey());
            printObject(element.getValue());
        }
        System.out.println();
    }

    /**
     * print map with list as value
     *
     * @param map   map of some values
     * @param title some text to printed before list
     */
    public static <E, K> void printMapWithList(Map<E, Collection<K>> map, String title) {
        System.out.println("------------" + title + "------------");
        for (Map.Entry<E, Collection<K>> element : map.entrySet()) {
            printObject(element.getKey());
            for (K valueElement : element.getValue()) {
                printObject(valueElement);
            }
        }
        System.out.println();
    }

    /**
     * print map with set as value
     *
     * @param map   map of some values
     * @param title some text to printed before list
     */
    public static <E, K> void printMapWithSet(Map<E, Set<K>> map, String title) {
        System.out.println("------------" + title + "------------");
        for (Map.Entry<E, Set<K>> element : map.entrySet()) {
            printObject(element.getKey());
            for (K valueElement : element.getValue()) {
                printObject(valueElement);
            }
        }
        System.out.println();
    }

    public static void printHorse(Horse horse) {
        String output = String.format("Horse:" +
                        "\n\tid - %s" +
                        "\n\tnikname - %s",
                horse.getId(), horse.getNikname());
        System.out.println(output);

    }

    public static void printRace(Race race) {
        String output = String.format("Race:" +
                        "\n\tid - %s" +
                        "\n\tdistance - %.2f" +
                        "\n\tdate - %s",
                race.getId(), race.getDistance(), race.getRaceDate());
        System.out.println(output);
    }

    public static void printClient(Client client) {
        String output = String.format("Client:" +
                        "\n\tid - %s" +
                        "\n\tfio - %s",
                client.getId(), client.getFIO());
        System.out.println(output);
    }

    public static void printBet(Bet bet) {
        String output = String.format("Bet:" +
                        "\n\tid - %ы" +
                        "\n\tamount - %.2f" +
                        "\n\thorseId - %s" +
                        "\n\tclientId - %s" +
                        "\n\traceId - %s",
                bet.getId(), bet.getAmount(), ((Horse) bet.getHorse()).getId(), ((Client) bet.getClient()).getId(), ((Race) bet.getRace()).getId());
        System.out.println(output);
    }

    public static <T> void printObject(T object) {
        if (object instanceof Client) {
            printClient((Client) object);
        } else if (object instanceof Horse) {
            printHorse((Horse) object);
        } else if (object instanceof Bet) {
            printBet((Bet) object);
        } else if (object instanceof Race) {
            printRace((Race) object);
        } else {
            System.out.println(object);
        }
    }

}
