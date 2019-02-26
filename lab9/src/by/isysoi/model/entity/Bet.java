package by.isysoi.model.entity;

import java.math.BigDecimal;

/**
 * class that represent bet entity
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class Bet {

    /**
     * id of bet
     */
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
