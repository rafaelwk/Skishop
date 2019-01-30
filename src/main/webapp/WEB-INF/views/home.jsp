<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>

    <title>Title</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

</head>
<body>
    <h1>Skishop</h1>



    <c:if test="${not empty user}">
        <div>
            <p>Hello, ${user.userName}, ${user.adminUser}</p>
        <c:if test="${user.adminUser == true}">
                <a href="${pageContext.request.contextPath}/productType/list/">dodaj produkt</a>
        </c:if>
            <c:forEach items="${productTypes}" var="productType">
                <a href="${pageContext.request.contextPath}/product/listtype/${productType.id}">${productType.name}</a>
            </c:forEach>

        </div>
        <div>
            <a href="${pageContext.request.contextPath}/login/logout/">wyloguj się</a>
        </div>

    </c:if>

    <c:if test="${empty user}">

        <div>
            <a href="${pageContext.request.contextPath}/login/form/">Zaloguj się</a>
            <a href="${pageContext.request.contextPath}/user/form/${user.password}">Zarejstruj się</a>
        </div>
        <div>
            <c:forEach items="${productTypes}" var="productType">
                <a href="${pageContext.request.contextPath}/product/listtype/${productType.id}">${productType.name}</a>
            </c:forEach>
        </div>
    </c:if>

</body>
</html>
