package by.isysoi.controller.action.post;

import by.isysoi.controller.NavigationConstants;
import by.isysoi.controller.action.Action;
import by.isysoi.dao.RaceDAOInterface;
import by.isysoi.exception.ActionException;
import by.isysoi.exception.DAOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SaveResultAction implements Action {


    @Override
    public String getPattern() {
        return "saveResult";
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ActionException {
        String raceId = request.getParameter("raceId");
        String horseId = request.getParameter("horseId");
        String positionNumber = request.getParameter("positionNumber");
        if (raceId != null && positionNumber != null && horseId != null) {
            RaceDAOInterface raceDAO = (RaceDAOInterface) servletContext.getAttribute("raceDAO");
            try {
                raceDAO.setHoresPositionInRace(Integer.valueOf(horseId),
                        Integer.valueOf(raceId),
                        Integer.valueOf(positionNumber));
            } catch (DAOException e) {
                throw new ActionException(String.format("Failed to save result of horse %s in race %s with position %s due to exception", horseId, raceId, positionNumber), e);
            }
        }
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher(NavigationConstants.resultPage);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new ActionException("Failed page forwarding", e);
        }
    }

}
