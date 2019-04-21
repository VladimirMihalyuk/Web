package by.isysoi.controller;

import by.isysoi.dao.HorseDAOInterface;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    @EJB(mappedName = "by.isysoi.dao.HorseDAOInterface")
    private static HorseDAOInterface horseDAO;

//    @EJB(mappedName = "by.isysoi.dao.RaceDAOInterface")
//    private static RaceDAOInterface raceDAO;
//
//    @EJB(mappedName = "by.isysoi.dao.ClientDAOInterface")
//    private static ClientDAOInterface clientDAO;
//
//    @EJB(mappedName = "by.isysoi.dao.BetDAOInterface")
//    private static BetDAOInterface betDAO;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext contex = servletContextEvent.getServletContext();

        contex.setAttribute("horseDAO", horseDAO);
//        contex.setAttribute("raceDAO", raceDAO);
//        contex.setAttribute("clientDAO", clientDAO);
//        contex.setAttribute("betDAO", betDAO);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
