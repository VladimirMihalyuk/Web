<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Веб програмирование</title>
    <link rel="stylesheet" href="style/styles.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<h1>Вывести список выигравших клиентов забега.</h1>

<div class="page-form">
    <form id="winners-in-race-form" action="${pageContext.request.contextPath}/serv">
    </form>
</div>

<c:if test="${!empty winnersByRace}">
    <div class="page-table">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">ФИО</th>
                <th scope="col">Ставки</th>
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
                                <th scope="col">Id</th>
                                <th scope="col">Сумма</th>
                                <th scope="col">Забег</th>
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

<a href="${pageContext.request.contextPath}/serv?action=home">На главную</a>

<script src="script/script.js"></script>

</body>
</html>