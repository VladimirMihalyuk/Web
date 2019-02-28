package by.isysoi.model.dao;

import by.isysoi.model.entity.Horse;
import by.isysoi.model.entity.Race;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * horse dao class
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class HorseDAO extends DAO {

    /**
     * constructor
     *
     */
    public HorseDAO() {
        super();
    }

    /**
     * read horses
     *
     * @return list of horses
     */
    public List<Horse> readHorses() {
        EntityManager em = getEntityManager();
        List Horses = em.createNamedQuery("readHorses").getResultList();
        return Horses;
    }

    /**
     * read horse by id
     *
     * @return horse
     */
    public Horse readHorseById(int id) {
        EntityManager em = getEntityManager();

        Horse Horses = em.createNamedQuery("readHorse", Horse.class)
                .setParameter("id", id)
                .getSingleResult();
        return Horses;
    }

    /**
     * insert horse
     *
     */
    public void insertHorse(Horse horse) {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(horse);
        transaction.commit();
    }

    /**
     * delete horse
     *
     */
    public void deleteHorse(int id) {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.createNamedQuery("deleteHorse")
                .setParameter("id", id)
                .executeUpdate();
        transaction.commit();
    }

    /**
     * delete Horses
     */
    public void deleteHorses() {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.createNamedQuery("deleteHorses").executeUpdate();
        transaction.commit();
    }

    /**
     * read horses in race
     */
    public List<Horse> readHorcesInRace(int raceId) {
        EntityManager em = getEntityManager();
        List<Horse> horses = em.createNamedQuery("readRace", Race.class)
                .setParameter("id", raceId)
                .getSingleResult().horses;
        return horses;
    }


}
