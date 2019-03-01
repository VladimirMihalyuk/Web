package by.isysoi.model.dao;

import by.isysoi.model.entity.Race;
import by.isysoi.model.entity.RaceInfo;
import by.isysoi.model.exception.DAOException;

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
    public List<Race> readRaces() throws DAOException {
        EntityManager em = getEntityManager();
        List races = em.createNamedQuery("readRaces").getResultList();
        return races;
    }

    /**
     * read race by id
     *
     * @return race
     */
    public Race readRaceById(int id) throws DAOException {
        EntityManager em = getEntityManager();
        Race race = em.createNamedQuery("readRace", Race.class)
                .setParameter("id", id)
                .getSingleResult();
        return race;
    }

    /**
     * insert race
     */
    public void insertRace(Race Race) throws DAOException {
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
    public void deleteRace(int id) throws DAOException {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.createNamedQuery("deleteRace")
                .setParameter("id", id)
                .executeUpdate();
        transaction.commit();
    }

    /**
     * delete races
     */
    public void deleteRaces() throws DAOException {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.createNamedQuery("deleteRaces").executeUpdate();
        transaction.commit();
    }

    /**
     * read races by date
     *
     */
    public List<Race> readRacesByDate(Date date) throws DAOException {
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

    public void addHorseToRace(int horseId, int raceId) throws DAOException {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        var raceInfo = new RaceInfo();
        raceInfo.setHorseId(horseId);
        raceInfo.setRaceId(raceId);
        raceInfo.setPosition(null);

        transaction.begin();
        em.persist(raceInfo);
        transaction.commit();
    }


    public void setHoresPositionInRace(int horseId, int raceId, int position) throws DAOException {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.createNamedQuery("updateHorsePosition")
                .setParameter("horseId", horseId)
                .setParameter("raceId", raceId)
                .setParameter("position", position)
                .executeUpdate();
        transaction.commit();
    }

}
