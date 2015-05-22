<%-- 
    Document   : bye
    Created on : May 11, 2015, 5:26:51 PM
    Author     : hans-erik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/shop.css">
        <title>logout</title>
    </head>
    <body>
    <center>
        <div id="loginbox">
        <h1>Thank You, Please Come Again!</h1>
        <% request.logout();%>


        <form name='back' action=login.jsp>
            <input type="submit" value='back'>
        </form>
        </div>


    </center> 
</body>
</html>


