<%--
  Created by IntelliJ IDEA.
  User: anastasia.kanischeva
  Date: 24.10.2018
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Profile</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/flowershop.css">
</head>
<body>
<br>
<div class="row">
    <div class="col-sm-3" id="balance">
        <h2>Hello, ${username}</h2>
        <a href="flower"><img class="check" src="http://www.freeiconspng.com/uploads/red-flower-icon-18.png"
                              width="200px"></a><br><br>
        <form action="logout" method="post" id="logout">
            <input type="submit" value="Logout" class="btn btn-danger"/>
        </form>

    </div>

    <div class="col-sm-5">
        <div class="center" id="cart1">
            <h2>Your cart</h2>
            <div class="center" id="cart">
                <table class="table">
                    <thead bgcolor="#dc3545">
                    <tr>
                        <th>Item</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Cost</th>
                    </tr>
                    </thead>
                    <c:forEach items="${cart}" var="iter" varStatus="rowStatus">
                        <tr>
                            <td>${iter.flower.name}</td>
                            <td>${iter.flower.price} &#8381</td>
                            <td>${iter.amount}</td>
                            <td>${iter.cost} &#8381</td>
                            <c:set var="total" value="${total+iter.cost}"/>
                        </tr>
                    </c:forEach>
                </table>

                <label id="total">Total: ${total} &#8381</label><br>
                <c:set var="total" value="${total - total*(discount/100)}"/>
                <label id="totald">Total with discount: <fmt:formatNumber value="${total}" pattern="0"/> &#8381</label>
                <form action="flower">
                    <input type="submit" value="Edit cart" class="btn btn-outline-danger"/>
                </form>
                <hr>
                <form action="order" method="post" onsubmit="return validateForm()">
                    <input type="submit" value="Checkout" class="btn btn-danger"/>
                </form>
            </div>
        </div>
    </div>


    <div class="col-sm-3">
        <br><br>
        <h4>Balance: <%= request.getSession(false).getAttribute("balance")%> &#8381;
        </h4>
        <h4>Discount: <%= request.getSession(false).getAttribute("discount")%>%
        </h4>
    </div>
</div>
</body>

<script type="text/javascript">
    function validateForm() {

        if (parseInt('${total}') == 0) {
            alert("Cart is empty");
            return false;
        }
        if (parseInt('${total}') > parseInt('${balance}')) {
            alert("Not enough money");
            return false;
        }
    }
</script>
</html>