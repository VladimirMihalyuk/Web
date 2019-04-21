package by.isysoi.dao;

import by.isysoi.entity.Race;
import by.isysoi.entity.User;
import by.isysoi.exception.DAOException;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface UserDAOInterface {

    /**
     * get user info
     *
     * @return true or false
     */
    User getUserInfo(String login, String password) throws DAOException;

}
