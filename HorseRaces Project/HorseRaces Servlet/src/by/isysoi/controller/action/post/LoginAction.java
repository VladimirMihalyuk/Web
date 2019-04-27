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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class LoginAction implements Action {

    @Override
    public String getPattern() {
        return "login";
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ActionException {
        User user = null;
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (login != null && password != null) {
            if (login.isEmpty() && password.isEmpty()) {
                user = new User();
                user.setType("guest");
                user.setLogin("Гость");
            } else {
                UserDAOInterface userDAO = (UserDAOInterface) servletContext.getAttribute("userDAO");
                try {
                    user = userDAO.getUserInfo(login, password);
                } catch (DAOException e) {
                    throw new ActionException("Failed to check user", e);
                }
            }
        }

        String forwardPage;
        if (user != null) {
            startNewSessionAndSaveCookies(request, response, user);
            forwardPage = NavigationConstants.homePage;
        } else {
            forwardPage = NavigationConstants.loginPage;
        }
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher(forwardPage);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new ActionException("Failed page forwarding", e);
        }
    }

    private void startNewSessionAndSaveCookies(HttpServletRequest request, HttpServletResponse response, User user) {
        HttpSession session = request.getSession(true);
        session.setAttribute("user", user);
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
