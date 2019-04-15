package by.isysoi.model.dao;

import by.isysoi.model.entity.Client;

import java.util.List;

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
