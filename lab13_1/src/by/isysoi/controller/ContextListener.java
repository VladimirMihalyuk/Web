package by.isysoi.controller;

import by.isysoi.dao.BetDAOInterface;
import by.isysoi.dao.ClientDAOInterface;
import by.isysoi.dao.HorseDAOInterface;
import by.isysoi.dao.RaceDAOInterface;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    @EJB(mappedName = "by.isysoi.dao.HorseDAOInterface")
    private static HorseDAOInterface horseDAO;

    @EJB(mappedName = "by.isysoi.dao.RaceDAOInterface")
    private static RaceDAOInterface raceDAO;

    @EJB(mappedName = "by.isysoi.dao.ClientDAOInterface")
    private static ClientDAOInterface clientDAO;

    @EJB(mappedName = "by.isysoi.dao.BetDAOInterface")
    private static BetDAOInterface betDAO;

//    @PersistenceContext(unitName = "Test_Local")
//    private EntityManager entityManager;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext contex = servletContextEvent.getServletContext();

//        contex.setAttribute("horseDAO", new HorseDAO(entityManager));
//        contex.setAttribute("raceDAO", new RaceDAO(entityManager));
//        contex.setAttribute("clientDAO", new ClientDAO(entityManager));
//        contex.setAttribute("betDAO", new BetDAO(entityManager));

        contex.setAttribute("horseDAO", horseDAO);
        contex.setAttribute("raceDAO", raceDAO);
        contex.setAttribute("clientDAO", clientDAO);
        contex.setAttribute("betDAO", betDAO);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
