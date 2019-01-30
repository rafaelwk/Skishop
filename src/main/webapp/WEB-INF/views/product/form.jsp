<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>boots</title>
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
           modelAttribute="product"
           cssClass="container col-2" >

    <form:hidden path="id" />

    <form:input path="name" placeholder="nazwa" cssClass="form-input"/>
    <form:errors path="name" cssClass="alert"/>

    <form:input path="price" placeholder="cena" cssClass="form-input"/>
    <form:errors path="price" />

    <form:input path="productType" placeholder="productType" cssClass="form-input"/>
    <form:errors path="productType" />

    <form:select path="cartItem"  cssClass="form-input">
    <form:option value="0" disabled="true" selected="true">Wybierz wydawcę</form:option>
    <form:options  items="${cartItems}"
                   itemValue="id"
                   itemLabel="name" />
    </form:form>



    <input type="submit"  class="btn btn-success">
</form:form>
</body>
</html>
