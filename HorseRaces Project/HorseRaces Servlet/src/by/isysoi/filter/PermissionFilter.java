package by.isysoi.filter;

import by.isysoi.controller.NavigationConstants;
import by.isysoi.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Filter to check if user logged or not
 *
 * @author Ilya Sysoi
 */
@WebFilter(filterName = "PermissionFilter", urlPatterns = {"/serv"})
public class PermissionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("user");
        String action = servletRequest.getParameter("action");

        if (user != null) {
            switch (user.getType()) {
                case ADMIN:
                    break;
                case GUEST:
                    if (action.equals("saveResult") || action.equals("winnersByRace")) {
                        RequestDispatcher dispatcher = servletRequest.getRequestDispatcher(NavigationConstants.homePage);
                        dispatcher.forward(servletRequest, servletResponse);
                        return;
                    }
                    break;
                case CLIENT:
                    if (action.equals("saveResult")) {
                        RequestDispatcher dispatcher = servletRequest.getRequestDispatcher(NavigationConstants.homePage);
                        dispatcher.forward(servletRequest, servletResponse);
                        return;
                    }
                    break;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}