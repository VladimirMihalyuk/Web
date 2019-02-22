package by.isysoi.model;

import by.isysoi.model.exception.DBConnectionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * database connector class
 *
 * @author Ilya Sysoi
 * @version 1.0.0
 */
public class DBConnector {

    private final String DB_PROPERTIES = "database/database.properties";
    private final String driver;
    private final String DB_URL;
    private final String user;
    private final String password;
    private Connection connection;

    private Logger logger = LogManager.getLogger("database_layer");

    /**
     * Constructor that init form properties file constant to database
     *
     * @throws DBConnectionException if properties file loading error
     */
    public DBConnector() throws DBConnectionException {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(DB_PROPERTIES));
            logger.info("Properties file loaded");
        } catch (IOException e) {
            throw new DBConnectionException("properties file not loaded");
        }
        driver = properties.getProperty("driver");
        DB_URL = properties.getProperty("url");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
    }

    /**
     * configure connection and return it
     *
     * @throws DBConnectionException if somthing goes wrong with creating connection
     * @return connection to database
     */
    public Connection getConnection() throws DBConnectionException {
        if (connection != null) {
            return connection;
        }
        try {
            Class.forName(driver);
            logger.info("Driver loaded");
        } catch (ClassNotFoundException e) {
            throw new DBConnectionException("Error loading driver!");
        }
        try {
            connection = DriverManager.getConnection(DB_URL, user, password);
            logger.info("Connection esteblished");
        } catch (SQLException e) {
            throw new DBConnectionException("Failed to establish connection");
        }
        if (connection == null) {
            throw new DBConnectionException("Driver type is not correct in URL " + DB_URL + ".");
        }

        return connection;
    }

    /**
     * closing connection to datbase
     *
     * @throws DBConnectionException if somthing goes wrong with closing connection
     */
    public void close() throws DBConnectionException {
        if (connection != null) {
            try {
                connection.close();
                logger.info("Connection closed");
            } catch (SQLException e) {
                throw new DBConnectionException("Can't close connection", e);
            }
        }
    }

}