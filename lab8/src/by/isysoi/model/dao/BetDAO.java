package by.isysoi.model.dao;

import by.isysoi.model.entity.Bet;
import by.isysoi.model.entity.Client;
import by.isysoi.model.exception.DAOException;
import by.isysoi.model.exception.DBConnectionException;

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

    private static final String SELECT_WINNERS_BY_RACE_SQL = "select c.id, c.fio, b.id, b.amount, b.client_id, b.horse_id, b.race_id from client c join bet b on b.client_id = c.id join race r on b.race_id = r.id join race_info ri on ri.race_id = r.id where b.race_id = ? and ri.position = 1";

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
                int clientId = rs.getInt(3);
                int raceId = rs.getInt(5);
                int horseId = rs.getInt(4);
                Bet bet = new Bet(id, amount, raceId, horseId, clientId);
                bets.add(bet);
            }
            logger.info("read bets");
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
        Bet bet = null;
        try {
            Connection connection = getDBConnector().getConnection();

            PreparedStatement stmt = connection.prepareStatement(SELECT_BET_BY_ID_SQL);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                BigDecimal amount = rs.getBigDecimal(2);
                int clientId = rs.getInt(3);
                int raceId = rs.getInt(5);
                int horseId = rs.getInt(4);
                bet = new Bet(id, amount, raceId, horseId, clientId);
            }
            logger.info("read bet by id");
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
        return bet;
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
            stmt.setInt(1, bet.getId());
            stmt.setBigDecimal(2, bet.getAmount());
            stmt.setInt(3, bet.getClientId());
            stmt.setInt(4, bet.getHorseId());
            stmt.setInt(6, bet.getRaceId());
            stmt.execute();
            logger.info("inserted bet");
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
            logger.info("deleted bet");
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
                int clientIdBet = rs.getInt(5);
                int raceIdBet = rs.getInt(7);
                int horseId = rs.getInt(6);
                Bet bet = new Bet(betId, amount, raceIdBet, horseId, clientIdBet);

                clientsWithBet.add(new AbstractMap.SimpleImmutableEntry<>(client, bet));
            }
            logger.info("read winners");
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
