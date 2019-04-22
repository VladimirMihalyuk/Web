package by.isysoi.controller;

import by.isysoi.controller.action.*;
import by.isysoi.entity.User;
import by.isysoi.exception.ActionException;

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
                new LogoutAction(),
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
        User user = (User) request.getSession().getAttribute("user");
        String action = validActionForUserAndCurrentAction(user, request.getParameter("action"));
        try {
            actions.get(action).execute(request, response, this.getServletContext());
        } catch (ActionException e) {
            request.setAttribute("errorMessage", e.getMessage());
            response.sendError(500);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private String validActionForUserAndCurrentAction(User user, String action) {
        if (action == null) return "login";
        if (user == null) return "login";
        switch (user.getType()) {
            case ADMIN:
                return action;
            case GUEST:
                return action.equals("saveResult") || action.equals("winnersByRace") ? "home" : action;
            case CLIENT:
                return action.equals("saveResult") ? "home" : action;
        }
        return "login";
    }

}
