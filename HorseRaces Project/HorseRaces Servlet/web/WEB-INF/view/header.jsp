<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8"/>
<fmt:setLocale value="${userLocale}"/>
<fmt:setBundle basename="by.isysoi.locale"/>
<ul class="nav justify-content-end">
    <li class="nav-item">
        <div class="page-form">
            <form>
                <div class="form-group">
                    <select class="form-control" name='lang' onchange='this.form.submit()'>
                        <c:choose>
                        <c:when test="${userLocale.language == 'ru'}">
                        <option value='ru' selected>Русский
                        <option value='en'>English
                            </c:when>
                            <c:otherwise>
                        <option value='ru'>Русский
                        <option value='en' selected>English
                            </c:otherwise>
                            </c:choose>
                    </select>
                </div>
            </form>
        </div>
    </li>
</ul>
