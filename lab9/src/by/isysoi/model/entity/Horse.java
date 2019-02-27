package by.isysoi.model.entity;

import javax.persistence.*;

/**
 * class that represent horse entity
 * @author Ilya Sysoi
 * @version 1.0.0
 */
@NamedQueries({
        @NamedQuery(
                name = "deleteHorses",
                query = "delete from Horse "
        ),
        @NamedQuery(
                name = "deleteHorse",
                query = "delete from Horse where id = :id"
        ),
        @NamedQuery(
                name = "readHorses",
                query = "select h from Horse h"
        ),
        @NamedQuery(
                name = "readHorse",
                query = "select h from Horse h where h.id = :id"
        )
})
@Entity(name = "Horse")
@Table(name = Horse.tableName)
public class Horse {

    public static final String tableName = "horse";

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
        return String.format("Horse:\n\tid - %d\n\tnikname - %s", id, nikname);
    }

}
