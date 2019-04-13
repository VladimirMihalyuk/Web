<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Веб програмирование</title>
    <link rel="stylesheet" href="style/styles.css">
    <link crossorigin="anonymous" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" rel="stylesheet">
</head>
<body>

<h1>Вывести список забегов на указанную дату.</h1>

<div class="page-form">
    <form id="races-by-date-form" action="${pageContext.request.contextPath}">
    </form>
</div>

<c:if test="${!empty racesByDateList}">
    <div class="page-table">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">distance</th>
                <th scope="col">date</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${racesByDateList}" var="race">
                <tr>
                    <td scope="col">${race.getId()}</td>
                    <td scope="col">${race.getDistance()}</td>
                    <td scope="col">${race.getRaceDate()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</c:if>

<a href="${pageContext.request.contextPath}/serv?command=home"> На главную</a>

<script src="script/script.js"></script>

</body>
</html>