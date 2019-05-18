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
    <script src="script/formsScript.js"></script>
</head>
<body>

<h1><fmt:message key="winnersPage.title"/></h1>

<div class="page-form">
    <form id="winners-in-race-form" lang="${userLocale.language}" action="${pageContext.request.contextPath}/serv">
    </form>
</div>

<c:if test="${!empty winnersByRace}">
    <div class="page-table">
        <table class="table">
            <thead>
            <tr>
                <th scope="col"><fmt:message key="table.id"/></th>
                <th scope="col"><fmt:message key="table.FIO"/></th>
                <th scope="col"><fmt:message key="table.bet"/></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${winnersByRace.entrySet()}" var="clientAndBets">
                <tr>
                    <td scope="col">${clientAndBets.getKey().getId()}</td>
                    <td scope="col">${clientAndBets.getKey().getFIO()}</td>
                    <td>
                        <table class="table">
                            <thead>
                            <tr>
                                <th scope="col"><fmt:message key="table.id"/></th>
                                <th scope="col"><fmt:message key="table.amount"/></th>
                                <th scope="col"><fmt:message key="table.race"/></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${clientAndBets.getValue()}" var="bet">
                                <tr>
                                    <td scope="col">${bet.getId()}</td>
                                    <td scope="col">${bet.getAmount()}</td>
                                    <td scope="col">${bet.getRace().getId()}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
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