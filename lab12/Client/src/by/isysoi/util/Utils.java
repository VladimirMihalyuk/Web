package by.isysoi.util;

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
            System.out.println(element);
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
            System.out.println(element.getKey());
            System.out.println(element.getValue());
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
            System.out.println(element.getKey());
            for (K valueElement : element.getValue()) {
                System.out.println(valueElement);
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
            System.out.println(element.getKey());
            for (K valueElement : element.getValue()) {
                System.out.println(valueElement);
            }
        }
        System.out.println();
    }

}
