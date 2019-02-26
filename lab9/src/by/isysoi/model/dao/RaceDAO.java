package by.isysoi.model.dao;

import by.isysoi.model.entity.Horse;
import by.isysoi.model.entity.Race;
import by.isysoi.model.exception.DAOException;
import by.isysoi.model.exception.DBConnectionException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * race dao class
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class RaceDAO extends DAO {

    private static final String INSERT_RACE_SQL = "insert into race (id, distance, race_date) values(?, ?, ?)";

    private static final String DELETE_RACE_SQL = "delete from race where id = ?";

    private static final String SELECT_ALL_RACES_SQL = "select * from race";

    private static final String SELECT_RACE_BY_ID_SQL = "select * from race where id = ?";

    private static final String SELECT_HORSES_IN_RACE_SQL = "select h.id, h.nikname from race r join race_info on race_id = r.id join horse h on horse_id = h.id where r.id = ?";

    private static final String SELECT_RACE_BY_DATE_SQL = "select * from race where race_date = ?";

    private static final String ADD_HORSE_TO_RACE_SQL = "insert into race_info (horse_id, race_id) values(?, ?)";

    private static final String UPDATE_HORSE_POSITION_IN_RACE_SQL = "update race_info set position = ? where race_id = ? and horse_id = ?";

    /**
     * constructor
     *
     * @throws DAOException if Can't create connection
     */
    public RaceDAO() throws DAOException {
        super();
    }

    /**
     * read races
     *
     * @return list of races
     * @throws DAOException if Can't execute query or problems with connection
     */
    public List<Race> readRace() throws DAOException {
        List<Race> races = new ArrayList<Race>();
         Connection connection = null;
        try {
            connection = getDBConnector().getConnection();
            PreparedStatement stmt = connection.prepareStatement(SELECT_ALL_RACES_SQL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                double distance = rs.getDouble(2);
                Date raceDate = rs.getDate(3);
                Race race = new Race(id, distance, raceDate);
                races.add(race);
            }
            logger.info("read races");
        } catch (SQLException e) {
            throw new DAOException("Delete Race exception ", e);
        } catch (DBConnectionException e) {
            throw new DAOException("Faild to get connection from db connector ", e);
        } finally {
            if (connection != null) {
                try {
                    getDBConnector().releaseConnection(connection);
                } catch (DBConnectionException e) {
                    throw new DAOException("Failed to return connection to db connector ", e);
                }
            }
        }
        return races;
    }

    /**
     * read race by id
     *
     * @return race
     * @throws DAOException if Can't execute query or problems with connection
     */
    public Race selectRaceById(int id) throws DAOException {
        Race Race = null;
         Connection connection = null;
        try {
            connection = getDBConnector().getConnection();
            PreparedStatement stmt = connection.prepareStatement(SELECT_RACE_BY_ID_SQL);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                double distance = rs.getDouble(2);
                Date raceDate = rs.getDate(3);
                Race = new Race(id, distance, raceDate);
            }
            logger.info("read race by id");
        } catch (SQLException e) {
            throw new DAOException("Delete Race exception ", e);
        } catch (DBConnectionException e) {
            throw new DAOException("Faild to get connection from db connector ", e);
        } finally {
            if (connection != null) {
                try {
                    getDBConnector().releaseConnection(connection);
                } catch (DBConnectionException e) {
                    throw new DAOException("Failed to return connection to db connector ", e);
                }
            }
        }
        return Race;
    }

    /**
     * insert race
     *
     * @throws DAOException if Can't execute query or problems with connection
     */
    public void insertRace(Race Race) throws DAOException {
         Connection connection = null;
        try {
            connection = getDBConnector().getConnection();
            PreparedStatement stmt = connection.prepareStatement(INSERT_RACE_SQL);
            stmt.setInt(1, Race.getId());
            stmt.setDouble(2, Race.getDistance());
            java.sql.Date sqlDate = java.sql.Date.valueOf(Race.getRaceDate().toString());
            stmt.setDate(3, sqlDate);
            stmt.execute();
            logger.info("inserted race");
        } catch (SQLException e) {
            throw new DAOException("Insert Race exception ", e);
        } catch (DBConnectionException e) {
            throw new DAOException("Faild to get connection from db connector ", e);
        } finally {
            if (connection != null) {
                try {
                    getDBConnector().releaseConnection(connection);
                } catch (DBConnectionException e) {
                    throw new DAOException("Failed to return connection to db connector ", e);
                }
            }
        }
    }

    /**
     * delete race
     *
     * @throws DAOException if Can't execute query or problems with connection
     */
    public void deleteRace(Race Race) throws DAOException {
         Connection connection = null;
        try {
            connection = getDBConnector().getConnection();
            PreparedStatement stmt = connection.prepareStatement(DELETE_RACE_SQL);
            stmt.setInt(1, Race.getId());
            stmt.execute();
            logger.info("deleted races");
        } catch (SQLException e) {
            throw new DAOException("Delete Race exception ", e);
        } catch (DBConnectionException e) {
            throw new DAOException("Faild to get connection from db connector ", e);
        } finally {
            if (connection != null) {
                try {
                    getDBConnector().releaseConnection(connection);
                } catch (DBConnectionException e) {
                    throw new DAOException("Failed to return connection to db connector ", e);
                }
            }
        }
    }

    /**
     * read horses in race
     *
     * @throws DAOException if Can't execute query or problems with connection
     */
    public List<Horse> readHorcesInRace(int raceId) throws DAOException {
        List<Horse> horses = new ArrayList<Horse>();
         Connection connection = null;
        try {
            connection = getDBConnector().getConnection();
            PreparedStatement stmt = connection.prepareStatement(SELECT_HORSES_IN_RACE_SQL);
            stmt.setInt(1, raceId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int horseId = rs.getInt(1);
                String horseNikname = rs.getString(2);
                Horse horse = new Horse(horseId, horseNikname);
                horses.add(horse);
            }
            logger.info("read horces in race");
        } catch (SQLException e) {
            throw new DAOException("Delete Race exception ", e);
        } catch (DBConnectionException e) {
            throw new DAOException("Faild to get connection from db connector ", e);
        } finally {
            if (connection != null) {
                try {
                    getDBConnector().releaseConnection(connection);
                } catch (DBConnectionException e) {
                    throw new DAOException("Failed to return connection to db connector ", e);
                }
            }
        }
        return horses;
    }

    /**
     * read races by date
     *
     * @throws DAOException if Can't execute query or problems with connection
     */
    public List<Race> readRacesByDate(Date date) throws DAOException {
        List<Race> races = new ArrayList<Race>();
         Connection connection = null;
        try {
            connection = getDBConnector().getConnection();
            PreparedStatement stmt = connection.prepareStatement(SELECT_RACE_BY_DATE_SQL);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.HOUR_OF_DAY, 3);
            java.sql.Date sqlDate = new java.sql.Date(cal.getTime().getTime());
            stmt.setDate(1, sqlDate);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                double distance = rs.getDouble(2);
                Date raceDate = rs.getDate(3);
                Race race = new Race(id, distance, raceDate);
                races.add(race);
            }
            logger.info("read races by date");
        } catch (SQLException e) {
            throw new DAOException("Delete Race exception ", e);
        } catch (DBConnectionException e) {
            throw new DAOException("Faild to get connection from db connector ", e);
        } finally {
            if (connection != null) {
                try {
                    getDBConnector().releaseConnection(connection);
                } catch (DBConnectionException e) {
                    throw new DAOException("Failed to return connection to db connector ", e);
                }
            }
        }
        return races;
    }

    public void addHorseToRace(int horseId, int raceId) throws DAOException {
         Connection connection = null;
        try {
            connection = getDBConnector().getConnection();
            PreparedStatement stmt = connection.prepareStatement(ADD_HORSE_TO_RACE_SQL);
            stmt.setInt(1, horseId);
            stmt.setInt(2, raceId);
            stmt.execute();
            logger.info("add horse to race");
        } catch (SQLException e) {
            throw new DAOException("Delete Race exception ", e);
        } catch (DBConnectionException e) {
            throw new DAOException("Faild to get connection from db connector ", e);
        } finally {
            if (connection != null) {
                try {
                    getDBConnector().releaseConnection(connection);
                } catch (DBConnectionException e) {
                    throw new DAOException("Failed to return connection to db connector ", e);
                }
            }
        }
    }

    public void setHoresPositionInRace(int horseId, int raceId, int position) throws DAOException {
         Connection connection = null;
        try {
            connection = getDBConnector().getConnection();
            PreparedStatement stmt = connection.prepareStatement(UPDATE_HORSE_POSITION_IN_RACE_SQL);
            stmt.setInt(1, position);
            stmt.setInt(2, raceId);
            stmt.setInt(3, horseId);
            stmt.execute();
            logger.info("set horse in race result races");
        } catch (SQLException e) {
            throw new DAOException("Delete Race exception ", e);
        } catch (DBConnectionException e) {
            throw new DAOException("Faild to get connection from db connector ", e);
        } finally {
            if (connection != null) {
                try {
                    getDBConnector().releaseConnection(connection);
                } catch (DBConnectionException e) {
                    throw new DAOException("Failed to return connection to db connector ", e);
                }
            }
        }
    }

}
