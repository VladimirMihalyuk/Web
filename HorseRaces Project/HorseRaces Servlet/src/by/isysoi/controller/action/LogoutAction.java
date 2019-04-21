package by.isysoi.controller.action;

import by.isysoi.controller.NavigationConstants;
import by.isysoi.exception.ActionException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutAction implements Action {

    @Override
    public String getPattern() {
        return "logout";
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ActionException {
        request.getSession().setAttribute("user", null);
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher(NavigationConstants.loginPage);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new ActionException("Failed page forwarding", e);
        }
    }
}
