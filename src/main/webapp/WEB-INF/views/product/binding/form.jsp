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
                 modelAttribute="binding"
                 cssClass="container col-2" >

    <form:hidden path="id" />

    <form:input path="name" placeholder="name" cssClass="form-input"/>
    <form:errors path="name" cssClass="alert"/>

    <form:input path="activites" placeholder="activites" cssClass="form-input"/>
    <form:errors path="activites" cssClass="alert"/>

    <form:input path="color" placeholder="color"  cssClass="form-input"/>
    <form:errors path="color" />

    <form:input path="price" placeholder="price" />
    <form:errors path="price" />

    <input type="submit"  class="btn btn-success">
</form:form>
</body>
</html>
