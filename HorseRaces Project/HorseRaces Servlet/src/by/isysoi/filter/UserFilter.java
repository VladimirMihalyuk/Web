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
@WebFilter(filterName = "UserSessionCheck", urlPatterns = {"/serv"})
public class UserFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("user");
        String action = servletRequest.getParameter("action");
        if (user == null && !(action == null || action.equals("login") || action.equals("registration"))) {
            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher(NavigationConstants.infoPage);
            dispatcher.forward(servletRequest, servletResponse);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
