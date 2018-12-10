<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: anastasia.kanischeva
  Date: 24.10.2018
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.math.BigDecimal" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<button type="button" name="back" class="submit-button" onclick="history.back()">back</button>--%>
<html>
<head>
    <title>Admin</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
          integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/flowershop.css">
</head>
<body>
<h2 class="center">ADMIN PAGE</h2>
<div class="row">
    <div class="col-sm-2" style="border-right: 1px solid red;">
        <div class="center">
            <%--<a class="submit-button" href="item">Flowers</a>--%>

            <br>
            <h2><label>Hello, <%=(String) request.getAttribute("un")%>
            </label></h2><br>
            <form action="logout" method="post">
                <input type="submit" value="Logout" class="submit-button"/>
            </form>
        </div>
    </div>

    <div class="col-sm-3" style="border-right: 1px solid red;">
        <form action="upload" method="post" enctype="multipart/form-data">
            <div class="container">

                <div class="row">
                    <div class="col-sm-14" style="background-color:white;">
                        <form class="form-horizontal">
                            <fieldset>


                                <!-- Diploma theme-->
                                <div class="form-group">
                                    <label class="col-md-14 control-label" for="Theme">Theme</label>
                                    <div class="col-md-14">
                                        <input id="Theme" name="Theme" type="text" placeholder="Theme"
                                               class="form-control input-md">

                                    </div>
                                </div>

                                <!-- FullName of scientific director-->
                                <div class="form-group">
                                    <label class="col-md-14 control-label" for="Director">Scientific Director:</label>
                                    <div class="col-md-14">
                                        <input id="Director" name="Director" type="text"
                                               placeholder="Scientific Director"
                                               class="form-control input-md">

                                    </div>
                                </div>

                                <!-- Year -->
                                <div class="form-group">
                                    <label class="col-md-14 control-label" for="Year">Year:</label>
                                    <div class="col-md-14">
                                        <select id="Year" name="Year" class="form-control">
                                            <option value="-1">[Select all]</option>
                                            <option value="2000">2000</option>
                                            <option value="2001">2001</option>
                                            <option value="2002">2002</option>
                                            <option value="2003">2003</option>
                                            <option value="2004">2004</option>
                                            <option value="2005">2005</option>
                                            <option value="2006">2006</option>
                                            <option value="2007">2007</option>
                                            <option value="2008">2008</option>
                                            <option value="2009">2009</option>
                                            <option value="2010">2010</option>
                                            <option value="2011">2011</option>
                                            <option value="2012">2012</option>
                                            <option value="2013">2013</option>
                                            <option value="2014">2014</option>
                                            <option value="2015">2015</option>
                                            <option value="2016">2016</option>
                                            <option value="2017">2017</option>
                                            <option value="2018">2018</option>
                                        </select>
                                    </div>
                                </div>


                                <!-- Student's FullName-->
                                <div class="form-group">
                                    <label class="col-md-14 control-label" for="Student">Student's FullName:</label>
                                    <div class="col-md-14">
                                        <input id="Student" name="Student" type="text" placeholder="Student's FullName"
                                               class="form-control input-md">

                                    </div>
                                </div>

                                <!-- Faculty -->
                                <div class="form-group">
                                    <label class="col-md-14 control-label" for="Faculty">Faculty:</label>
                                    <div class="col-md-14">
                                        <select id="Faculty" name="Faculty" class="form-control">
                                            <option selected="" value="-1">[Select all]</option>
                                            <option value="1">Биологический факультет</option>
                                            <option value="2">Институт непрерывного образования</option>
                                            <option value="3">Институт педагогического образования и социальных
                                                технологий
                                            </option>
                                            <option value="4">Исторический факультет</option>
                                            <option value="5">Институт экономики и управления</option>
                                            <option value="6">Математический факультет</option>
                                            <option value="7">Отделение общеуниверситетских кафедр</option>
                                            <option value="8">Факультет географии и геоэкологии</option>
                                            <option value="9">Факультет иностранных языков и международной
                                                коммуникации
                                            </option>
                                            <option value="10">Факультет прикладной математики и кибернетики</option>
                                            <option value="11">Факультет психологии</option>
                                            <option value="12">Факультет физической культуры</option>
                                            <option value="13">Физико-технический факультет</option>
                                            <option value="14">Филологический факультет</option>
                                            <option value="15">Химико-технологический факультет</option>
                                            <option value="16">Юридический факультет</option>
                                        </select>
                                    </div>
                                </div>

                                <!-- Description-->
                                <div class="form-group">
                                    <label class="col-md-14 control-label" for="Description">Description:</label>
                                    <div class="col-md-14">
                                        <input id="Description" name="Description" type="text" placeholder="Description"
                                               class="form-control input-md">

                                    </div>
                                </div>
                                <%--Upload file--%>
                                <div class="form-group">
                                    <label class="col-md-14 control-label" for="Upload">Upload file:</label>
                                    <div class="col-md-14">
                                        <input id="Upload" name="Upload" type="file" placeholder="Upload file"
                                               class="form-control input-md">
                                    </div>
                                </div>
                            </fieldset>
                        </form>
                    </div>
                </div>
                <input type="submit" value="Upload" class="submit-button"/>
            </div>
        </form>
    </div>
    <div class="col-sm-6" style="border-right: 1px solid red;">
        <%--<div class="center">--%>
        <%--&lt;%&ndash;<a class="submit-button" href="item">Flowers</a>&ndash;%&gt;--%>

        <%--<br>--%>
        <%--<h2><label>Hello, <%=(String) request.getAttribute("un")%>--%>
        <%--</label></h2><br>--%>

        <%--<form action="logout" method="post">--%>
        <%--<input type="submit" value="Logout" class="submit-button"/>--%>
        <%--</form>--%>
        <%--</div>--%>
        <div>
            <table class="table">
                <c:forEach items="${f}" var="iter" varStatus="rowStatus">
                    <tr>
                        <td>${iter.id}</td>
                        <td>${iter.student}</td>
                        <td>${iter.theme}</td>
                        <td>${iter.director}</td>
                        <td>${iter.year1}</td>
                        <td>${iter.faculty}</td>
                        <td>${iter.description}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>