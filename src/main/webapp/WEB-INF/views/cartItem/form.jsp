<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>skies</title>
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
           modelAttribute="cartItem"
           cssClass="container col-2" >

    <form:hidden path="id" />

    <form:input path="quantity" placeholder="quantity" cssClass="form-input"/>
    <form:errors path="quantity" cssClass="alert"/>

    <form:input path="product" placeholder="product" cssClass="form-input"/>
    <form:errors path="product" />

    <form:input path="cart" placeholder="cart" cssClass="form-input"/>
    <form:errors path="cart" />


    <input type="submit"  class="btn btn-success">
</form:form>
</body>
</html>
