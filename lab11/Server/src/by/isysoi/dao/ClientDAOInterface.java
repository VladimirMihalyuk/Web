package by.isysoi.dao;

import by.isysoi.entity.Client;
import by.isysoi.exception.DAOException;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface ClientDAOInterface {
    /**
     * read clients
     *
     * @return list of clients
     * @throws DAOException if query execution failed
     */
    List<Client> readClients() throws DAOException;

    /**
     * read client by id
     *
     * @param id client id
     * @return client
     * @throws DAOException if query execution failed
     */
    Client readClientById(int id) throws DAOException;

    /**
     * insert client
     *
     * @param client client object
     * @throws DAOException if query execution failed
     */
    void insertClient(Client client) throws DAOException;

    /**
     * delete client
     *
     * @param id id of client to delete
     * @throws DAOException if query execution failed
     */
    void deleteClient(int id) throws DAOException;

    /**
     * delete clients
     *
     * @throws DAOException if query execution failed
     */
    void deleteClients() throws DAOException;

}
