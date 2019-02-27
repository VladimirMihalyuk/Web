package by.isysoi.model.entity;

import javax.persistence.*;

/**
 * class that represent client entity
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */

@NamedQueries({
        @NamedQuery(
                name = "deleteClients",
                query = "delete from client"
        ),
        @NamedQuery(
                name = "deleteClient",
                query = "delete from client where id = :id"
        ),
        @NamedQuery(
                name = "readClients",
                query = "select * from client"
        ),
        @NamedQuery(
                name = "readClient",
                query = "select * from client where id = :id"
        )
})
@Entity(name = "Client")
@Table(name = "client")
public class Client {

    /**
     * id of client
     */
    @Id
    @GeneratedValue
    private int id;

    /**
     * FIO of client
     */
    private String FIO;

    /**
     * constructor to create client
     *
     * @param id  id of client
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

    @Override
    public String toString() {
        return String.format("Client:\n\tid - %d\n\tfio - %s", id, FIO);
    }

}
