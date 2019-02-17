package by.isysoi.Model.Entity;

/**
 * class that represent horse entity
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class Horse {

    /**
     * id of horse
     */
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
