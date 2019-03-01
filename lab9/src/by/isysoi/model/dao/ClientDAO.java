package by.isysoi.model.dao;

import by.isysoi.model.entity.Client;
import by.isysoi.model.exception.DAOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * client dao class
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class ClientDAO extends DAO {

    /**
     * constructor
     */
    public ClientDAO() {
        super();
    }

    /**
     * read clients
     *
     * @return list of clients
     */
    public List<Client> readClients() throws DAOException {
        EntityManager em = getEntityManager();
        List clients = em.createNamedQuery("readClients").getResultList();
        return clients;
    }

    /**
     * read client by id
     *
     * @return client
     */
    public Client readClientById(int id) throws DAOException {
        EntityManager em = getEntityManager();
        Client clients = em.createNamedQuery("readClient", Client.class)
                .setParameter("id", id)
                .getSingleResult();
        return clients;
    }

    /**
     * insert client
     */
    public void insertClient(Client client) throws DAOException {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(client);
        transaction.commit();
    }

    /**
     * delete client
     *
     * @param id id of client to delete
     */
    public void deleteClient(int id) throws DAOException {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.createNamedQuery("deleteClient")
                .setParameter("id", id)
                .executeUpdate();
        transaction.commit();
    }

    /**
     * delete clients
     */
    public void deleteClients() throws DAOException {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.createNamedQuery("deleteClients").executeUpdate();
        transaction.commit();
    }


}
