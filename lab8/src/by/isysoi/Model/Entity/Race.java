package by.isysoi.Model.Entity;

public class Race {

    private int id;

    private double distance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Race(double distance) {
        setDistance(distance);
    }

    public Race(int id, double distance) {
        setId(id);
        setDistance(distance);
    }


}
