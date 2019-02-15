package by.isysoi.Model.DAO;

import by.isysoi.Model.Entity.Race;
import by.isysoi.Model.Exception.DAOException;
import by.isysoi.Model.Exception.DBConnectionException;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * race dao class
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class RaceDAO extends DAO {

    private static final String INSERT_RACE_SQL = "insert into race (id, distance, race_date) values(?, ?, ?)";

    private static final String DELETE_RACE_SQL = "delete from race where id = ?";

    private static final String SELECT_ALL_RACES_SQL = "select * from race";

    private static final String SELECT_RACE_BY_ID_SQL = "select * from race where id = ?";

    /**
     * constructor
     * @throws DAOException if Can't create connection
     */
    public RaceDAO() throws DAOException {
        super();
    }

    /**
     * read races
     * @throws DAOException if Can't execute query or problems with connection
     * @return list of races
     */
    public List<Race> readRace() throws DAOException {
        List<Race> races = new ArrayList<Race>();
        try {
            Connection connection = getDBConnector().getConnection();

            PreparedStatement stmt = connection.prepareStatement(SELECT_ALL_RACES_SQL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                double distance = rs.getDouble(2);
                Date raceDate = rs.getDate(3);
                Race race = new Race(id, distance, raceDate);
                races.add(race);
            }
            connection.close();
        } catch (SQLException e) {
            throw new DAOException("Delete Race exception ", e);
        } catch (DBConnectionException e) {
            throw new DAOException("Failed establish connection", e);
        }
        return races;
    }

    /**
     * read race by id
     * @throws DAOException if Can't execute query or problems with connection
     * @return race
     */
    public Race selectRaceById(int id) throws DAOException {
        Race Race = null;
        try {
            Connection connection = getDBConnector().getConnection();

            PreparedStatement stmt = connection.prepareStatement(SELECT_RACE_BY_ID_SQL);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                double distance = rs.getDouble(2);
                Date raceDate = rs.getDate(3);
                Race = new Race(id, distance, raceDate);
            }
            connection.close();
        } catch (SQLException e) {
            throw new DAOException("Delete Race exception ", e);
        } catch (DBConnectionException e) {
            throw new DAOException("Failed establish connection", e);
        }
        return Race;
    }

    /**
     * insert race
     * @throws DAOException if Can't execute query or problems with connection
     */
    public void insertRace(Race Race) throws DAOException {
        try {
            Connection connection = getDBConnector().getConnection();

            PreparedStatement stmt = connection.prepareStatement(INSERT_RACE_SQL);
            stmt.setInt(1, Race.getId());
            stmt.setDouble(2, Race.getDistance());
            java.sql.Date sqlDate = java.sql.Date.valueOf(Race.getRaceDate().toString());
            stmt.setDate(3, sqlDate);
            stmt.execute();

            connection.close();
        } catch (SQLException e) {
            throw new DAOException("Insert Race exception ", e);
        } catch (DBConnectionException e) {
            throw new DAOException("Failed establish connection", e);
        }

    }

    /**
     * delete race
     * @throws DAOException if Can't execute query or problems with connection
     */
    public void deleteRace(Race Race) throws DAOException {
        try {
            Connection connection = getDBConnector().getConnection();

            PreparedStatement stmt = connection.prepareStatement(DELETE_RACE_SQL);
            stmt.setInt(1, Race.getId());
            stmt.execute();

            connection.close();
        } catch (SQLException e) {
            throw new DAOException("Delete Race exception ", e);
        } catch (DBConnectionException e) {
             throw new DAOException("Failed establish connection", e);
        }

    }


}
