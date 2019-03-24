package by.isysoi.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * class that represent horse entity
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
@Entity(name = "Horse")
@Table(name = Horse.tableName)
public class Horse implements Serializable {

    public static final String tableName = "horse";
    public static final String idColumnName = "id";
    @ManyToMany(mappedBy = "horses",
            fetch = FetchType.EAGER)
    public List<Race> races;
    @OneToMany(mappedBy = "horse", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Bet> bets;
    /**
     * id of horse
     */
    @Id
    @GeneratedValue
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
