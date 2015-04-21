<%-- 
    Document   : response
    Created on : Feb 22, 2010, 7:21:40 PM
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
        <jsp:useBean id="mybean" scope="session" class="org.mypackage.hello.NameHandler" />
        <jsp:setProperty name="mybean" property="name" />
        
        <jsp:useBean id="mybean2" scope="session" class="org.mypackage.hello.AgeHandler" />
        <jsp:setProperty name="mybean2" property="age" />
        <h2>Hello, <jsp:getProperty name="mybean" property="name"/> (<jsp:getProperty name = "mybean2" property="age" />)!</h2>
       
         <form name="back">
         <INPUT Type="button" VALUE="Tillbaka" onClick="history.go(-1);return true;">
        </form>
        
    </body>
    </center>
</html>
