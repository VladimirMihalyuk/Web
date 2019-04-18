package by.isysoi.controller;

import by.isysoi.controller.action.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Main servlet of app
 *
 * @author Ilya Sysoi
 */
@WebServlet
public class MainServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private Map<String, Action> actions;

    public MainServlet() {
        super();
        this.actions = new HashMap<>();
    }

    @Override
    public void init() {
        Action[] actions = {new HomeAction(),
                new WinnersByRaceAction(),
                new SaveResultAction(),
                new RacesByDateAction(),
                new HorsesInRaceAction()};
        for (Action c : actions) {
            this.actions.put(c.getPattern(), c);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            startNewSessionAndSaveCookies(request, response);
            actions.get("home").doGet(request, response, this.getServletContext());
        } else if (actions.containsKey(action)) {
            actions.get(action).doGet(request, response, this.getServletContext());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            actions.get("home").doGet(request, response, this.getServletContext());
        } else if (actions.containsKey(action)) {
            actions.get(action).doPost(request, response, this.getServletContext());
        }
    }


    private void startNewSessionAndSaveCookies(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        Cookie lastEnterTime = new Cookie("lastEnterTime", new Date().toString());
        lastEnterTime.setComment("Информация о времени и дате последнего сеанса пользователя,");
        Cookie usageCount = new Cookie("usageCount", "1");
        usageCount.setComment("Информация о количестве посещений ресурса.");

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("usageCount")) {
                    int lastUsageCount = Integer.parseInt(cookie.getValue());
                    lastUsageCount += 1;
                    usageCount.setValue(Integer.toString(lastUsageCount));
                }
            }
        }
        response.addCookie(lastEnterTime);
        response.addCookie(usageCount);
    }

}
