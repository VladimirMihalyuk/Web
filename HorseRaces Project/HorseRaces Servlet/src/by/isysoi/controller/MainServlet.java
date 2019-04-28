package by.isysoi.controller;

import by.isysoi.controller.action.Action;
import by.isysoi.controller.action.get.*;
import by.isysoi.controller.action.post.LoginPostAction;
import by.isysoi.controller.action.post.LogoutAction;
import by.isysoi.controller.action.post.RegistrationPostAction;
import by.isysoi.controller.action.post.SaveResultPostAction;
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
    private Map<String, Action> getActions;
    private Map<String, Action> postActions;

    public MainServlet() {
        super();
        this.getActions = new HashMap<>();
        this.postActions = new HashMap<>();
    }

    @Override
    public void init() {
        Action[] getActions = {
                new HomeGetAction(),
                new LoginGetAction(),
                new WinnersByRaceGetAction(),
                new RacesByDateGetAction(),
                new HorsesInRaceGetAction(),
                new RegistrationGetAction()
        };
        for (Action c : getActions) {
            this.getActions.put(c.getPattern(), c);
        }

        Action[] postActions = {
                new LoginPostAction(),
                new LogoutAction(),
                new SaveResultPostAction(),
                new RegistrationPostAction()
        };
        for (Action c : postActions) {
            this.postActions.put(c.getPattern(), c);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //User user = (User) request.getSession().getAttribute("user");
        String action = request.getParameter("action");//validActionForUserAndCurrentAction(user, request.getParameter("action"));
        try {
            getActions.get(action).execute(request, response, this.getServletContext());
        } catch (ActionException e) {
            request.setAttribute("errorMessage", e.getMessage());
            response.sendError(500);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //User user = (User) request.getSession().getAttribute("user");
        String action = request.getParameter("action");//validActionForUserAndCurrentAction(user, request.getParameter("action"));
        try {
            postActions.get(action).execute(request, response, this.getServletContext());
        } catch (ActionException e) {
            request.setAttribute("errorMessage", e.getMessage());
            response.sendError(500);
        }
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
