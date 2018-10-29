<%--
  Created by IntelliJ IDEA.
  User: anastasia.kanischeva
  Date: 24.10.2018
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
          integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link rel="stylesheet" href="css/flowershop.css">
</head>
<body>
<div class="center">
    <form id="order" action="order" method="post">
        <table class="table" id="fl">
            <thead bgcolor="#dc3545">
            <tr>
                <th>ID</th>
                <th>Username</th>
                <th>Create Date</th>
                <th>Complete Date</th>
                <th>Total</th>
                <th>Status</th>
            </tr>
            </thead>
            <c:forEach items="${order}" var="iter" varStatus="rowStatus">
                <tr>
                    <td>${iter.id}</td>
                    <td>${iter.user.username}</td>
                    <td>${iter.createDate}</td>
                    <td>${iter.completeDate}</td>
                    <td>${iter.subTotal}</td>
                    <td>${iter.status}</td>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>

</body>
</html>

