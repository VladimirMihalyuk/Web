package by.isysoi.dao;

import by.isysoi.entity.Race;
import by.isysoi.entity.User;
import by.isysoi.exception.DAOException;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface UserDAOInterface {

    /**
     * check for valid user
     *
     * @return true or false
     */
    boolean isUserValid(String login, String password) throws DAOException;

    /**
     * get user info
     *
     * @return true or false
     */
    User getUserInfo(String login) throws DAOException;

}
