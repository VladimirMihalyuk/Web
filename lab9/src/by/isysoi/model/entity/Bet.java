package by.isysoi.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * class that represent bet entity
 * @author Ilya Sysoi
 * @version 1.0.0
 */

@Entity(name = "Bet")
@Table(name = Bet.tableName)
@NamedQueries({
        @NamedQuery(
                name = "deleteBets",
                query = "delete from Bet"),
        @NamedQuery(
                name = "deleteBet",
                query = "delete from Bet where id = :id"),
        @NamedQuery(
                name = "readBets",
                query = "select b from Bet b"),
        @NamedQuery(
                name = "readBet",
                query = "select b from Bet b where b.id = :id"),
//        @NamedQuery(
//                name = "readWinners",
//                query = "select c.id, c.FIO, b.id, b.amount, b.clientId, b.horseId, b.raceId from Client c " +
//                        "join Bet b on b.clientId = c.id " +
//                        "join Race r on b.raceId = r.id " +
//                        "join RaceInfo ri on ri.raceId = r.id " +
//                        "where b.raceId = :raceId and ri.position = 1")
})
public class Bet {

    public static final String tableName = "bet";
    private static final String horseColumnName = "horse_id";
    private static final String clientColumnName = "client_id";
    private static final String raceColumnName = "race_id";

    /**
     * id of bet
     */
    @Id
    @GeneratedValue
    private int id;

    /**
     * amount of bet
     */
    private BigDecimal amount;

    /**
     * id of race
     */
    @Column(name = Bet.raceColumnName)
    private int raceId;

    /**
     * id of horse
     */
    @Column(name = Bet.horseColumnName)
    private int horseId;

    /**
     * id of client
     */
    @Column(name = Bet.clientColumnName)
    private int clientId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public int getHorseId() {
        return horseId;
    }

    public void setHorseId(int horseId) {
        this.horseId = horseId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return String.format("Bet:\n\tid - %d\n\tamount - %.2f\n\thorseId - %d\n\tclientId - %d\n\traceId - %d", id, amount, horseId, clientId, raceId);
    }
}
