package by.isysoi.controller;

import by.isysoi.model.dao.impl.BetDAO;
import by.isysoi.model.dao.impl.ClientDAO;
import by.isysoi.model.dao.impl.HorseDAO;
import by.isysoi.model.dao.impl.RaceDAO;

import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

//    @EJB
//    private static HorseDAOInterface horseDAO;
//
//    @EJB
//    private static RaceDAOInterface raceDAO;
//
//    @EJB
//    private static ClientDAOInterface clientDAO;
//
//    @EJB
//    private static BetDAOInterface betDAO;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext contex = servletContextEvent.getServletContext();

        contex.setAttribute("horseDAO", new HorseDAO(Persistence.createEntityManagerFactory("Test_Local")));
        contex.setAttribute("raceDAO", new RaceDAO(Persistence.createEntityManagerFactory("Test_Local")));
        contex.setAttribute("clientDAO", new ClientDAO(Persistence.createEntityManagerFactory("Test_Local")));
        contex.setAttribute("betDAO", new BetDAO(Persistence.createEntityManagerFactory("Test_Local")));
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
