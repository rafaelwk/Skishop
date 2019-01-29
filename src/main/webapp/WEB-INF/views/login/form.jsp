<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>

    <title>Title</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <%--<style>--%>
    <%--input, select{--%>
    <%--display: block;--%>
    <%--margin:15px 0;--%>
    <%--width: 100%;--%>
    <%--}--%>
    <%--</style>--%>

</head>
<body>
<h1>Logowanie</h1>
<form:form method="post"
           action="${formAction}"
           modelAttribute="user"
           cssClass="container col-2" >

    <form:input path="userName" placeholder="username" cssClass="form-input"/>
    <form:errors path="userName" cssClass="alert"/>

    <form:input path="password" placeholder="password"  cssClass="form-input"/>
    <form:errors path="password" />

    <input type="submit"   class="btn btn-success">
</form:form>
</body>
</html>
