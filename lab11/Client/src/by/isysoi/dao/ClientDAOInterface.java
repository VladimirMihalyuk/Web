package by.isysoi.dao;

import by.isysoi.entity.*;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface ClientDAOInterface {
    /**
     * read clients
     *
     * @return list of clients
     */
    List<Client> readClients();

    /**
     * read client by id
     *
     * @param id client id
     * @return client
     */
    Client readClientById(int id);

    /**
     * insert client
     *
     * @param client client object
     */
    void insertClient(Client client);

}
