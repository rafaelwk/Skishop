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

    <form:input path="password" placeholder="password"  cssClass="form-input"/>
    <input type="password" name="pwd2" placeholder="repeat password"/>
    <form:errors path="password" />

    <form:input path="email" placeholder="email" />
    <form:errors path="email" />

    <form:select path="cart"  cssClass="form-input">
        <form:option value="0" disabled="true" selected="true">Wybierz wybierz typ produktu</form:option>
        <form:options  items="${carts}"
                       itemValue="id"
                       itemLabel="name" />
    </form:select>

    <input type="submit"  class="btn btn-success">
</form:form>
</body>
</html>
