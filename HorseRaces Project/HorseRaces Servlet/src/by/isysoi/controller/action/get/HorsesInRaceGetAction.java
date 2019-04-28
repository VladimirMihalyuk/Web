package by.isysoi.controller.action.get;

import by.isysoi.controller.NavigationConstants;
import by.isysoi.controller.action.Action;
import by.isysoi.dao.HorseDAOInterface;
import by.isysoi.exception.ActionException;
import by.isysoi.exception.DAOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class HorsesInRaceGetAction implements Action {

    @Override
    public String getPattern() {
        return "horsesInRace";
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ActionException {
        String raceId = request.getParameter("raceId");
        if (raceId != null) {
            HorseDAOInterface horseDAO = (HorseDAOInterface) servletContext.getAttribute("horseDAO");
            List list = null;
            try {
                list = horseDAO.readHorcesInRace(Integer.valueOf(raceId));
            } catch (DAOException e) {
                throw new ActionException(String.format("Horses from race %s not found due to exception", raceId), e);
            }
            request.setAttribute("horseInRaceList", list);
        }

        RequestDispatcher dispatcher = servletContext.getRequestDispatcher(NavigationConstants.horsePage);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new ActionException("Failed page forwarding", e);
        }
    }

}
