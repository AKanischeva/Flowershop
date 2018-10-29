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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="css/flowershop.css">
    <title>Flowers</title>
</head>

<body>
<a href="profile">
    <div class="center"><label>Flowers</label><img src="http://www.freeiconspng.com/uploads/red-flower-icon-18.png"
                                                   width="30px"></div>
</a>
<hr>
<div class="center">
    <form id="flower" action="flower" method="post" onsubmit="return GetCellValues()">
        <table class="table" id="fl">
            <thead bgcolor="#dc3545">
            <tr>
                <th>Name</th>
                <th>Price</th>
                <th>Available</th>
                <th width="20%"></th>
            </tr>
            </thead>
            <c:forEach items="${f}" var="iter" varStatus="rowStatus">
                <tr>
                    <td>${iter.name}</td>
                    <td>${iter.price} &#8381;</td>
                    <td>${iter.quantity}</td>
                    <td width="20%"><input type="number" min="0" class="form-control" id="amount${iter.id}"
                                           name="amount${iter.id}"
                                           placeholder="0">
                    </td>
                </tr>
            </c:forEach>
        </table>
        <hr>
        <input type="submit" class="btn btn-large btn-danger" value="Add to cart"><br><br>
    </form>
</div>
<button type="button" name="back" class="submit-button" onclick="history.back()">back</button>
</body>

<script type="text/javascript">
    function GetCellValues() {
        var str = "amount";
        var al = "Not enough flowers:\n";
        var table = document.getElementById('fl');
        for (var r = 1, n = table.rows.length; r < n; r++) {
            for (var c = 2, m = table.rows[r].cells.length - 1; c < m; c++) {
                if (parseInt(table.rows[r].cells[c].innerHTML) < (document.getElementById(str.concat((r).toString())).value)) {
                    al = al.concat((table.rows[r].cells[c - 2].innerHTML).concat("\n"));
                }
            }
        }
        if (al !== "Not enough flowers:\n") {
            alert(al);
            return false;
        }
    }
</script>
</html>