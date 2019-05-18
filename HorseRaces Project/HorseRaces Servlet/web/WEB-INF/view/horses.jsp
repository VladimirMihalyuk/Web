<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mytag" uri="/WEB-INF/tld/tableList.tld"%>
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

<h1><fmt:message key="horsesPage.title"/></h1>

<div class="page-form">
    <form id="horses-in-race-form" lang="${userLocale.language}" action="${pageContext.request.contextPath}/serv">
    </form>
</div>
<mytag:horsesTableTag/>


<a href="${pageContext.request.contextPath}/serv?action=home"><fmt:message key="app.toHome"/></a>

<script>
    dom("${userLocale.language}").initPage();
</script>

</body>
</html>