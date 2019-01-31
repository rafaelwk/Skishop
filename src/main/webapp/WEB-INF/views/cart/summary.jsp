<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>carts</title>
</head>
<body>
<h1>Koszyk</h1>
<%--<a href="${pageContext.request.contextPath}/book/list"><h3>Books</h3></a>--%>
<%--<a href="${pageContext.request.contextPath}/publisher/list"><h3>Publisher</h3></a>--%>
<%--<a href="${pageContext.request.contextPath}/author/form">Dodaj</a>--%>
<c:if test="${not empty user}">
    <p>Hello, ${user.userName}</p>
</c:if>

<ul>
    <c:forEach items="${carts}" var="cart">
    <li>
        <h2>${cart.name}</h2>
        <p>
            <a href="${pageContext.request.contextPath}/cart/edit/${cart.id}">edytuj</a>
            <a href="${pageContext.request.contextPath}/cart/delete/${cart.id}">usuń</a>

        </p>
    </li>
    </c:forEach>



</body>
</html>

