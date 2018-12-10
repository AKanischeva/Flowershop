<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: anastasia.kanischeva
  Date: 24.10.2018
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<head>
    <title>Profile</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
          integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/flowershop.css">
</head>
<body>
<div class="row">
    <div class="col-sm-2" style="border-right: 1px solid red;">
        <div class="center">
            <%--<a class="submit-button" href="item">Flowers</a>--%>

            <br>
            <h2><label>Hello, <%=(String) request.getAttribute("un")%>
            </label></h2><br>
            <h2><label>In fav: <%=(Integer) request.getAttribute("fav")%>
            </label></h2><br>

            <a class="submit-button" href="profile">Back</a>
            <br><br>
            <form action="logout" method="post">
                <input type="submit" value="Logout" class="submit-button"/>
            </form>
        </div>
    </div>

    <div class="col-sm-10" style="border-right: 1px solid red;">
        <div>
            <table class="table">
                <tr>
                    <th>ID</th>
                    <th>Student</th>
                    <th>Theme</th>
                    <th>Director</th>
                    <th>Year</th>
                    <th>Faculty</th>
                    <th>Desc</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach items="${favList}" var="iter" varStatus="rowStatus">
                    <tr>
                        <td>${iter.id}</td>
                        <td>${iter.student}</td>
                        <td>${iter.theme}</td>
                        <td>${iter.director}</td>
                        <td>${iter.year1}</td>
                        <td>${iter.faculty}</td>
                        <td>${iter.description}</td>
                        <td>
                            <a class="submit-button" href="/download?id=${iter.id}">Download</a>
                        </td>
                        <td>
                            <a class="submit-button" href="/remove?id=${iter.id}">Remove from fav</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</div>
</body>
</html>