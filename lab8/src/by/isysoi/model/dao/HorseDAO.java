package by.isysoi.model.dao;

import by.isysoi.model.entity.Horse;
import by.isysoi.model.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * horse dao class
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class HorseDAO extends DAO {

    private static final String INSERT_HORSE_SQL = "insert into horse (id, nikname) values(?, ?)";

    private static final String DELETE_HORSE_SQL = "delete from horse where id = ?";

    private static final String SELECT_ALL_HORSE_SQL = "select * from horse";

    private static final String SELECT_HORSE_BY_ID_SQL = "select * from horse where id = ?";

    /**
     * constructor
     *
     * @throws DAOException if Can't create connection
     */
    public HorseDAO() throws DAOException {
        super();
    }

    /**
     * read horses
     *
     * @return list of horses
     * @throws DAOException if Can't execute query or problems with connection
     */
    public List<Horse> readHorse() throws DAOException {
        List<Horse> clients = new ArrayList<Horse>();
        Connection connection = getDBConnector().getConnection();
        try {

            PreparedStatement stmt = connection.prepareStatement(SELECT_ALL_HORSE_SQL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String nikname = rs.getString(2);
                Horse horse = new Horse(id, nikname);
                clients.add(horse);
            }
            logger.info("read horsed");
        } catch (SQLException e) {
            throw new DAOException("Delete horse exception ", e);
        } finally {
            getDBConnector().releaseConnection(connection);
        }
        return clients;
    }

    /**
     * read horse by id
     *
     * @return horse
     * @throws DAOException if Can't execute query or problems with connection
     */
    public Horse readHorseById(int id) throws DAOException {
        Horse horse = null;
        Connection connection = getDBConnector().getConnection();
        try {

            PreparedStatement stmt = connection.prepareStatement(SELECT_HORSE_BY_ID_SQL);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String niknmame = rs.getString(2);
                horse = new Horse(id, niknmame);
            }
            logger.info("read horse by id");
        } catch (SQLException e) {
            throw new DAOException("Delete horse exception ", e);
        } finally {
            getDBConnector().releaseConnection(connection);
        }
        return horse;
    }

    /**
     * insert horse
     *
     * @throws DAOException if Can't execute query or problems with connection
     */
    public void insertHorse(Horse horse) throws DAOException {
        Connection connection = getDBConnector().getConnection();
        try {

            PreparedStatement stmt = connection.prepareStatement(INSERT_HORSE_SQL);
            stmt.setInt(1, horse.getId());
            stmt.setString(2, horse.getNikname());
            stmt.execute();
            logger.info("inserted horse");
        } catch (SQLException e) {
            throw new DAOException("Insert horse exception ", e);
        } finally {
            getDBConnector().releaseConnection(connection);
        }

    }

    /**
     * delete horse
     *
     * @throws DAOException if Can't execute query or problems with connection
     */
    public void deleteHorse(Horse horse) throws DAOException {
        Connection connection = getDBConnector().getConnection();
        try {

            PreparedStatement stmt = connection.prepareStatement(DELETE_HORSE_SQL);
            stmt.setInt(1, horse.getId());
            stmt.execute();
            logger.info("deleted horse");
        } catch (SQLException e) {
            throw new DAOException("Delete horse exception ", e);
        } finally {
            getDBConnector().releaseConnection(connection);
        }

    }

}
