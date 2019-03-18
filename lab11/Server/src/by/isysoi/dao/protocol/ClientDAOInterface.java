package by.isysoi.dao.protocol;

import by.isysoi.entity.Client;
import by.isysoi.exception.DAOException;

import java.util.List;

public interface ClientDAOInterface {
    /**
     * read clients
     *
     * @return list of clients
     * @throws DAOException if query execution failed
     */
    public List<Client> readClients() throws DAOException;

    /**
     * read client by id
     *
     * @param id client id
     * @return client
     * @throws DAOException if query execution failed
     */
    public Client readClientById(int id) throws DAOException ;

    /**
     * insert client
     *
     * @param client client object
     * @throws DAOException if query execution failed
     */
    public void insertClient(Client client) throws DAOException;

    /**
     * delete client
     *
     * @param id id of client to delete
     * @throws DAOException if query execution failed
     */
    public void deleteClient(int id) throws DAOException ;

    /**
     * delete clients
     *
     * @throws DAOException if query execution failed
     */
    public void deleteClients() throws DAOException ;

}
