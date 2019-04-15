package by.isysoi.controller;

import by.isysoi.model.dao.impl.BetDAO;
import by.isysoi.model.dao.impl.ClientDAO;
import by.isysoi.model.dao.impl.HorseDAO;
import by.isysoi.model.dao.impl.RaceDAO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
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

    @PersistenceContext(unitName = "Test_Local")
    private EntityManager entityManager;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext contex = servletContextEvent.getServletContext();

        contex.setAttribute("horseDAO", new HorseDAO(entityManager));
        contex.setAttribute("raceDAO", new RaceDAO(entityManager));
        contex.setAttribute("clientDAO", new ClientDAO(entityManager));
        contex.setAttribute("betDAO", new BetDAO(entityManager));

//        contex.setAttribute("horseDAO", horseDAO);
//        contex.setAttribute("raceDAO", raceDAO);
//        contex.setAttribute("clientDAO", clientDAO);
//        contex.setAttribute("betDAO", betDAO);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
