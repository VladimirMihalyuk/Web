package by.isysoi.entity;

import java.io.Serializable;
import java.util.List;

/**
 * class that represent horse entity
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class Horse implements Serializable {

    public List<Race> races;

    public List<Bet> bets;

    /**
     * id of horse
     */
    private int id;
    /**
     * nikname of horse
     */
    private String nikname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNikname() {
        return nikname;
    }

    public void setNikname(String nikname) {
        this.nikname = nikname;
    }

    @Override
    public String toString() {
        return String.format("Horse:" +
                        "\n\tid - %d" +
                        "\n\tnikname - %s",
                id, nikname);
    }

}
