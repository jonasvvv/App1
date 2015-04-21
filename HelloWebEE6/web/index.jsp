<%-- 
    Document   : index
    Created on : Feb 23, 2010, 4:03:37 PM
    Author     : jeff
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <center
    <body>
        <h1>Entry Form</h1>

        <form name="Name Action Form" action="response.jsp">
            Enter your name:
            <center>
            <input type="text" name="name" value="" />
            </center>
            <br>
            Enter your Age!:
            <center>
            <input type="text" name="age" value="" />
            </center>
            <br>
            <input type="submit" value="OK" />
        </form>
    </body>
    </center>
</html>
