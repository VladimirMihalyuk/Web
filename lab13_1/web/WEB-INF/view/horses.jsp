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

<h1>Вывести список лошадей заданного забега.</h1>

<div class="page-form">
    <form id="horses-in-race-form" action="${pageContext.request.contextPath}">
    </form>
</div>

<c:if test="${!empty horseInRaceList}">
    <div class="page-table">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">nickname</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${horseInRaceList}" var="horse">
                <tr>
                    <td scope="col">${horse.getId()}</td>
                    <td scope="col">${horse.getNikname()}</td>
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