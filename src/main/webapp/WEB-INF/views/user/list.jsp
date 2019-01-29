<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Users</h1>
<TABLE>
    <tr>
        <td>imie</td><td>nazwisko</td><td>email</td><td>akcja</td>
    </tr>
    <tr>
    <c:forEach items="${users}" var="author">
        <td>${user.firstName}</td>
        <td>${user.lastName}</td>
        <td>${user.email}</td>
        <td><a href="${pageContext.request.contextPath}/author/form/${author.id}">edytuj</a> <a href="${pageContext.request.contextPath}/author/delete/${author.id}">usuń</a></td>


    </c:forEach>
    </tr>
</TABLE>
</body>
</html>
