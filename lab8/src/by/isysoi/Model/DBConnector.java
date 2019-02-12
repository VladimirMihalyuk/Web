package by.isysoi.Model;

import by.isysoi.Model.Exception.DBConnectionException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnector {

    private final String DB_PROPERTIES = "database/database.properties";
    private final String driver;
    private final String DB_URL;
    private final String user;
    private final String password;
    private Connection connection;

    public DBConnector() throws DBConnectionException {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(DB_PROPERTIES));
        } catch (IOException e) {
            throw new DBConnectionException("Конфиг");
        }
        driver = properties.getProperty("driver");
        DB_URL = properties.getProperty("url");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
    }

    public Connection getConnection() throws DBConnectionException {
        if (connection != null) {
            return connection;
        }
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(DB_URL, user, password);
        } catch (ClassNotFoundException e) {
            throw new DBConnectionException("Драйвер не загружен!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBConnectionException("Соединение");
        }
        if (connection == null) {
            throw new DBConnectionException("Driver type is not correct in URL " + DB_URL + ".");
        }

        return connection;
    }

    public void close() throws DBConnectionException {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DBConnectionException("Can't close connection", e);
            }
        }
    }

}
