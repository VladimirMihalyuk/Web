package by.isysoi.model.dao;

import by.isysoi.model.entity.Client;
import by.isysoi.model.entity.Client_;
import by.isysoi.model.exception.DAOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.*;
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
     * @throws DAOException if query execution failed
     */
    public List<Client> readClients() throws DAOException {
        EntityManager entityManager = null;
        List clients = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Client.class);
            Root client = criteriaQuery.from(Client.class);

            clients = entityManager.createQuery(criteriaQuery)
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
     * @param id client id
     * @return client
     * @throws DAOException if query execution failed
     */
    public Client readClientById(int id) throws DAOException {
        EntityManager entityManager = null;
        Client client = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Client.class);
            Root rootClient = criteriaQuery.from(Client.class);
            Predicate condition = criteriaBuilder.equal(rootClient.get(Client_.id), id);
            criteriaQuery.where(condition);

            client = (Client) entityManager.createQuery(criteriaQuery)
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
     *
     * @param client client object
     * @throws DAOException if query execution failed
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
     * @throws DAOException if query execution failed
     */
    public void deleteClient(int id) throws DAOException {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaDelete criteriaDelete = criteriaBuilder.createCriteriaDelete(Client.class);
            Root rootClient = criteriaDelete.from(Client.class);
            Predicate condition = criteriaBuilder.equal(rootClient.get(Client_.id), id);
            criteriaDelete.where(condition);

            transaction.begin();
            entityManager.createQuery(criteriaDelete)
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
     *
     * @throws DAOException if query execution failed
     */
    public void deleteClients() throws DAOException {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaDelete criteriaDelete = criteriaBuilder.createCriteriaDelete(Client.class);
            Root rootClient = criteriaDelete.from(Client.class);

            transaction.begin();
            entityManager.createQuery(criteriaDelete)
                    .executeUpdate();
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
