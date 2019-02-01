<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cartItem</title>
</head>
<body>
<h1>CartItem</h1>

<%--<c:if test="${not empty user}">--%>
    <%--<p>Hello, ${user.userName}</p>--%>
<%--</c:if>--%>

<ul>

    <c:set var="total" value="0.00" />

    <a href="${pageContext.request.contextPath}/">główna || </a>
    <c:forEach items="${productTypes}" var="productType">
        <a href="${pageContext.request.contextPath}/product/listtype/${productType.id}">${productType.name}</a>
    </c:forEach>

    <c:forEach items="${cartItems}" var="cartItem">
    <li>
        <h2>${cartItem.product.productType.name}</h2>
        <h3>${cartItem.product.name}</h3>
        <p>cena za sztuke: ${cartItem.product.price}</p>
        <p>ilość: ${cartItem.quantity} </p>
        <h3>Podsumowanie: ${cartItem.product.price}*${cartItem.quantity}=${cartItem.product.price*cartItem.quantity} </h3>
        <p>
            <a href="${pageContext.request.contextPath}/cartItem/delete/${cartItem.id}">usuń</a>
            <%--<a href="${pageContext.request.contextPath}/cartItem/form/${cartItem.id}">edytuj</a>--%>
        </p>
        <c:set var="total" value="${total + (cartItem.product.price*cartItem.quantity)}" />

    </li>
    </c:forEach>

</ul>


    <input:formatNumber value="${total}" pattern="#,##0.00" />
        <p>Suma wszystkich zakupów: ${total}zł</p>
    <a href="${pageContext.request.contextPath}/cart/summary/">przejdż do podsumowania</a>

</body>
</html>

