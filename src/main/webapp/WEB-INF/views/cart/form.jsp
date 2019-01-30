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
           modelAttribute="cart"
           cssClass="container col-2" >
    <%--<form:errors path="*" />--%>

    <form:hidden path="id" />
    <form:input path="quantity" placeholder="Ilość" cssClass="form-input"/>
    <form:errors path="quantity" cssClass="alert"/>

    <form:select path="binding"  cssClass="form-input">
        <form:option value="0" disabled="true" selected="true">Wybierz wiązania</form:option>
        <form:options  items="${bindings}"
                       itemValue="id"
                       itemLabel="name" />
    </form:select>
    <form:errors path="binding" />

    <%--<form:select path="authors" multiple="true">--%>
        <%--<form:option value="0" disabled="true" selected="true">Wybierz autora</form:option>--%>
    <%--<form:options  items="${authors}"--%>
                   <%--itemValue="id"--%>
                   <%--itemLabel="lastName"/>--%>
    <%--</form:select>--%>
    <%--<form:errors path="authors" />--%>




    <input type="submit"  class="btn btn-success">
</form:form>

</body>
</html>