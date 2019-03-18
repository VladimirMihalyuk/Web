package by.isysoi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity(name = "RaceInfo")
@Table(name = RaceInfo.tableName)
public class RaceInfo implements Serializable {

    public static final String tableName = "race_info";
    public static final String raceColumnName = "race_id";
    public static final String horseColumnName = "horse_id";

    @Id
    @Column(name = RaceInfo.raceColumnName)
    private int raceId;

    @Id
    @Column(name = RaceInfo.horseColumnName)
    private int horseId;

    @Column(nullable = true)
    private Integer position;

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

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return String.format("RaceInfo:" +
                        "\n\thorse - %d" +
                        "\n\trace - %d" +
                        "\n\tposition - %d",
                horseId, raceId, position);
    }
}
