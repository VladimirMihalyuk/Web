package by.isysoi.controller;

import by.isysoi.controller.action.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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
        HttpSession session = request.getSession(true);
        String action = request.getParameter("action");
        if (action == null) {
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

}
