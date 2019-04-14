package by.isysoi.model.entity;

import java.io.Serializable;

public class RaceInfo implements Serializable {

    private static final long serialVersionUID = 1;

    private int raceId;

    private int horseId;

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
