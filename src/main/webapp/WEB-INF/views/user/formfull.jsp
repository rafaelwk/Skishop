<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <style>
        input, select{
            display: block;
            margin:15px 0;
            width: 100%;
        }
    </style>
</head>
<body>

<form:form method="post"
                 action="${formAction}"
                 modelAttribute="user"
                 cssClass="container col-2" >

    <form:hidden path="id" />
    <form:input path="userName" placeholder="userName" cssClass="form-input"/>
    <form:errors path="userName" cssClass="alert"/>

    <form:hidden path="password" placeholder="password"  cssClass="form-input"/>
    <%--<input type="password" name="pwd2" placeholder="repeat password"/>--%>
    <%--<form:errors path="password" />--%>

    <form:input path="firstName" placeholder="imię" />
    <form:errors path="firstName" />

    <form:input path="lastName" placeholder="nazwisko" />
    <form:errors path="lastName" />

    <form:input path="city" placeholder="miasto" />
    <form:errors path="city" />

    <form:input path="street" placeholder="ulica" />
    <form:errors path="street" />

    <form:input path="nr" placeholder="nr" />
    <form:errors path="nr" />

    <form:input path="postCode" placeholder="kod pocztowy" />
    <form:errors path="postCode" />

    <form:input path="email" placeholder="email" />
    <form:errors path="email" />


    <input type="submit"  class="btn btn-success">
</form:form>
</body>
</html>
