<%-- 
    Document   : index
    Created on : 2015-apr-27, 11:09:14
    Author     : jonasviklund
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/shoptest.css">
        <title>JSP Page</title>
    </head>
    <body>
        
        <div id='categoryRightColumn'>

        <h1>Hej nu kan du logga ut</h1>
        <form name='hej' action=<% request.logout();%>>
            <input type="submit" value='log out'>
        </form>
    
        </div>
            
            <div id='categoryLeftColumn'>
                
                
                
                
            </div>
</body>
</html>
