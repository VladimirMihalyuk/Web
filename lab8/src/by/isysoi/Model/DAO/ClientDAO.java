package by.isysoi.Model.DAO;

import by.isysoi.Model.Entity.Client;
import by.isysoi.Model.Exception.DAOException;
import by.isysoi.Model.Exception.DBConnectionException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO extends DAO {

    private static final String INSERT_CLIENT_SQL = "insert into client (FIO) values(?)";

    private static final String DELETE_CLIENT_SQL = "delete from client where id = ?";

    private static final String SELECT_ALL_CLIENTS_SQL = "select * from client";

    private static final String SELECT_CLIENT_BY_ID_SQL = "select * from client where id = ?";

    public ClientDAO() throws DAOException {
        super();
    }

    public List<Client> selectClients() throws DAOException {
        List<Client> clients = new ArrayList<Client>();
        try {
            Connection connection = getDBConnector().getConnection();

            PreparedStatement stmt = connection.prepareStatement(SELECT_ALL_CLIENTS_SQL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String FIO = rs.getString(2);
                Client client = new Client(id, FIO);
                clients.add(client);
            }
            getDBConnector().close();
        } catch (SQLException e) {
            throw new DAOException("Delete client exception ", e);
        } catch (DBConnectionException e) {
            throw new DAOException("coonection", e);
        }
        return clients;
    }

    public Client selectClientById(int id) throws DAOException {
        Client client = null;
        try {
            Connection connection = getDBConnector().getConnection();

            PreparedStatement stmt = connection.prepareStatement(SELECT_CLIENT_BY_ID_SQL);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String FIO = rs.getString(2);
                client = new Client(id, FIO);
            }
            getDBConnector().close();
        } catch (SQLException e) {
            throw new DAOException("Delete client exception ", e);
        } catch (DBConnectionException e) {
            throw new DAOException("coonection", e);
        }
        return client;
    }

    public void insertClient(Client client) throws DAOException {
        try {
            Connection connection = getDBConnector().getConnection();

            PreparedStatement stmt = connection.prepareStatement(INSERT_CLIENT_SQL);
            stmt.setString(1, client.getFIO());
            stmt.execute();

            getDBConnector().close();
        } catch (SQLException e) {
            throw new DAOException("Insert client exception ", e);
        } catch (DBConnectionException e) {
            throw new DAOException("coonection", e);
        }

    }

    public void deleteClient(Client client) throws DAOException {
        try {
            Connection connection = getDBConnector().getConnection();

            PreparedStatement stmt = connection.prepareStatement(DELETE_CLIENT_SQL);
            stmt.setInt(1, client.getId());
            stmt.execute();

            getDBConnector().close();
        } catch (SQLException e) {
            throw new DAOException("Delete client exception ", e);
        } catch (DBConnectionException e) {
            throw new DAOException("coonection", e);
        }

    }

}
