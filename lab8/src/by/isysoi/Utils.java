package by.isysoi;

import by.isysoi.Model.Entity.Bet;
import by.isysoi.Model.Entity.Client;

import java.util.Map;

public class Utils {

    public static <T extends Iterable<E>, E> void printList(T list) {
        for (E element : list) {
            System.out.println(element);
        }
    }


    public static <T extends Iterable<Map.Entry<E, K>>, E, K> void printListOfTuples(T list) {
        for (Map.Entry<E, K> element : list) {
            System.out.println(element.getKey());
            System.out.println(element.getValue());
        }
    }

}
