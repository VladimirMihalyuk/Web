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
                query = "delete from horse"
        ),
        @NamedQuery(
                name = "deleteHorse",
                query = "delete from horse where id = :id"
        ),
        @NamedQuery(
                name = "readHorses",
                query = "select * from horse"
        ),
        @NamedQuery(
                name = "readHorse",
                query = "select * from horse where id = :id"
        )
})
@Entity(name = "Horse")
@Table(name = "horse")
public class Horse {

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

    /**
     * constructor to create horse
     * @param id id of horse
     * @param nikname nikname of horse
     */
    public Horse(int id, String nikname) {
        setId(id);
        setNikname(nikname);
    }

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
