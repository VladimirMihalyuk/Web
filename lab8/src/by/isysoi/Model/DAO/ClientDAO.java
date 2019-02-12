package by.isysoi.Model.DAO;

import by.isysoi.Model.Entity.Client;
import by.isysoi.Model.Exception.DAOException;
import by.isysoi.Model.Exception.DBConnectionException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientDAO extends DAO {

    private static final String INSERT_CLIENT_SQL = "insert into client (FIO) values(?)";


    public ClientDAO() throws DAOException {
        super();
    }

    public void insertClient(Client client) throws DAOException {
        try {
            Connection connection = getDBConnector().getConnection();

            PreparedStatement stmt = connection.prepareStatement(INSERT_CLIENT_SQL);
            stmt.setString(1, client.getFIO());
            stmt.execute();

            getDBConnector().close();
        } catch (SQLException e) {
            throw new DAOException("Insert question exception ", e);
        } catch (DBConnectionException e) {
            throw new DAOException("coonection", e);
        }

    }

}
