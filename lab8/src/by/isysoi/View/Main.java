package by.isysoi.View;

import by.isysoi.Model.DAO.ClientDAO;
import by.isysoi.Model.Entity.Client;
import by.isysoi.Model.Exception.DAOException;

public class Main {

    public static void main(String[] args) {
        try {
            ClientDAO tmp = new ClientDAO();
            tmp.insertClient(new Client(4,"test1233"));
        } catch (DAOException e) {
            e.printStackTrace();

        }

    }
}
