package by.isysoi.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * dao abstract class
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
abstract class DAO {

    private static String PERSISTENCE_UNIT_NAME = "Test_Local";

    protected Logger logger = LogManager.getLogger("dao_layer");

    private EntityManagerFactory factory;

    /**
     * DAO constructor
     */
    protected DAO() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        logger.info("Entity Manager Factory created " + PERSISTENCE_UNIT_NAME);
    }

    protected EntityManagerFactory getEntityManagerFactory() {
        return factory;
    }

}