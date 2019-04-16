package by.isysoi.controller.action;

import by.isysoi.dao.BetDAOInterface;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class WinnersByRaceAction implements Action {

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
            BetDAOInterface betDAO = (BetDAOInterface) servletContext.getAttribute("betDAO");
            Map map = betDAO.readWinnersByRace(Integer.valueOf(raceId));
            request.setAttribute("winnersByRace", map);
        }
        dispatcher.forward(request, response);
    }

}
