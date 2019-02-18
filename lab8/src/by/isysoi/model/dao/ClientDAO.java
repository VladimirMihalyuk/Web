package by.isysoi.model.dao;

import by.isysoi.model.entity.Client;
import by.isysoi.model.exception.DAOException;
import by.isysoi.model.exception.DBConnectionException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * client dao class
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class ClientDAO extends DAO {

    private static final String INSERT_CLIENT_SQL = "insert into client (id, FIO) values(?, ?)";

    private static final String DELETE_CLIENT_SQL = "delete from client where id = ?";

    private static final String SELECT_ALL_CLIENTS_SQL = "select * from client";

    private static final String SELECT_CLIENT_BY_ID_SQL = "select * from client where id = ?";

    /**
     * constructor
     * @throws DAOException if Can't create connection
     */
    public ClientDAO() throws DAOException {
        super();
    }

    /**
     * read clients
     * @throws DAOException if Can't execute query or problems with connection
     * @return list of clients
     */
    public List<Client> readClients() throws DAOException {
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
            logger.info("read clients");
        } catch (SQLException e) {
            throw new DAOException("Delete client exception ", e);
        } catch (DBConnectionException e) {
            throw new DAOException("Failed establish connection", e);
        } finally {
            try {
                getDBConnector().close();
            } catch (DBConnectionException e) {
                throw new DAOException("Failed close connection", e);
            }
        }
        return clients;
    }

    /**
     * read client by id
     * @throws DAOException if Can't execute query or problems with connection
     * @return client
     */
    public Client readClientById(int id) throws DAOException {
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
            logger.info("read client by id");
        } catch (SQLException e) {
            throw new DAOException("Delete client exception ", e);
        } catch (DBConnectionException e) {
            throw new DAOException("Failed establish connection", e);
        } finally {
            try {
                getDBConnector().close();
            } catch (DBConnectionException e) {
                throw new DAOException("Failed close connection", e);
            }
        }
        return client;
    }

    /**
     * insert client
     * @throws DAOException if Can't execute query or problems with connection
     */
    public void insertClient(Client client) throws DAOException {
        try {
            Connection connection = getDBConnector().getConnection();

            PreparedStatement stmt = connection.prepareStatement(INSERT_CLIENT_SQL);
            stmt.setInt(1, client.getId());
            stmt.setString(2, client.getFIO());
            stmt.execute();
            logger.info("inserted client");
        } catch (SQLException e) {
            throw new DAOException("Insert client exception ", e);
        } catch (DBConnectionException e) {
            throw new DAOException("Failed establish connection", e);
        } finally {
            try {
                getDBConnector().close();
            } catch (DBConnectionException e) {
                throw new DAOException("Failed close connection", e);
            }
        }
    }

    /**
     * deleter client
     * @throws DAOException if Can't execute query or problems with connection
     */
    public void deleteClient(Client client) throws DAOException {
        try {
            Connection connection = getDBConnector().getConnection();

            PreparedStatement stmt = connection.prepareStatement(DELETE_CLIENT_SQL);
            stmt.setInt(1, client.getId());
            stmt.execute();
            logger.info("deleted client");
        } catch (SQLException e) {
            throw new DAOException("Delete client exception ", e);
        } catch (DBConnectionException e) {
            throw new DAOException("Failed establish connection", e);
        } finally {
            try {
                getDBConnector().close();
            } catch (DBConnectionException e) {
                throw new DAOException("Failed close connection", e);
            }
        }
    }

}
