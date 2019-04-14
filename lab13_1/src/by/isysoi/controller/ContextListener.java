package by.isysoi.controller;

import by.isysoi.model.dao.BetDAOInterface;
import by.isysoi.model.dao.ClientDAOInterface;
import by.isysoi.model.dao.HorseDAOInterface;
import by.isysoi.model.dao.RaceDAOInterface;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    @EJB(mappedName = "HorseDAO")
    private static HorseDAOInterface horseDAO;

    @EJB(mappedName = "RaceDAO")
    private static RaceDAOInterface raceDAO;

    @EJB(mappedName = "ClientDAO")
    private static ClientDAOInterface clientDAO;

    @EJB(mappedName = "BetDAO")
    private static BetDAOInterface betDAO;


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext contex = servletContextEvent.getServletContext();

        contex.setAttribute("horseDAO", horseDAO);
        contex.setAttribute("raceDAO", raceDAO);
        contex.setAttribute("clientDAO", clientDAO);
        contex.setAttribute("betDAO", betDAO);

//        contex.setAttribute("horseDAO", new HorseDAO(Persistence.createEntityManagerFactory("Test_Local")));
//        contex.setAttribute("raceDAO", new RaceDAO(Persistence.createEntityManagerFactory("Test_Local")));
//        contex.setAttribute("clientDAO", new ClientDAO(Persistence.createEntityManagerFactory("Test_Local")));
//        contex.setAttribute("betDAO", new BetDAO(Persistence.createEntityManagerFactory("Test_Local")));
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
