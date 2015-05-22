<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : login
    Created on : 2015-apr-27, 10:48:22
    Author     : jonasviklund
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/shop.css">
        <title>välkommen till denna sida</title>
    </head>



    <body>


    <center>
        <div id="loginbox">
            <form method="POST" action='<%= response.encodeURL("j_security_check")%>'> <table >
                    <tr>
                        <td colspan="2">
                            <h2>Log in to proceed to Store</h2>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="1"></td>
                    </tr>
                    <tr>
                        <th font color='red' align="right">Username:</th>
                        <td align="left"><input type="text" name="j_username"></td>
                    </tr>
                    <tr>
                        <th align="right">Password:</th>
                        <td align="left"><input type="password" name="j_password"></td>
                    </tr>

                    <tr>
                        <td align="right"><input type="submit" value="Log In"></td> <td align="left"><input type="reset"></td>
                    </tr>
                </table>
            </form>
        </div>
    </center>
</body>
</html>
