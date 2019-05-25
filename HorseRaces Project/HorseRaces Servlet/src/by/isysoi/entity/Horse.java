package by.isysoi.entity;

import by.isysoi.xml.adapter.IntAdapter;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.List;

/**
 * class that represent horse entity
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name = "Horse")
@Table(name = by.isysoi.entity.Horse.tableName)
public class Horse implements Serializable {

    public static final String tableName = "horse";
    public static final String idColumnName = "id";
    private static final long serialVersionUID = 1;

    @XmlIDREF
    @ManyToMany(mappedBy = "horses",
            fetch = FetchType.EAGER)
    @XmlElement(name = "race")
    public List<Race> races;

    @XmlIDREF
    @OneToMany(mappedBy = "horse", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @XmlElement(name = "bet")
    public List<Bet> bets;

    /**
     * id of horse
     */
    @XmlAttribute
    @XmlID
    @XmlJavaTypeAdapter(type = int.class, value = IntAdapter.class)
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
