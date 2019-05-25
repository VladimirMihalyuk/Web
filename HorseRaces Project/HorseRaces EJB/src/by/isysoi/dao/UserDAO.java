package by.isysoi.dao;

import by.isysoi.entity.User;
import by.isysoi.exception.DAOException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * user dao
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
@Stateless
@Path("/user")
public class UserDAO {

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
     * get user info without password
     *
     * @param login login of user
     * @param password password of user
     */
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_XML)
    public User getUserInfo(@QueryParam("login") String login, @QueryParam("password") String password) throws DAOException {
        User user = null;
        try {
            user = entityManager.createNamedQuery("getUserInfo", User.class)
                    .setParameter("login", login)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            //logger.error("failed to read winners by race", e);
            throw new DAOException("Failed to get user", e);
        }
        return user;
    }

    /**
     * register user
     *
     * @param user user info to register
     */
    @POST
    @Path("register")
    @Consumes(MediaType.APPLICATION_XML)
    public void registerUser(User user) throws DAOException {
        try {
            entityManager.persist(user);
        } catch (Exception e) {
            throw new DAOException("Failed to register new user", e);
        }
    }
}
