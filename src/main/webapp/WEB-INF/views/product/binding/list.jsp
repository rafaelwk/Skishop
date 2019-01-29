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
<ul>
    <c:forEach items="${bindings}" var="binding">
    <li>
        <h2>${binding.name}</h2>
        <p>
            <a href="${pageContext.request.contextPath}/product/binding/edit/${binding.id}">edytuj</a>
            <a href="${pageContext.request.contextPath}/product/binding/delete/${binding.id}">usuń</a>

        </p>
    </li>
    </c:forEach>



</body>
</html>
</body>
</html>
