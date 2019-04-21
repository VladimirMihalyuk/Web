package by.isysoi.dao.impl;
import by.isysoi.dao.UserDAOInterface;
import by.isysoi.entity.Bet;
import by.isysoi.entity.Client;
import by.isysoi.entity.User;
import by.isysoi.exception.DAOException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;

import static by.isysoi.entity.RaceInfo_.raceId;

/**
 * user dao
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
@Stateless
public class UserDAO implements UserDAOInterface {

    @PersistenceContext(unitName = "Test_Local")
    private EntityManager entityManager;

    /**
     * DAO constructor
     */
    public UserDAO(EntityManagerFactory emf) {
        entityManager = emf.createEntityManager();
        //logger.info("RaceDAO created ");
    }

    public UserDAO() {
    }

    /**
     * check user
     *
     * @param login  login of user
     * @param password password of user
     */
    @Override
    public boolean isUserValid(String login, String password) throws DAOException {
        boolean result = false;
        try {
            int count = entityManager.createNamedQuery("checkUser", User.class)
                    .setParameter("login", login)
                    .setParameter("password", password)
                    .getResultList()
                    .size();
            result = count == 1;
        } catch (Exception e) {
            //logger.error("failed to read winners by race", e);
            throw new DAOException("Failed to check user", e);
        }
        return result;
    }

    /**
     * get user info without password
     *
     * @param login  login of user
     */
    @Override
    public User getUserInfo(String login) throws DAOException {
        User user = null;
        try {
            user = entityManager.createNamedQuery("getUser", User.class)
                    .setParameter("login", login)
                    .getSingleResult();
        } catch (Exception e) {
            //logger.error("failed to read winners by race", e);
            throw new DAOException("Failed to get user", e);
        }
        return user;
    }
}
