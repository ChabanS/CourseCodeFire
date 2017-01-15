<%-- 
    Document   : list
    Created on : Sep 4, 2016, 11:46:46 AM
    Author     : codefire
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Contacts</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>NAME</th>
                    <th>PHONE</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="contact" items="${list}" >
                    <tr>
                        <td>${contact.id}</td>
                        <td>${contact.name}</td>
                        <td>${contact.phone}</td>
                    </tr> 
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
