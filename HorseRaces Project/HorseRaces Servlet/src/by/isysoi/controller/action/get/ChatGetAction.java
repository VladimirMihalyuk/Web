package by.isysoi.controller.action.get;

import by.isysoi.controller.NavigationConstants;
import by.isysoi.controller.action.Action;
import by.isysoi.entity.User;
import by.isysoi.exception.ActionException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChatGetAction implements Action {

    @Override
    public String getPattern() {
        return "chat";
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ActionException {
        User user = (User) request.getSession().getAttribute("user");

        request.setAttribute("senderId", user.getLogin());
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher(NavigationConstants.chatPage);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new ActionException("Failed page forwarding", e);
        }
    }
}
