<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Веб програмирование</title>
    <link rel="stylesheet" href="style/styles.css">
    <link crossorigin="anonymous" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" rel="stylesheet">
</head>
<body>
<h1>Произошла ошибка</h1>
<p>${errorMessage}</p>
<c:choose>
    <c:when test="${empty sessionScope['user']}">
        <a href="${pageContext.request.contextPath}/serv?action=login">На авторизацию</a>
    </c:when>
    <c:otherwise>
        <a href="${pageContext.request.contextPath}/serv?action=home">На главную</a>
    </c:otherwise>
</c:choose>
</body>
</html>
