package by.isysoi.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * class that represent bet entity
 * @author Ilya Sysoi
 * @version 1.0.0
 */
@NamedQueries({
        @NamedQuery(
                name = "deleteBets",
                query = "delete from bet"
        ),
        @NamedQuery(
                name = "deleteBet",
                query = "delete from bet where id = :id"
        ),
        @NamedQuery(
                name = "readBets",
                query = "select * from bet"
        ),
        @NamedQuery(
                name = "readBet",
                query = "select * from bet where id = :id"
        ),
        @NamedQuery(
                name = "readWinners",
                query = "select c.id, c.fio, b.id, b.amount, b.client_id, b.horse_id, b.race_id from client c join bet b on b.client_id = c.id join race r on b.race_id = r.id join race_info ri on ri.race_id = r.id where b.race_id = :raceId and ri.position = 1"
        )
})
@Entity(name = "Bet")
@Table(name = "bet")
public class Bet {

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
    private int raceId;

    /**
     * id of horse
     */
    private int horseId;

    /**
     * id of client
     */
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

    /**
     * constructor to create bet
     * @param id id of bet
     * @param amount amount of bet
     */
    public Bet(int id, BigDecimal amount, int raceId, int horseId, int clientId) {
        setId(id);
        setAmount(amount);
        setRaceId(raceId);
        setHorseId(horseId);
        setClientId(clientId);
    }

    @Override
    public String toString() {
        return String.format("Bet:\n\tid - %d\n\tamount - %.2f\n\thorseId - %d\n\tclientId - %d\n\traceId - %d", id, amount, horseId, clientId, raceId);
    }
}
