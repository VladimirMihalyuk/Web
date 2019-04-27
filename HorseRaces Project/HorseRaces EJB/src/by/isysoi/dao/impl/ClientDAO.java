package by.isysoi.dao.impl;

import by.isysoi.dao.ClientDAOInterface;
import by.isysoi.entity.Client;
import by.isysoi.entity.Client_;
import by.isysoi.exception.DAOException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * client dao class
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
@Stateless
public class ClientDAO implements ClientDAOInterface {

    //protected Logger logger = LogManager.getLogger("dao_layer");

    @PersistenceContext(unitName = "Test_Local")
    private EntityManager entityManager;

    /**
     * DAO constructor
     */
    public ClientDAO(EntityManagerFactory emf) {
        entityManager = emf.createEntityManager();
        //logger.info("ClientDAO created ");
    }

    public ClientDAO() {
    }

    /**
     * read clients
     *
     * @return list of clients
     */
    public List<Client> readClients() throws DAOException {
        List clients = null;

        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Client.class);
            Root client = criteriaQuery.from(Client.class);

            clients = entityManager.createQuery(criteriaQuery)
                    .getResultList();
        } catch (Exception e) {
            //logger.error("failed to read clients", e);
            throw new DAOException("Failed to read clients", e);
        }
        return clients;
    }

    /**
     * read client by id
     *
     * @param id client id
     * @return client
     */
    public Client readClientById(int id) throws DAOException {
        Client client = null;

        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Client.class);
            Root rootClient = criteriaQuery.from(Client.class);
            Predicate condition = criteriaBuilder.equal(rootClient.get(Client_.id), id);
            criteriaQuery.where(condition);

            client = (Client) entityManager.createQuery(criteriaQuery)
                    .getSingleResult();
        } catch (Exception e) {
            //logger.error("failed to read client", e);
            throw new DAOException("Failed to read client", e);
        }
        return client;
    }

    /**
     * insert client
     *
     * @param client client object
     */
    public void insertClient(Client client) throws DAOException {
        try {
            entityManager.persist(client);
        } catch (Exception e) {
            //logger.error("failed to insert client", e);
            throw new DAOException("Failed to insert client", e);
        }
    }

}
