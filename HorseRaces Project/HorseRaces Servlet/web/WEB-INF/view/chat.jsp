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
    <script src="script/chatScript.js"></script>
</head>
<body>
<h1><fmt:message key="chatPage.title"/></h1>

<input type="hidden" id="senderId" value="${senderId}">
<div>
    <c:if test="${sessionScope['user'].getTypeString() == 'admin'}">
        <p>
            <fmt:message key="chatPage.adminInfo"/>
        </p>
    </c:if>
    <textArea id="chatWindow" rows="10" style="width: 44em;margin: 15px" readonly></textArea>
</div>
<div>
    <input type="text" id="chatInput" style="width: 40em;margin: 15px"/>
    <input id="sendBtn" type="button" class="btn btn-primary" value="<fmt:message key="button.send"/>"
           onclick="sendMessage()"/>
</div>

<a href="${pageContext.request.contextPath}/serv?action=home"><fmt:message key="app.toHome"/></a>

<script>lang = "${userLocale.language}"</script>

</body>
</html>
