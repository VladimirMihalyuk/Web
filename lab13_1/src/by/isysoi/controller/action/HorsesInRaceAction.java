package by.isysoi.controller.action;

import by.isysoi.model.dao.HorseDAOInterface;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * HorsesInRace Action Interface
 *
 * @author Ilya Sysoi
 */
public class HorsesInRaceAction implements Action {

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
            HorseDAOInterface horseDAO = (HorseDAOInterface) servletContext.getAttribute("horseDAO");
            List list = horseDAO.readHorcesInRace(Integer.valueOf(raceId));
            request.getSession().setAttribute("horseInRaceList", list);
        }
        dispatcher.forward(request, response);
    }

}
