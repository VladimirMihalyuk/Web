package by.isysoi.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * class that represent client entity
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */

@Entity(name = "Client")
@Table(name = Client.tableName)
public class Client implements Serializable {

    public static final String tableName = "client";
    private static final String fioColumnName = "fio";
    @OneToMany(mappedBy = "client",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    public List<Bet> bets;
    /**
     * id of client
     */
    @Id
    @GeneratedValue
    private int id;
    /**
     * FIO of client
     */
    @Column(name = Client.fioColumnName)
    private String FIO;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    @Override
    public String toString() {
        return String.format("Client:" +
                        "\n\tid - %d" +
                        "\n\tfio - %s",
                id, FIO);
    }

}
