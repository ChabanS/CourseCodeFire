<%-- 
    Document   : page
    Created on : Oct 22, 2016, 11:44:12 AM
    Author     : CodeFire
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="parts/menu.jspf" %>
        <h1>${data.header}</h1>
        ${data.content}
        <h1>${dataDB.header}</h1>
        ${dataDB.content}
    </body>
</html>
