<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>binding</title>
</head>
<body>
<h1>Binding</h1>
<%--<a href="${pageContext.request.contextPath}/book/list"><h3>Books</h3></a>--%>
<%--<a href="${pageContext.request.contextPath}/publisher/list"><h3>Publisher</h3></a>--%>
<%--<a href="${pageContext.request.contextPath}/author/form">Dodaj</a>--%>
<c:if test="${not empty user}">
    <p>Hello, ${user.userName}</p>
</c:if>
<ul>
    <c:forEach items="${bindings}" var="binding">
    <li>
        <h2>${binding.name}</h2>
        <p>
            <a href="${pageContext.request.contextPath}/product/binding/edit/${binding.id}">edytuj</a>
            <a href="${pageContext.request.contextPath}/product/binding/delete/${binding.id}">usuń</a>
            <c:if test="${not empty user}">
            <a href="${pageContext.request.contextPath}/cart/form/">Dodaj do koszyka</a>
            </c:if>
            <c:if test="${empty user}">
            <a href="${pageContext.request.contextPath}/login/form/">Dodaj do koszyka</a>
            </c:if>
        </p>
    </li>
    </c:forEach>



</body>
</html>
