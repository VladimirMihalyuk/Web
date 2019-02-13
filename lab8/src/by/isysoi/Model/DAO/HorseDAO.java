package by.isysoi.Model.DAO;

import by.isysoi.Model.Entity.Horse;
import by.isysoi.Model.Exception.DAOException;
import by.isysoi.Model.Exception.DBConnectionException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HorseDAO extends DAO {

    private static final String INSERT_HORSE_SQL = "insert into horse (nikname) values(?)";

    private static final String DELETE_HORSE_SQL = "delete from horse where id = ?";

    private static final String SELECT_ALL_HORSE_SQL = "select * from horse";

    private static final String SELECT_HORSE_BY_ID_SQL = "select * from horse where id = ?";

    public HorseDAO() throws DAOException {
        super();
    }

    public List<Horse> selectHorse() throws DAOException {
        List<Horse> clients = new ArrayList<Horse>();
        try {
            Connection connection = getDBConnector().getConnection();

            PreparedStatement stmt = connection.prepareStatement(SELECT_ALL_HORSE_SQL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String nikname = rs.getString(2);
                Horse horse = new Horse(id, nikname);
                clients.add(horse);
            }
            getDBConnector().close();
        } catch (SQLException e) {
            throw new DAOException("Delete horse exception ", e);
        } catch (DBConnectionException e) {
            throw new DAOException("coonection", e);
        }
        return clients;
    }

    public Horse selectHorseById(int id) throws DAOException {
        Horse horse = null;
        try {
            Connection connection = getDBConnector().getConnection();

            PreparedStatement stmt = connection.prepareStatement(SELECT_HORSE_BY_ID_SQL);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String niknmame = rs.getString(2);
                horse = new Horse(id, niknmame);
            }
            getDBConnector().close();
        } catch (SQLException e) {
            throw new DAOException("Delete horse exception ", e);
        } catch (DBConnectionException e) {
            throw new DAOException("coonection", e);
        }
        return horse;
    }

    public void insertHorse(Horse horse) throws DAOException {
        try {
            Connection connection = getDBConnector().getConnection();

            PreparedStatement stmt = connection.prepareStatement(INSERT_HORSE_SQL);
            stmt.setString(1, horse.getNikname());
            stmt.execute();

            getDBConnector().close();
        } catch (SQLException e) {
            throw new DAOException("Insert horse exception ", e);
        } catch (DBConnectionException e) {
            throw new DAOException("coonection", e);
        }

    }

    public void deleteClient(Horse horse) throws DAOException {
        try {
            Connection connection = getDBConnector().getConnection();

            PreparedStatement stmt = connection.prepareStatement(DELETE_HORSE_SQL);
            stmt.setInt(1, horse.getId());
            stmt.execute();

            getDBConnector().close();
        } catch (SQLException e) {
            throw new DAOException("Delete horse exception ", e);
        } catch (DBConnectionException e) {
            throw new DAOException("coonection", e);
        }

    }

}
