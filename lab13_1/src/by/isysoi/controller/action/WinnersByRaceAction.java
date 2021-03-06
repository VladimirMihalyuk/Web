package by.isysoi.controller.action;

import by.isysoi.controller.NavigationConstants;
import by.isysoi.dao.BetDAOInterface;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class WinnersByRaceAction implements Action {

    @Override
    public String getPattern() {
        return "winnersByRace";
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher(NavigationConstants.winnersPage);
        String raceId = request.getParameter("raceId");
        if (raceId != null) {
            BetDAOInterface betDAO = (BetDAOInterface) servletContext.getAttribute("betDAO");
            Map map = betDAO.readWinnersByRace(Integer.valueOf(raceId));
            request.setAttribute("winnersByRace", map);
        }
        dispatcher.forward(request, response);
    }

}
