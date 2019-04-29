package by.isysoi.controller.action.post;

import by.isysoi.controller.NavigationConstants;
import by.isysoi.controller.action.Action;
import by.isysoi.dao.UserDAOInterface;
import by.isysoi.entity.User;
import by.isysoi.exception.ActionException;
import by.isysoi.exception.DAOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationPostAction implements Action {


    @Override
    public String getPattern() {
        return "registration";
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ActionException {
        User user = null;
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        RequestDispatcher dispatcher = null;
        if (login != null && password != null) {
            user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setType("client");

            UserDAOInterface userDAO = (UserDAOInterface) servletContext.getAttribute("userDAO");
            try {
                userDAO.registerUser(user);
            } catch (DAOException e) {
                throw new ActionException(String.format("Failed to register user with login - %s", login), e);
            }
            dispatcher = servletContext.getRequestDispatcher(NavigationConstants.loginPage);
        } else {
            dispatcher = servletContext.getRequestDispatcher(NavigationConstants.registrationPage);
        }

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new ActionException("Failed page forwarding", e);
        }
    }

}
