package by.isysoi.controller.action;

import by.isysoi.controller.NavigationConstants;
import by.isysoi.dao.RaceDAOInterface;
import by.isysoi.exception.ActionException;
import by.isysoi.exception.DAOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class RacesByDateAction implements Action {


    @Override
    public String getPattern() {
        return "racesByDate";
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ActionException {
        String date = request.getParameter("date");
        if (date != null) {
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
            RaceDAOInterface raceDAO = (RaceDAOInterface) servletContext.getAttribute("raceDAO");
            try {
                List list = raceDAO.readRacesByDate(ft.parse(date));
                request.setAttribute("racesByDateList", list);
            } catch (ParseException e) {
                throw new ActionException("Failed to cast date to format \"yyyy-MM-dd\"", e);
            } catch (DAOException e) {
                throw new ActionException(String.format("Races by date %s not found due to exception", date), e);
            }
        }
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher(NavigationConstants.racesPage);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new ActionException("Failed page forwarding", e);
        }
    }

}
