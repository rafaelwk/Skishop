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
    <form:input path="title" placeholder="title" cssClass="form-input"/>
    <form:errors path="title" cssClass="alert"/>

    <form:input path="tweetText" placeholder="tweetText"  cssClass="form-input"/>
    <form:errors path="tweetText" />


    <form:input path="created" value="${tweet.birtday}" placeholder="created" />
    <form:input path="user"  placeholder="user" />




    <input type="submit"  class="btn btn-success">
</form:form>

</body>
</html>
