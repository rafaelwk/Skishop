<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                 modelAttribute="book"
                 cssClass="container col-2" >

    <form:hidden path="id" />
    <form:input path="firstName" placeholder="firstName" cssClass="form-input"/>
    <form:errors path="firstName" cssClass="alert"/>

    <form:input path="lastName" placeholder="lastName"  cssClass="form-input"/>
    <form:errors path="lastName" />

    <form:select path="tweet" multiple="true">
        <form:option value="0" disabled="true" selected="true">Wybierz tweet</form:option>
        <form:options  items="${tweets}"
                       itemValue="id"
                       itemLabel="title"/>
    </form:select>

    <form:input path="email" placeholder="email" />
    <form:errors path="email" />



    <input type="submit"  class="btn btn-success">
</form:form>
</body>
</html>
