package by.isysoi.controller.command;

import by.isysoi.model.dao.HorseDAO;
import by.isysoi.model.entity.Horse;

import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class HorsesInRaceCommand implements Command {

    final String urlPattern = "horsesInRace";

    @Override
    public String getPattern() {
        return urlPattern;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/WEB-INF/view/horses.jsp");
        String raceId = request.getParameter("raceId");
        if (raceId != null) {
            List<Horse> list = null;
            list = (new HorseDAO(Persistence.createEntityManagerFactory("Test_Local")))
                    .readHorcesInRace(Integer.valueOf(raceId));
            request.setAttribute("horseInRaceList", list);
        }
        dispatcher.forward(request, response);
    }

}
