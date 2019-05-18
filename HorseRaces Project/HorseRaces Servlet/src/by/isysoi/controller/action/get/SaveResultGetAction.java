package by.isysoi.controller.action.get;

import by.isysoi.controller.NavigationConstants;
import by.isysoi.controller.action.Action;
import by.isysoi.exception.ActionException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SaveResultGetAction implements Action {


    @Override
    public String getPattern() {
        return "saveResult";
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ActionException {
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher(NavigationConstants.resultPage);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new ActionException("Failed page forwarding", e);
        }
    }

}
