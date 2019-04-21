package by.isysoi.controller;

import by.isysoi.dao.*;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {
    @EJB(
            name = "by.isysoi.model.dao.HorseDAOInterface"
    )
    private HorseDAOInterface horseDAO;
    @EJB(
            name = "by.isysoi.dao.ClientDAOInterface"
    )
    private ClientDAOInterface clientDAO;
    @EJB(
            name = "by.isysoi.dao.BetDAOInterface"
    )
    private BetDAOInterface betDAO;
    @EJB(
            name = "by.isysoi.dao.RaceDAOInterface"
    )
    private RaceDAOInterface raceDAO;

    @EJB(
            name = "by.isysoi.model.dao.UserDAOInterface"
    )
    private UserDAOInterface userDAO;

    public ContextListener() {
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext contex = servletContextEvent.getServletContext();
        contex.setAttribute("horseDAO", this.horseDAO);
        contex.setAttribute("raceDAO", this.raceDAO);
        contex.setAttribute("clientDAO", this.clientDAO);
        contex.setAttribute("betDAO", this.betDAO);
        contex.setAttribute("userDAO", this.userDAO);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}