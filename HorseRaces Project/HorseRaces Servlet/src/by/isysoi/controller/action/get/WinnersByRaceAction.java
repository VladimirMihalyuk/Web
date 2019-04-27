package by.isysoi.controller.action.get;

import by.isysoi.controller.NavigationConstants;
import by.isysoi.controller.action.Action;
import by.isysoi.dao.BetDAOInterface;
import by.isysoi.exception.ActionException;
import by.isysoi.exception.DAOException;

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
            throws ActionException {
        String raceId = request.getParameter("raceId");
        if (raceId != null) {
            BetDAOInterface betDAO = (BetDAOInterface) servletContext.getAttribute("betDAO");
            Map map = null;
            try {
                map = betDAO.readWinnersByRace(Integer.valueOf(raceId));
            } catch (DAOException e) {
                throw new ActionException(String.format("Winners from race %s not found due to exception", raceId), e);
            }
            request.setAttribute("winnersByRace", map);
        }
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher(NavigationConstants.winnersPage);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new ActionException("Failed page forwarding", e);
        }
    }

}
