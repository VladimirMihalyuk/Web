<%@ page pageEncoding="UTF-8" %>
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

<h1>Зафиксировать состав и результаты забега.</h1>

<div class="page-form">
    <form id="update-horse-result-form" action="${pageContext.request.contextPath}/serv" method="POST">
    </form>
</div>

<a href="${pageContext.request.contextPath}/serv?action=home"> На главную</a>

<script src="script/script.js"></script>

</body>
</html>