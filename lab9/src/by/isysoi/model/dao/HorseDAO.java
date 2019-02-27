package by.isysoi.model.dao;

import by.isysoi.model.entity.Horse;

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
        Horse Horses = em.createNamedQuery("readHorses", Horse.class)
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
    public void deleteHorse(Horse Horse) {
        EntityManager em = getEntityManager();
        em.createNamedQuery("deleteHorse")
                .setParameter("id", Horse.getId())
                .executeUpdate();
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

}
