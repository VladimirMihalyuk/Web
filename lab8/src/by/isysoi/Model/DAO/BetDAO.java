package by.isysoi.Model.DAO;

import by.isysoi.Model.Entity.Bet;
import by.isysoi.Model.Entity.Client;
import by.isysoi.Model.Exception.DAOException;
import by.isysoi.Model.Exception.DBConnectionException;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * bet dao class
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class BetDAO extends DAO {

    private static final String INSERT_BET_SQL = "insert into bet (id, amount, client_id, horse_id, race_id) values(?, ?, ?, ?, ?)";

    private static final String DELETE_BET_SQL = "delete from bet where id = ?";

    private static final String SELECT_ALL_BETS_SQL = "select * from bet";

    private static final String SELECT_BET_BY_ID_SQL = "select * from bet where id = ?";

    private static final String SELECT_WINNERS_BY_RACE_SQL = "select c.id, c.fio, b.id, b.amount from client c join bet b on b.client_id = c.id join race r on b.race_id = r.id join race_info ri on ri.race_id = r.id where b.race_id = ? and ri.position = 1";

    /**
     * constructor
     *
     * @throws DAOException if Can't create connection
     */
    public BetDAO() throws DAOException {
        super();
    }

    /**
     * read bets
     *
     * @return bets
     * @throws DAOException if Can't execute query or problems with connection
     */
    public List<Bet> readBet() throws DAOException {
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
        } catch (SQLException e) {
            throw new DAOException("Delete Bet exception ", e);
        } catch (DBConnectionException e) {
            throw new DAOException("Failed establish connection", e);
        } finally {
            try {
                getDBConnector().close();
            } catch (DBConnectionException e) {
                throw new DAOException("Failed close connection", e);
            }
        }
        return bets;
    }

    /**
     * read bet by id
     *
     * @return bet
     * @throws DAOException if Can't execute query or problems with connection
     */
    public Bet readBetById(int id) throws DAOException {
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
        } catch (SQLException e) {
            throw new DAOException("Delete Bet exception ", e);
        } catch (DBConnectionException e) {
            throw new DAOException("Failed establish connection", e);
        } finally {
            try {
                getDBConnector().close();
            } catch (DBConnectionException e) {
                throw new DAOException("Failed close connection", e);
            }
        }
        return Bet;
    }

    /**
     * insety clients
     *
     * @throws DAOException if Can't execute query or problems with connection
     */
    public void insertBet(Bet bet) throws DAOException {
        try {
            Connection connection = getDBConnector().getConnection();

            PreparedStatement stmt = connection.prepareStatement(INSERT_BET_SQL);
            stmt.setBigDecimal(1, bet.getAmount());
            stmt.execute();
        } catch (SQLException e) {
            throw new DAOException("Insert Bet exception ", e);
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
     * delete clients
     *
     * @throws DAOException if Can't execute query or problems with connection
     */
    public void deleteClient(Bet bet) throws DAOException {
        try {
            Connection connection = getDBConnector().getConnection();

            PreparedStatement stmt = connection.prepareStatement(DELETE_BET_SQL);
            stmt.setInt(1, bet.getId());
            stmt.execute();
        } catch (SQLException e) {
            throw new DAOException("Delete Bet exception ", e);
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
     * get winners by race
     *
     * @return list of clients
     * @throws DAOException if Can't execute query or problems with connection
     */
    public List<Map.Entry<Client,Bet>> readWinnersByRace(int raceId) throws DAOException {
        List<Map.Entry<Client,Bet>> clientsWithBet = new ArrayList<Map.Entry<Client,Bet>>();
        try {
            Connection connection = getDBConnector().getConnection();

            PreparedStatement stmt = connection.prepareStatement(SELECT_WINNERS_BY_RACE_SQL);
            stmt.setInt(1,raceId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int clientId = rs.getInt(1);
                String fio = rs.getString(2);
                Client client = new Client(clientId, fio);

                int betId = rs.getInt(3);
                BigDecimal amount = rs.getBigDecimal(4);
                Bet bet = new Bet(betId,amount);

                clientsWithBet.add(new AbstractMap.SimpleImmutableEntry<>(client, bet));
            }
        } catch (SQLException e) {
            throw new DAOException("Delete Bet exception ", e);
        } catch (DBConnectionException e) {
            throw new DAOException("Failed establish connection", e);
        } finally {
            try {
                getDBConnector().close();
            } catch (DBConnectionException e) {
                throw new DAOException("Failed close connection", e);
            }
        }
        return clientsWithBet;
    }


}
