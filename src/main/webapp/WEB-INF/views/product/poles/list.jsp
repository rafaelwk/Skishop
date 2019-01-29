<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>boots</title>
</head>
<body>
<h1>Kijki</h1>
<%--<a href="${pageContext.request.contextPath}/book/list"><h3>Books</h3></a>--%>
<%--<a href="${pageContext.request.contextPath}/publisher/list"><h3>Publisher</h3></a>--%>
<%--<a href="${pageContext.request.contextPath}/author/form">Dodaj</a>--%>
<c:if test="${not empty user}">
    <p>Hello, ${user.userName}</p>
</c:if>

<ul>
    <c:forEach items="${poles}" var="poles">
    <li>
        <h2>${poles.name}</h2>
        <p>
            <a href="${pageContext.request.contextPath}/product/poles/edit/${poles.id}">edytuj</a>
            <a href="${pageContext.request.contextPath}/product/poles/delete/${poles.id}">usuń</a>

        </p>
    </li>
    </c:forEach>



</body>
</html>

