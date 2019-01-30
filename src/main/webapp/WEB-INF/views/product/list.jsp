<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>product</title>
</head>
<body>
<h1>Produkt</h1>
<%--<a href="${pageContext.request.contextPath}/book/list"><h3>Books</h3></a>--%>
<%--<a href="${pageContext.request.contextPath}/publisher/list"><h3>Publisher</h3></a>--%>
<%--<a href="${pageContext.request.contextPath}/author/form">Dodaj</a>--%>
<c:if test="${not empty user}">
    <p>Hello, ${user.userName}</p>
</c:if>

<a href="${pageContext.request.contextPath}/">główna</a>
<a href="${pageContext.request.contextPath}/product/form/">dodaj</a>

<ul>
    <c:forEach items="${products}" var="product">
    <li>
        <h2>${product.name}</h2>
        <p>
            <a href="${pageContext.request.contextPath}/product/edit/${product.id}">edytuj</a>
            <a href="${pageContext.request.contextPath}/product/delete/${product.id}">usuń</a>
            <a href="${pageContext.request.contextPath}/cartItem/form/">dodaj do koszyka</a>

        </p>
    </li>
    </c:forEach>



</body>
</html>

