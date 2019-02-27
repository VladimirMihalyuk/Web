package by.isysoi.model.dao;

import by.isysoi.model.entity.Horse;
import by.isysoi.model.entity.Race;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * race dao class
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class RaceDAO extends DAO {

    /**
     * constructor
     *
     */
    public RaceDAO() {
        super();
    }

    /**
     * read races
     *
     * @return list of races
     */
    public List<Race> readRaces() {
        EntityManager em = getEntityManager();
        List races = em.createNamedQuery("readRaces").getResultList();
        return races;
    }

    /**
     * read race by id
     *
     * @return race
     */
    public Race readRaceById(int id) {
        EntityManager em = getEntityManager();
        Race race = em.createNamedQuery("readRace", Race.class)
                .setParameter("id", id)
                .getSingleResult();
        return race;
    }

    /**
     * insert race
     */
    public void insertRace(Race Race) {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(Race);
        transaction.commit();
    }

    /**
     * delete race
     *
     */
    public void deleteRace(Race race) {
        EntityManager em = getEntityManager();
        em.createNamedQuery("deleteRace")
                .setParameter("id", race.getId())
                .executeUpdate();
    }

    /**
     * delete races
     */
    public void deleteRaces() {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.createNamedQuery("deleteRaces").executeUpdate();
        transaction.commit();
    }

    /**
     * read horses in race
     *
     */
    public List<Horse> readHorcesInRace(int raceId) {
        EntityManager em = getEntityManager();
        List<Horse> horses = em.createNamedQuery("readHorsesInRace", Horse.class)
                .setParameter("id", raceId)
                .getResultList();
        return horses;
    }

    /**
     * read races by date
     *
     */
    public List<Race> readRacesByDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR_OF_DAY, 3);


        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        List races = em.createNamedQuery("readRaceByDate")
                .setParameter("raceDate", cal.getTime())
                .getResultList();

        return races;
    }

//    public void addHorseToRace(int horseId, int raceId) {
//        EntityManager em = getEntityManager();
//        em.createNamedQuery("addHorseToRace")
//                .setParameter("horseId", horseId)
//                .setParameter("raceId", raceId)
//                .executeUpdate();
//    }

    public void setHoresPositionInRace(int horseId, int raceId, int position) {
        EntityManager em = getEntityManager();
        em.createNamedQuery("updateHorsePosition")
                .setParameter("horseId", horseId)
                .setParameter("raceId", raceId)
                .setParameter("position", position)
                .executeUpdate();
    }

}
