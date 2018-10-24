<%--
  Created by IntelliJ IDEA.
  User: anastasia.kanischeva
  Date: 24.10.2018
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
          integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link rel="stylesheet" href="css/flowershop.css">
    <title>Flowers</title>
</head>

<body>
<div>
    <table class="table">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
        </tr>
        <c:forEach items="${f}" var="iter" varStatus="rowStatus">

            <tr>
                <td>${iter.id}</td>
                <td>${iter.name}</td>
                <td>${iter.price}</td>
                <td>${iter.quantity}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<button type="button" name="back" class="submit-button" onclick="history.back()">back</button>
</body>

</html>