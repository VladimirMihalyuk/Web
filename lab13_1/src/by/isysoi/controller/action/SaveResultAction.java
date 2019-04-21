package by.isysoi.controller.action;

import by.isysoi.controller.NavigationConstants;
import by.isysoi.dao.RaceDAOInterface;

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
            throws ServletException, IOException {
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher(NavigationConstants.resultPage);
        String raceId = request.getParameter("raceId");
        String horseId = request.getParameter("horseId");
        String positionNumber = request.getParameter("positionNumber");
        if (raceId != null && positionNumber != null && horseId != null) {
            RaceDAOInterface raceDAO = (RaceDAOInterface) servletContext.getAttribute("raceDAO");
            raceDAO.setHoresPositionInRace(Integer.valueOf(horseId),
                    Integer.valueOf(raceId),
                    Integer.valueOf(positionNumber));
        }
        dispatcher.forward(request, response);
    }

}
