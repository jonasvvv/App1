<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
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
            <h1>Hej, <c:out value="${pageContext.request.userPrincipal.name}" /> nu kan du logga ut</h1>
            <form name='hej' action=<% request.logout();%>>
                <input type="submit" value='log out'>
            </form>
                
        </div>
        <form name='hej' method="POST" action='controller'>
            Matte 3000 <input type="number" name="nr"/> <br/>
            Matte 4000 <input type="number" name="nr2"/> <br/>
            <input type="submit" value="Buy" />
        </form>
        <sql:query var="result" dataSource="jdbc/shop">
            SELECT * FROM BOOKORDER
        </sql:query>
    
             
    
        <table border="1">
            <caption>Orderhistorik</caption>
            <!-- column headers -->
            <tr>
                <c:forEach var="columnName" items="${result.columnNames}">
                    <th><c:out value="${columnName}"/></th>
                    </c:forEach>
            </tr>
            <!-- column data -->
            <c:forEach var="row" items="${result.rowsByIndex}">
                <tr>
                    <c:forEach var="column" items="${row}">
                        <td><c:out value="${column}"/></td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>


    </body>
</html>
