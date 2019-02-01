<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Users</h1>

<p><a href="${pageContext.request.contextPath}/">główna</a></p>
<TABLE>
    <tr>
        <td>Login</td><td>email</td>
    </tr>

    <c:forEach items="${users}" var="user">
        <tr>
        <td>${user.userName}</td>
        <td>${user.email}</td>
        <td><a href="${pageContext.request.contextPath}/user/form/${user.id}"></a>
            <c:if test="${user.adminUser != true}">
                <a href="${pageContext.request.contextPath}/user/delete/${user.id}">usuń</a>
            </c:if>
        </td>
        </tr>
    </c:forEach>

</TABLE>
</body>
</html>
