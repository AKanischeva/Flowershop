<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="css/flowershop.css">
    <title>Welcome</title>
    <style type="text/css">
        * {
            margin: 0;
            padding: 0;
        }

        p {
            padding: 10px;
        }

        #left {
            position: absolute;
            left: 0;
            top: 0;
            width: 50%;
        }

        #right {
            position: absolute;
            right: 0;
            top: 0;
            width: 50%;
        }
    </style>
</head>

<body>
<div class="row">
    <div id="left">
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
    </div>

    <div id="right">
        <img src="http://physt.tversu.ru/wp-content/uploads/2017/04/TvGU.png" width="200">
        <h2>Добро пожаловать на сайт дипломных работ ТвГУ. </h2>
        <br>
        <h2> Для просмотра работ, пожалуйста, войдите в свой аккаунт.<br> Если
            у
            Вас еще нет аккаунта, зарегистрируйтесь</h2>
    </div>
</div>

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
