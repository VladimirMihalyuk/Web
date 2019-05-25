package by.isysoi.controller;

import by.isysoi.dao.impl.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    public ContextListener() {
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext contex = servletContextEvent.getServletContext();

        HorseDAORestfulWrapper horseDAO = new HorseDAORestfulWrapper();
        RaceDAORestfulWrapper raceDAO = new RaceDAORestfulWrapper();
        ClientDAORestfulWrapper clientDAO = new ClientDAORestfulWrapper();
        BetDAORestfulWrapper betDAO = new BetDAORestfulWrapper();
        UserDAORestfulWrapper userDAO = new UserDAORestfulWrapper();

        contex.setAttribute("horseDAO", horseDAO);
        contex.setAttribute("raceDAO", raceDAO);
        contex.setAttribute("clientDAO", clientDAO);
        contex.setAttribute("betDAO", betDAO);
        contex.setAttribute("userDAO", userDAO);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}