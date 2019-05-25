package by.isysoi.controller.action.post;

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

public class RemoveHorsePostAction implements Action {

    @Override
    public String getPattern() {
        return "removeHorse";
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ActionException {
        String horseId = request.getParameter("horseId");
        String raceId = request.getParameter("raceId");

        if (horseId != null) {
            HorseDAOInterface horseDAO = (HorseDAOInterface) servletContext.getAttribute("horseDAO");
            try {
                horseDAO.deleteHorse(Integer.parseInt(horseId), Integer.parseInt(raceId));
            } catch (DAOException e) {
                throw new ActionException(String.format("Failed to remove horse %s due to exception", horseId), e);
            }
        }

        RequestDispatcher dispatcher = servletContext.getRequestDispatcher(NavigationConstants.horsePage);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new ActionException("Failed page forwarding", e);
        }
    }
}