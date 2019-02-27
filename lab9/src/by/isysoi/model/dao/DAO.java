package by.isysoi.model.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * dao abstract class
 * @author Ilya Sysoi
 * @version 1.0.0
 */
abstract class DAO {

    protected Logger logger = LogManager.getLogger("dao_layer");

    private EntityManager entityManager;

    /**
     * constructor
     */
    protected DAO() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestSystem");
        entityManager = entityManagerFactory.createEntityManager();
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

}