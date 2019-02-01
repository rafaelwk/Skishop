<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <a href="${pageContext.request.contextPath}/">główna</a> ||

    <c:forEach items="${producttypes}" var="product">
    <li>
        <h2>${product.productType.name}</h2>
        <h3>${product.name}</h3>
        <h4>cena: ${product.price}</h4>

        <p>
            <c:if test="${user.adminUser == true}">
                <a href="${pageContext.request.contextPath}/product/edit/${product.id}">edytuj</a>
                <a href="${pageContext.request.contextPath}/product/delete/${product.id}">usuń</a>
            </c:if>
            <a href="${pageContext.request.contextPath}/cartItem/form/${product.id}">dodaj do koszyka</a>

        </p>

    </li>
    </c:forEach>
</body>
</html>
