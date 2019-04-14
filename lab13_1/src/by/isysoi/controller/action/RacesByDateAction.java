package by.isysoi.controller.action;

import by.isysoi.model.dao.RaceDAO;
import by.isysoi.model.entity.Race;

import javax.persistence.Persistence;
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

    final String urlPattern = "racesByDate";

    @Override
    public String getPattern() {
        return urlPattern;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/WEB-INF/view/races.jsp");
        String date = request.getParameter("date");
        if (date != null) {
            List<Race> list = null;
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
            try {
                list = (new RaceDAO(Persistence.createEntityManagerFactory("Test_Local")))
                        .readRacesByDate(ft.parse(date));
                request.setAttribute("racesByDateList", list);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        dispatcher.forward(request, response);
    }

}
