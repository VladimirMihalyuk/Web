package by.isysoi.dao.impl;

import by.isysoi.dao.HorseRacesEndPointConstants;
import by.isysoi.dao.UserDAOInterface;
import by.isysoi.entity.User;
import by.isysoi.exception.DAOException;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * user dao wrapper class
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class UserDAORestfulWrapper implements UserDAOInterface {

    private WebTarget target;

    public UserDAORestfulWrapper() {
        target = ClientBuilder.newClient().target(HorseRacesEndPointConstants.userEndPoint);
    }

    /**
     * get user info without password
     *
     * @param login login of user
     */
    @Override
    public User getUserInfo(String login, String password) throws DAOException {
        User user = null;
        try {
            user = target
                    .queryParam("login", login)
                    .queryParam("password", password)
                    .request(MediaType.APPLICATION_XML)
                    .get(User.class);
        } catch (Exception e) {
            throw new DAOException("Failed request to check user", e);
        }
        return user;
    }

    /**
     * register user
     *
     * @param user user info to register
     */
    @Override
    public void registerUser(User user) throws DAOException {
        try {
            target.path("register")
                    .request()
                    .post(Entity.entity(user, MediaType.APPLICATION_XML));
        } catch (Exception e) {
            throw new DAOException("Failed request to register user", e);
        }
    }
}
