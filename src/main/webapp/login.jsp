<%--
  Created by IntelliJ IDEA.
  User: anastasia.kanischeva
  Date: 22.10.2018
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="css/flowershop.css">
</head>

<script type="text/javascript">
    function validateForm() {
        var a = document.forms["Form"]["inputUsername"].value;
        var b = document.forms["Form"]["inputPassword"].value;
        if (a == null || a === "") {
            alert("Please fill username field");
            return false;
        }
        if (b == null || b === "") {
            alert("Please fill password field");
            return false;
        }
    }
</script>


<body>
<div class="center hero-unit">
    <form class="form-horizontal" name="Form" method="post" onsubmit=" return validateForm()" action="login">
        <div class="form-group">
            <label for="inputUsername">Username</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputUsername" name="inputUsername" placeholder="Username">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword">Password</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="inputPassword" name="inputPassword"
                       placeholder="Password">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10"></div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" class="btn btn-large btn-primary"/> <br> <br>
                <a href="registration.jsp">Register</a>
            </div>
        </div>
    </form>
</div>
</body>

</html>
