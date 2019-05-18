package by.isysoi.tag;

import by.isysoi.entity.Horse;
import by.isysoi.entity.User;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * custom tag to show horses list
 *
 * @author Ilya Sysoi
 */
public class HorsesTableTag extends SimpleTagSupport {

    public void doTag() throws JspException {
        Locale loc = (Locale) getJspContext().getAttribute("userLocale", PageContext.SESSION_SCOPE);
        ResourceBundle bundle = ResourceBundle.getBundle("by.isysoi.locale", loc, this.getClass().getClassLoader());

        User user = (User) getJspContext().getAttribute("user", PageContext.SESSION_SCOPE);
        boolean isAdmin = user != null && user.getType() == User.UserType.ADMIN;
        List<Horse> horseInRaceList = (List<Horse>) getJspContext().getAttribute("horseInRaceList", PageContext.REQUEST_SCOPE);

        if (horseInRaceList != null) {
            String result = "";

            if (!horseInRaceList.isEmpty()) {
                result += "<div class=\"page-table\">"
                        + "<table class=\"table\">"
                        + "<thead>"
                        + "<tr>"
                        + "<th scope=\"col\">" + bundle.getString("table.id") + "</th>"
                        + "<th scope=\"col\">" + bundle.getString("table.nickname") + "</th>"
                        + (isAdmin ? "<th scope=\"col\">" + bundle.getString("table.delete") + "</th>" : "")
                        + "</tr >"
                        + "</thead >"
                        + "<tbody>";

                for (Horse h : horseInRaceList) {
                    result += "<tr>"
                            + "<td scope=\"col\">" + h.getId() + "</td>"
                            + "<td scope=\"col\">" + h.getNikname() + "</td>";
                    if (isAdmin) {
                        result += "<td>\n" +
                                "<form method=\"POST\"\n" +
                                "action=\"" + ((PageContext) getJspContext()).getServletContext().getContextPath() + "/serv?action=removeHorse\">\n" +
                                "<input type=\"hidden\" name=\"horseId\" value=\"" + h.getId() + "\">\n" +
                                "<button type=\"submit\" class=\"btn btn-primary\">" + bundle.getString("table.delete") + "</button>\n" +
                                "</form>\n" +
                                "</td>";
                    }
                    result += "</tr>";
                }

                result += "</tbody>"
                        + "</table>"
                        + "</div>";
            } else {
                result += "<p>" + bundle.getString("table.notFoundResults") + "</p>";
            }

            try {
                JspWriter out = getJspContext().getOut();
                out.write(result);
            } catch (IOException e) {
                throw new JspException(e.getMessage());
            }
        }
    }

}