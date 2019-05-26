package by.isysoi.dao;

import by.isysoi.entity.User;
import by.isysoi.exception.DAOException;

public interface UserDAOInterface {

    /**
     * get user info
     *
     * @return user
     */
    User getUserInfo(String login, String password) throws DAOException;

    /**
     * register new user info
     */
    void registerUser(User user) throws DAOException;

}
