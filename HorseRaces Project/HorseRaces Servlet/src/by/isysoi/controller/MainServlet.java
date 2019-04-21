package by.isysoi.controller;

import by.isysoi.controller.action.*;
import by.isysoi.exception.ActionException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
                new LoginAction(),
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
        try {
            actions.get(action == null ? "login" : action).execute(request, response, this.getServletContext());
        } catch (ActionException e) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(NavigationConstants.errorPage);
            request.setAttribute("errorMessage", e.getMessage());
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            actions.get(action == null ? "login" : action).execute(request, response, this.getServletContext());
        } catch (ActionException e) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(NavigationConstants.errorPage);
            request.setAttribute("errorMessage", e.getMessage());
            dispatcher.forward(request, response);
        }
    }

}
