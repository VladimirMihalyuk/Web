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
    public static final String horseColumnName = "horse_id";
    public static final String clientColumnName = "client_id";
    public static final String raceColumnName = "race_id";

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = raceColumnName)
    private Race race;

    /**
     * id of horse
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = horseColumnName)
    private Horse horse;

    /**
     * id of client
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = clientColumnName)
    private Client client;

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

    public Race getRace() {
        return race;
    }

    public void setRaceId(Race race) {
        this.race = race;
    }

    public Horse getHorseId() {
        return horse;
    }

    public void setHorseId(Horse horse) {
        this.horse = horse;
    }

    public Client getClientId() {
        return client;
    }

    public void setClientId(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return String.format("Bet:\n\tid - %d\n\tamount - %.2f\n\thorse - %s\n\tclient - %s\n\trace - %s", id, amount, horse, client, race);
    }
}
