package by.isysoi.model.dao;

import by.isysoi.model.DBConnector;
import by.isysoi.model.exception.DAOException;
import by.isysoi.model.exception.DBConnectionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * dao abstract class
 * @author Ilya Sysoi
 * @version 1.0.0
 */
abstract class DAO {

    private DBConnector dbc;

    protected DBConnector getDBConnector() {
        logger.info("requested to db connector");
        return dbc;
    }

    protected Logger logger = LogManager.getLogger("dao_layer");

    /**
     * constructor
     * @throws DAOException if Can't create connection
     */
    protected DAO() throws DAOException {
        try {
            dbc = new DBConnector();
            logger.info("Connection to database from dao inited");
        } catch (DBConnectionException e) {
            throw new DAOException("Can't create DBConnector ", e);
        }
    }

}