<%--
  Created by IntelliJ IDEA.
  User: anastasia.kanischeva
  Date: 24.10.2018
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.math.BigDecimal" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
          integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/flowershop.css">
</head>
<body>
<div class="row">
    <div class="col-sm-4">
        <div class="center">
            <a class="submit-button" href="flower">Flowers</a>

            <br>
            <h2><label>Hello, <%=(String) request.getAttribute("un")%>
            </label></h2><br>
            <label>Your balance: <%=(BigDecimal) request.getAttribute("bal")%>
            </label><br>
            <label>Your discount: <%=(Integer) request.getAttribute("disc")%>
            </label>

            <form action="logout" method="post">
                <input type="submit" value="Logout" class="submit-button"/>
            </form>
        </div>
    </div>

    <div class="col-sm-8">
        <div class="center">
            <table class="table">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                </tr>
            </table>
        </div>
    </div>
</div>
</body>
</html>