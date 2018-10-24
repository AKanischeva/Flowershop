<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="css/flowershop.css">
    <title>Welcome</title>
</head>

<body>

<form class="form-container" name="Form" method="post" onsubmit=" return validateForm()" action="login">
    <div class="form-title"><h2>Sign up</h2></div>
    <div class="form-title">inputUsername</div>
    <input class="form-field" type="text" name="inputUsername"/><br/>
    <div class="form-title">inputPassword</div>
    <input class="form-field" type="password" name="inputPassword"/><br/>
    <div class="submit-container">
        <button type="submit" class="submit-button">Sign in</button>
        <a class="submit-button" href="registration.jsp">Register</a>
    </div>
</form>

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
</body>
</html>