package by.isysoi.Model.Entity;

/**
 * class that represent client entity
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class Client {

    /**
     * id of client
     */
    private int id;

    /**
     * FIO of client
     */
    private String FIO;

    /**
     * constructor to create client
     * @param id id of client
     * @param FIO FIO of client
     */
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
