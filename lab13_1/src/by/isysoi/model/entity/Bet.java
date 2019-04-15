package by.isysoi.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * class that represent bet entity
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class Bet implements Serializable {

    private static final long serialVersionUID = 1;

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
    private Race race;

    /**
     * id of horse
     */
    private Horse horse;

    /**
     * id of client
     */
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

    public void setRace(Race _race) {
        race = _race;
    }

    public Horse getHorse() {
        return horse;
    }

    public void setHorse(Horse _horse) {
        horse = _horse;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client _client) {
        client = _client;
    }

    @Override
    public String toString() {
        return String.format("Bet:" +
                        "\n\tid - %d" +
                        "\n\tamount - %.2f" +
                        "\n\thorseId - %d" +
                        "\n\tclientId - %d" +
                        "\n\traceId - %d",
                id, amount, horse.getId(), client.getId(), race.getId());
    }
}
