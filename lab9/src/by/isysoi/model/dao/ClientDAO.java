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
        EntityManager entityManager = null;
        List<Client> clients = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();

            clients = entityManager.createNamedQuery("readClients")
                    .getResultList();
        } catch (Exception e) {
            throw new DAOException("failed to read clients", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return clients;
    }

    /**
     * read client by id
     *
     * @return client
     */
    public Client readClientById(int id) throws DAOException {
        EntityManager entityManager = null;
        Client client = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();

            client = entityManager.createNamedQuery("readClient", Client.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception e) {
            throw new DAOException("failed to read client", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return client;
    }

    /**
     * insert client
     */
    public void insertClient(Client client) throws DAOException {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.persist(client);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            throw new DAOException("failed to insert client", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
    }

    /**
     * delete client
     *
     * @param id id of client to delete
     */
    public void deleteClient(int id) throws DAOException {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.createNamedQuery("deleteClient")
                    .setParameter("id", id)
                    .executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            throw new DAOException("failed to delete client", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
    }

    /**
     * delete clients
     */
    public void deleteClients() throws DAOException {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.createNamedQuery("deleteClients").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            throw new DAOException("failed to delete clients", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
    }


}
