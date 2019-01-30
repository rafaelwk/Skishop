<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cartItem</title>
</head>
<body>
<h1>CartItem</h1>
<%--<a href="${pageContext.request.contextPath}/book/list"><h3>Books</h3></a>--%>
<%--<a href="${pageContext.request.contextPath}/publisher/list"><h3>Publisher</h3></a>--%>
<%--<a href="${pageContext.request.contextPath}/author/form">Dodaj</a>--%>
<c:if test="${not empty user}">
    <p>Hello, ${user.userName}</p>
</c:if>

<ul>
    <c:forEach items="${cartItems}" var="cartItem">
    <li>
        <h2>${cartItem.name}</h2>
        <p>
            <a href="${pageContext.request.contextPath}/cartItem/edit/${cartItem.id}">edytuj</a>
            <a href="${pageContext.request.contextPath}/cartItem/delete/${cartItem.id}">usuń</a>

        </p>
    </li>
    </c:forEach>



</body>
</html>

