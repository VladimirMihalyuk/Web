package by.isysoi.tag;

import by.isysoi.entity.Horse;
import by.isysoi.entity.User;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;

/**
 * custom tag to show horses list
 *
 * @author Ilya Sysoi
 */
public class HorsesTableTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException {
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
                        + "<th scope=\"col\">Id</th>"
                        + "<th scope=\"col\">nickname</th>"
                        + "</tr >"
                        + "</thead >"
                        + "<tbody>";

                for (Horse h : horseInRaceList) {
                    result += "<tr>"
                            + "<td scope=\"col\">" + h.getId() + "</td>"
                            + "<td scope=\"col\">" + h.getNikname() + "</td>"
                            + "</tr>";
                }

                result += "</tbody>"
                        + "</table>"
                        + "</div>";
            } else {
                result += "<p>Ничего не найдено</p>";
            }

            try {
                JspWriter out = this.getJspContext().getOut();
                out.write(result);
            } catch (IOException e) {
                throw new JspException(e.getMessage());
            }
        }
    }

}