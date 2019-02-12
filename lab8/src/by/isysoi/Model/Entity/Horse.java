package by.isysoi.Model.Entity;

public class Horse {

    private int id;

    private String nikname;

    public Horse(String nikname) {
        setNikname(nikname);
    }

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
}
