<%-- 
    Document   : result
    Created on : Sep 25, 2016, 8:22:11 PM
    Author     : Sergey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
    </head>
    <body>
        <%@include file="header.jspf" %>
        <%@include file="menu.jspf" %>

        <h1>
            <div class="result">
                ${result}
            </div>
        </h1>
        
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
