package by.isysoi.dao;

import by.isysoi.entity.Client;
import by.isysoi.exception.DAOException;

import java.util.List;

public interface ClientDAOInterface {
    /**
     * read clients
     *
     * @return list of clients
     */
    List<Client> readClients() throws DAOException;

    /**
     * read client by id
     *
     * @param id client id
     * @return client
     */
    Client readClientById(int id) throws DAOException;

    /**
     * insert client
     *
     * @param client client object
     */
    void insertClient(Client client) throws DAOException;

}
