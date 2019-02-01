<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Send</title>
</head>
<body><h1>Send</h1>

<p> koszyk należy do: ${cart.user.firstName} ${cart.user.lastName}</p>

<div>
    <h2>Produkty</h2>
    <TABLE>
        <tr>
            <th>Produkt</th>
            <th>Marka</th>
            <th>Ilość</th>
            <th>Cena szt</th>
            <th>Suma prod</th>
        </tr>
        <c:forEach items="${cartItems}" var="cartItem">
            <tr>
                <td>${cartItem.product.productType.name}</td>
                <td>${cartItem.product.name}</td>
                <td>${cartItem.quantity}</td>
                <td>${cartItem.product.price}</td>
                <td>${cartItem.product.price*cartItem.quantity}</td>
            </tr>
        </c:forEach>
        <tr>
            <th></th>
            <th></th>
            <th></th>
            <th>SUMA:</th>
            <th>${sum}</th>
        </tr>
    </TABLE>


    <h2>Dane do wysyłki</h2>
    <div>
        <p>Pan: ${user.firstName} ${user.lastName}</p>
        <p>ul: ${user.street} nr ${user.nr}</p>
        <p>${user.postCode} ${user.city}</p>
    </div>

    <a href="${pageContext.request.contextPath}/cart/finish">zatwierdż</a>
</div>

</body>
</html>
