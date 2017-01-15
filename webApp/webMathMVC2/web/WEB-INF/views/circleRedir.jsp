<%-- 
    Document   : circle_redir
    Created on : Oct 1, 2016, 8:36:38 PM
    Author     : Sergey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <title>Circle</title>
    </head>
    <body>
        <%@include file="header.jspf" %>
        <%@include file="menu.jspf" %>
        <div class="container">

            <form method="post">
                <div class="radius">

                    Radius: <input type="text" name="radius">
                </div>
                <div class="radius">
                    <input class="btn-default btn-lg" type="submit" value="Calc">
                    <input class="btn-danger btn-lg" type="reset" value="Reset">
                </div>

            </form>
        </div>




    </body>
</html>
