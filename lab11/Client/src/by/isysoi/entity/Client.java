package by.isysoi.entity;

import java.io.Serializable;
import java.util.List;

/**
 * class that represent client entity
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class Client implements Serializable {

    private static final long serialVersionUID = 1;

    public List<Bet> bets;
    /**
     * id of client
     */
    private int id;
    /**
     * FIO of client
     */
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
