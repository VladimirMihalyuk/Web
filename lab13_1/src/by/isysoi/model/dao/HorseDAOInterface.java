package by.isysoi.model.dao;

import by.isysoi.model.entity.Horse;

import java.util.List;

/*
 * Data Access Interface provide access to Answer class
 */
public interface HorseDAOInterface {

    List<Horse> readHorses();

    /**
     * read horse by id
     *
     * @param id id of horse
     * @return horse
     */
    Horse readHorseById(int id);

    /**
     * insert horse
     *
     * @param horse horse object
     */
    void insertHorse(Horse horse);

    /**
     * read horses in race
     *
     * @param raceId id of race
     */
    List<Horse> readHorcesInRace(int raceId);

}
