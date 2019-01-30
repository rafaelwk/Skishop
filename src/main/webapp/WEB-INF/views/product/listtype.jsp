<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <h2>${product.productType.name}</h2>
    <c:forEach items="${producttypes}" var="product">
    <li>
        <h3>${product.name}</h3>
        <h4>cena: ${product.price}</h4>

        <p>
            <a href="${pageContext.request.contextPath}/product/edit/${product.id}">edytuj</a>
            <a href="${pageContext.request.contextPath}/product/delete/${product.id}">usuń</a>
            <a href="${pageContext.request.contextPath}/cartItem/form/">dodaj do koszyka</a>

        </p>
    </li>
    </c:forEach>
</body>
</html>
