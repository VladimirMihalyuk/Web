package by.isysoi.Model.DAO;

import by.isysoi.Model.Entity.Bet;
import by.isysoi.Model.Exception.DAOException;
import by.isysoi.Model.Exception.DBConnectionException;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BetDAO extends DAO {

    private static final String INSERT_BET_SQL = "insert into bet (distance) values(?)";

    private static final String DELETE_BET_SQL = "delete from bet where id = ?";

    private static final String SELECT_ALL_BETS_SQL = "select * from bet";

    private static final String SELECT_BET_BY_ID_SQL = "select * from bet where id = ?";

    public BetDAO() throws DAOException {
        super();
    }

    public List<Bet> selectBet() throws DAOException {
        List<Bet> bets = new ArrayList<Bet>();
        try {
            Connection connection = getDBConnector().getConnection();

            PreparedStatement stmt = connection.prepareStatement(SELECT_ALL_BETS_SQL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                BigDecimal amount = rs.getBigDecimal(2);
                Bet bet = new Bet(id, amount);
                bets.add(bet);
            }
            getDBConnector().close();
        } catch (SQLException e) {
            throw new DAOException("Delete Bet exception ", e);
        } catch (DBConnectionException e) {
            throw new DAOException("coonection", e);
        }
        return bets;
    }

    public Bet selectBetById(int id) throws DAOException {
        Bet Bet = null;
        try {
            Connection connection = getDBConnector().getConnection();

            PreparedStatement stmt = connection.prepareStatement(SELECT_BET_BY_ID_SQL);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                BigDecimal amount = rs.getBigDecimal(2);
                Bet = new Bet(id, amount);
            }
            getDBConnector().close();
        } catch (SQLException e) {
            throw new DAOException("Delete Bet exception ", e);
        } catch (DBConnectionException e) {
            throw new DAOException("coonection", e);
        }
        return Bet;
    }

    public void insertBet(Bet bet) throws DAOException {
        try {
            Connection connection = getDBConnector().getConnection();

            PreparedStatement stmt = connection.prepareStatement(INSERT_BET_SQL);
            stmt.setBigDecimal(1, bet.getAmount());
            stmt.execute();

            getDBConnector().close();
        } catch (SQLException e) {
            throw new DAOException("Insert Bet exception ", e);
        } catch (DBConnectionException e) {
            throw new DAOException("coonection", e);
        }

    }

    public void deleteClient(Bet bet) throws DAOException {
        try {
            Connection connection = getDBConnector().getConnection();

            PreparedStatement stmt = connection.prepareStatement(DELETE_BET_SQL);
            stmt.setInt(1, bet.getId());
            stmt.execute();

            getDBConnector().close();
        } catch (SQLException e) {
            throw new DAOException("Delete Bet exception ", e);
        } catch (DBConnectionException e) {
            throw new DAOException("coonection", e);
        }

    }
    
}
