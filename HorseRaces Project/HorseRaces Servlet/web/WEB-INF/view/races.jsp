<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8"/>
<fmt:setLocale value="${userLocale}"/>
<fmt:setBundle basename="by.isysoi.locale"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="app.title"/></title>
    <link rel="stylesheet" href="style/styles.css">
    <link crossorigin="anonymous" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" rel="stylesheet">
    <script src="script/script.js"></script>
</head>
<body>

<h1><fmt:message key="racesPage.title"/></h1>

<div class="page-form">
    <form id="races-by-date-form" lang="${userLocale.language}" action="${pageContext.request.contextPath}/serv">
    </form>
</div>

<c:if test="${!empty racesByDateList}">
    <div class="page-table">
        <table class="table">
            <thead>
            <tr>
                <th scope="col"><fmt:message key="table.id"/></th>
                <th scope="col"><fmt:message key="table.distance"/>distance</th>
                <th scope="col"><fmt:message key="table.date"/>date</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${racesByDateList}" var="race">
                <tr>
                    <td scope="col">${race.getId()}</td>
                    <td scope="col">${race.getDistance()}</td>
                    <td scope="col"><fmt:formatDate pattern="dd-MM-yyyy"
                                                    value="${race.getRaceDate()}"/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</c:if>

<a href="${pageContext.request.contextPath}/serv?action=home"><fmt:message key="app.toHome"/></a>

<script>
    dom("${userLocale.language}").initPage();
</script>

</body>
</html>