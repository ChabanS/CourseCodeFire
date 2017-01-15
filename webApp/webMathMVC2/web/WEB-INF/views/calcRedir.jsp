<%-- 
    Document   : calc
    Created on : Oct 1, 2016, 2:12:55 PM
    Author     : Sergey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web Math</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        
    </head>
    <body>
        <%@include file="header.jspf" %>
        <%@include file="menu.jspf" %>
        <br/>
        <br/>
        <br/>
        <div align="center" class="container" >
            <form method="post">
                <font size="5">
                <div class="container">
                    <div class="row">
                        <div class="col-md-3">
                            <div class="input-group input-group-lg">
                                <span class="input-group-addon">Number:</span>
                                <input type="text" class="form-control" name="first">
                            </div> 
                        </div>
                        <div class="col-md-3">
                            <font size="6">
                            <div class="btn-lg">
                                <select name="operator">
                                    <option value="+">Plus " + "</option>
                                    <option value="-">Minus " - "</option>
                                    <option value="*">Multiply " * "</option>
                                    <option value="/">Divide " / "</option>
                                </select>
                                <br/>
                                <br/>
                                <input class="btn-default btn-lg" type="submit" value="Calc">
                                <input class="btn-danger btn-lg" type="reset" value="Reset">
                                <br/>
                                <br/>
                            </div>
                            </font>
                        </div>
                        <div class="col-md-3">
                            <div class="input-group input-group-lg">
                                <span class="input-group-addon">Number:</span>
                                <input type="text" class="form-control" name="second">
                            </div> 
                        </div>
                        <div class="col-md-3">
                            <div class="">
                                <p><a href="http://www.codefire.com.ua/">
                                        <img class="media-object" src="picture/7e7cbccf9bb225cf.jpeg" alt="CodeFire">
                                    </a>
                                </p>
                            </div> 
                        </div>
                    </div>
                </div>
                </font>
            </form>
        </div>
        </br>
        <%@include file="footer.jspf" %>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
