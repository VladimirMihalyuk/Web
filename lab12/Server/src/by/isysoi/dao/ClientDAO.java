package by.isysoi.dao;

import by.isysoi.entity.Client;
import by.isysoi.entity.Client_;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import java.util.List;

/**
 * client dao class
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */

@WebService()
public class ClientDAO {

    protected Logger logger = LogManager.getLogger("dao_layer");

    @Resource
    UserTransaction transaction;

    @PersistenceContext(unitName = "Test_Local")
    private EntityManager entityManager;

    /**
     * DAO constructor
     */
    public ClientDAO(EntityManagerFactory emf) {
        entityManager = emf.createEntityManager();
        logger.info("ClientDAO created ");
    }

    public ClientDAO() {
    }

    /**
     * read clients
     *
     * @return list of clients
     */
    @WebMethod
    public List<Client> readClients() {
        List clients = null;

        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Client.class);
            Root client = criteriaQuery.from(Client.class);

            clients = entityManager.createQuery(criteriaQuery)
                    .getResultList();
        } catch (Exception e) {
            logger.error("failed to read clients", e);
        }
        return clients;
    }

    /**
     * read client by id
     *
     * @param id client id
     * @return client
     */
    @WebMethod
    public Client readClientById(int id) {
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
            logger.error("failed to read client", e);
        }
        return client;
    }

    /**
     * insert client
     *
     * @param client client object
     */
    @WebMethod
    public void insertClient(Client client) {
        try {
            transaction.begin();
            entityManager.joinTransaction();

            entityManager.persist(client);

            transaction.commit();
        } catch (Exception e) {
            try {
                transaction.rollback();
            } catch (SystemException e1) {
                logger.error("transaction rollback failed", e);
            }
            logger.error("failed to insert client", e);
        }
    }

}
