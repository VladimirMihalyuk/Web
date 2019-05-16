<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</head>
<body>
<h1><fmt:message key="app.author"/></h1>
<p><fmt:message key="app.info"/></p>
<ul>
    <li>
        <a href="${pageContext.request.contextPath}/serv?action=horsesInRace"><fmt:message
                key="homePage.horsesInRace"/></a>
    </li>
    <li>
        <a href="${pageContext.request.contextPath}/serv?action=racesByDate"><fmt:message
                key="homePage.racesByDate"/></a>
    </li>
    <c:if test="${sessionScope['user'].getTypeString() == 'client' || sessionScope['user'].getTypeString() == 'admin'}">
        <li>
            <a href="${pageContext.request.contextPath}/serv?action=winnersByRace"><fmt:message
                    key="homePage.winnersByRace"/></a>
        </li>
    </c:if>
    <c:if test="${sessionScope['user'].getTypeString() == 'admin'}">
        <li>
            <a href="${pageContext.request.contextPath}/serv?action=saveResult"><fmt:message
                    key="homePage.saveResult"/></a>
        </li>
    </c:if>
</ul>

<p>
    Последний заход: ${cookie['lastEnterTime'].getValue()}
<p>
<p>
    Количество посещений: ${cookie['usageCount'].getValue()}
</p>

<p
<c:if test="${sessionScope['user'].getTypeString() == 'guest'}">
        style="color:red"
</c:if>
><fmt:message key="homePage.user"/> ${sessionScope['user'].getLogin()}<p>

<div class="page-form">
    <form id="logout-form" action="${pageContext.request.contextPath}/serv" method="POST">
    </form>
</div>

<script src="script/script.js"></script>
</body>
</html>