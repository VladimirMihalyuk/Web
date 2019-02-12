package by.isysoi.Model.DAO;

import by.isysoi.Model.DBConnector;
import by.isysoi.Model.Exception.DAOException;
import by.isysoi.Model.Exception.DBConnectionException;

public class DAO {

    protected DBConnector dbc;

    public DAO() throws DAOException {
        try {
            dbc = new DBConnector();
        } catch (DBConnectionException e) {
            throw new DAOException("Can't create DBConnector ", e);
        }
    }

    public DBConnector getDBConnector() {
        return dbc;
    }
}