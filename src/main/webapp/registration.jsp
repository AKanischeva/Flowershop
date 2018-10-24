<%--
  Created by IntelliJ IDEA.
  User: anastasia.kanischeva
  Date: 22.10.2018
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register form</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="css/flowershop.css">
</head>

<script type="text/javascript">
    function validateForm() {
        var a = document.forms["Form"]["inputUsername"].value;
        var b = document.forms["Form"]["inputPassword"].value;
        var c = document.forms["Form"]["inputCPassword"].value;
        var d = document.forms["Form"]["inputFullName"].value;
        var e = document.forms["Form"]["inputPhone"].value;
        var f = document.forms["Form"]["inputAddress"].value;
        if (a == null || a === "") {
            alert("Please fill username field");
            return false;
        }
        if (b == null || b === "") {
            alert("Please fill password field");
            return false;
        }
        if (b !== c) {
            alert("Passwords not equal");
            return false;
        }

    }
</script>


<body>
<div class="center hero-unit">
    <form class="form-container" method="post" name="Form" onsubmit="return validateForm()" action="registration"><br/>

        <label class="form-title" for="inputUsername">Username</label>
        <input type="text" class="form-field" id="inputUsername" name="inputUsername" placeholder="Username"><br/>


        <label class="form-title" for="inputPassword">Password</label>
        <input class="form-field" type="password" id="inputPassword" name="inputPassword" placeholder="Password"><br/>

        <label class="form-title" for="inputCPassword">Confirm password</label>
        <input class="form-field" type="password" id="inputCPassword" name="inputCPassword"
               placeholder="Confirm password"><br/>

        <label class="form-title" for="inputFullName">Full name</label>
        <input type="text" class="form-field" id="inputFullName" name="inputFullName" placeholder="Full name"><br/>

        <label class="form-title" for="inputPhone">Phone</label>
        <input type="text" class="form-field" id="inputPhone" name="inputPhone" placeholder="Phone"><br/>

        <label class="form-title" for="inputAddress">Address</label>
        <input type="text" class="form-field" id="inputAddress" name="inputAddress" placeholder="Address"><br/>

        <input type="submit" class="submit-button"/>
        <button type="button" name="back" class="submit-button" onclick="history.back()">back</button>
    </form>
</div>
</body>
</html>
