package by.isysoi.controller.command;

import by.isysoi.model.dao.HorseDAO;
import by.isysoi.model.dao.RaceDAO;
import by.isysoi.model.entity.Horse;
import by.isysoi.model.entity.Race;

import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RacesByDateCommand implements Command {

    final String urlPattern = "racesByDate";

    @Override
    public String getPattern() {
        return urlPattern;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/view/races.jsp");
        List<Race> list = null;
        list = (new RaceDAO(Persistence.createEntityManagerFactory("Test_Local"))).readRaces();
        request.setAttribute("racesByDateList", list);
        dispatcher.forward(request, response);
    }

}
