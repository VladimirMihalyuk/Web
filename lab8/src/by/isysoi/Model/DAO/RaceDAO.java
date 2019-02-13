package by.isysoi.Model.DAO;

import by.isysoi.Model.Entity.Race;
import by.isysoi.Model.Exception.DAOException;
import by.isysoi.Model.Exception.DBConnectionException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RaceDAO extends DAO {

    private static final String INSERT_RACE_SQL = "insert into race (distance) values(?)";

    private static final String DELETE_RACE_SQL = "delete from race where id = ?";

    private static final String SELECT_ALL_RACES_SQL = "select * from race";

    private static final String SELECT_RACE_BY_ID_SQL = "select * from race where id = ?";

    public RaceDAO() throws DAOException {
        super();
    }

    public List<Race> selectRace() throws DAOException {
        List<Race> races = new ArrayList<Race>();
        try {
            Connection connection = getDBConnector().getConnection();

            PreparedStatement stmt = connection.prepareStatement(SELECT_ALL_RACES_SQL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                double distance = rs.getDouble(2);
                Race race = new Race(id, distance);
                races.add(race);
            }
            getDBConnector().close();
        } catch (SQLException e) {
            throw new DAOException("Delete Race exception ", e);
        } catch (DBConnectionException e) {
            throw new DAOException("coonection", e);
        }
        return races;
    }

    public Race selectRaceById(int id) throws DAOException {
        Race Race = null;
        try {
            Connection connection = getDBConnector().getConnection();

            PreparedStatement stmt = connection.prepareStatement(SELECT_RACE_BY_ID_SQL);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                double distance = rs.getDouble(2);
                Race = new Race(id, distance);
            }
            getDBConnector().close();
        } catch (SQLException e) {
            throw new DAOException("Delete Race exception ", e);
        } catch (DBConnectionException e) {
            throw new DAOException("coonection", e);
        }
        return Race;
    }

    public void insertRace(Race Race) throws DAOException {
        try {
            Connection connection = getDBConnector().getConnection();

            PreparedStatement stmt = connection.prepareStatement(INSERT_RACE_SQL);
            stmt.setDouble(1, Race.getDistance());
            stmt.execute();

            getDBConnector().close();
        } catch (SQLException e) {
            throw new DAOException("Insert Race exception ", e);
        } catch (DBConnectionException e) {
            throw new DAOException("coonection", e);
        }

    }

    public void deleteClient(Race Race) throws DAOException {
        try {
            Connection connection = getDBConnector().getConnection();

            PreparedStatement stmt = connection.prepareStatement(DELETE_RACE_SQL);
            stmt.setInt(1, Race.getId());
            stmt.execute();

            getDBConnector().close();
        } catch (SQLException e) {
            throw new DAOException("Delete Race exception ", e);
        } catch (DBConnectionException e) {
            throw new DAOException("coonection", e);
        }

    }


}
