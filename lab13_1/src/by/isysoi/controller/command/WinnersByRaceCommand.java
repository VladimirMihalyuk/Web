package by.isysoi.controller.command;

import by.isysoi.model.dao.BetDAO;
import by.isysoi.model.entity.Bet;
import by.isysoi.model.entity.Client;

import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class WinnersByRaceCommand implements Command {

    final String urlPattern = "winnersByRace";

    @Override
    public String getPattern() {
        return urlPattern;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/WEB-INF/view/winners.jsp");
        String raceId = request.getParameter("raceId");
        if (raceId != null) {
            Map<Client, Set<Bet>> map = null;
            map = (new BetDAO(Persistence.createEntityManagerFactory("Test_Local"))).readWinnersByRace(Integer.valueOf(raceId));
            request.setAttribute("winnersByRace", map);
        }
        dispatcher.forward(request, response);
    }

}
