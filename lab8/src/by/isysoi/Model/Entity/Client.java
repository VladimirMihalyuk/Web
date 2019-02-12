package by.isysoi.Model.Entity;

public class Client {

    private int id;
    private String FIO;

    public Client(String FIO) {
        setFIO(FIO);
    }

    public Client(int id, String FIO) {
        setId(id);
        setFIO(FIO);
    }

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

}
