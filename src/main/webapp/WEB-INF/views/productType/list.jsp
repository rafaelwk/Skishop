<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>productType</title>
</head>
<body>
<h1>Rodzaj produktu</h1>
<%--<a href="${pageContext.request.contextPath}/book/list"><h3>Books</h3></a>--%>
<%--<a href="${pageContext.request.contextPath}/publisher/list"><h3>Publisher</h3></a>--%>
<%--<a href="${pageContext.request.contextPath}/author/form">Dodaj</a>--%>
<c:if test="${not empty user}">
    <p>Hello, ${user.userName}</p>
</c:if>

<a href="${pageContext.request.contextPath}/">główna</a>
<a href="${pageContext.request.contextPath}/productType/form/">dodaj</a>

<ul>
    <c:forEach items="${productTypes}" var="productType">
    <li>
        <h2>${productType.name}</h2>
        <p>
            <a href="${pageContext.request.contextPath}/productType/edit/${productType.id}">edytuj</a>
            <a href="${pageContext.request.contextPath}/productType/delete/${productType.id}">usuń</a>

        </p>
    </li>
    </c:forEach>



</body>
</html>
