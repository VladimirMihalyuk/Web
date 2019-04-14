package by.isysoi.controller;

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

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
