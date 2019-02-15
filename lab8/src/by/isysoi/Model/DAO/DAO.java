package by.isysoi.Model.DAO;

import by.isysoi.Model.DBConnector;
import by.isysoi.Model.Exception.DAOException;
import by.isysoi.Model.Exception.DBConnectionException;

/**
 * DAO abstract class
 * @author Ilya Sysoi
 * @version 1.0.0
 */
abstract class DAO {

    private DBConnector dbc;

    protected DBConnector getDBConnector() {
        return dbc;
    }

    /**
     * constructor
     * @throws DAOException if Can't create connection
     */
    protected DAO() throws DAOException {
        try {
            dbc = new DBConnector();
        } catch (DBConnectionException e) {
            throw new DAOException("Can't create DBConnector ", e);
        }
    }

}