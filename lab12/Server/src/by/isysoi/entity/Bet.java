package by.isysoi.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * class that represent bet entity
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name = "Bet")
@Table(name = Bet.tableName)
public class Bet implements Serializable {

    public static final String tableName = "bet";
    public static final String horseColumnName = "horse_id";
    public static final String clientColumnName = "client_id";
    public static final String raceColumnName = "race_id";
    private static final long serialVersionUID = 1;
    /**
     * id of bet
     */
    @XmlAttribute
    @XmlID
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
    @XmlIDREF
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = raceColumnName)
    private Race race;

    /**
     * id of horse
     */
    @XmlIDREF
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = horseColumnName)
    private Horse horse;

    /**
     * id of client
     */
    @XmlIDREF
    @ManyToOne(fetch = FetchType.EAGER)
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

    public void setRace(Race race) {
        this.race = race;
    }

    public Horse getHorse() {
        return horse;
    }

    public void setHorse(Horse horse) {
        this.horse = horse;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
