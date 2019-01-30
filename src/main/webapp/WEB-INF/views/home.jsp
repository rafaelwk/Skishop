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
            <p>Hello, ${user.userName}</p>
            <a href="${pageContext.request.contextPath}/productType/list/">dodaj produkt</a>
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
            <a href="${pageContext.request.contextPath}/productType/list/">Dodaj produkt</a>
            <a href="${pageContext.request.contextPath}/product/listboots/${buty}">Buty</a>

        <%--<a href="${pageContext.request.contextPath}/product/boot/form/">Buty</a>--%>
            <%--<a href="${pageContext.request.contextPath}/product/poles/form/">Kijki</a>--%>
            <%--<a href="${pageContext.request.contextPath}/product/ski/form/">Narty</a>--%>
        </div>
    </c:if>

</body>
</html>
