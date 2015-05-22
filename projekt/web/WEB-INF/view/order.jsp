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
        <link rel="stylesheet" type="text/css" href="css/shop.css">
        <title>SHOP</title>
    </head>
    <body>

        <div id='header'>

            <div class="rightButton">
                <form name='logout' action=logout.jsp>
                    <input type="submit" value='log out'>
                </form>
            </div>

            <div class="shopname">
                <a href ="index.jsp" >
                    Store
                </a>      
            </div>

        </div>
        
        <hr>
        
        <div id="leftColumn">

            <a href="<c:url value='products'/>" class="productButton">
                <span class="productText">Products</span>
            </a>

            <a href="<c:url value='order'/>" class="choosen">
                <span class="productText">Order history</span>
            </a>

            <a href="<c:url value='cart'/>" class="productButton">
                <span class="productText">Shopping cart</span>
            </a>

        </div>

        <div id="rightColumn">
              <div class="actionBar">
           
              Order History of <c:out value="${pageContext.request.userPrincipal.name}" /> 
            
            </div>

            
        <table id="productTable">
            <tr>
                <td></td>
               <c:forEach var="myproducts" items="${products}" varStatus="iter">
                            <td>
                                <c:out value="${myproducts[0]}"></c:out>


                                </td>

                        </c:forEach>

            </tr>
                          <c:forEach var="orderVect" items="${order}" varStatus="iter">
                    <tr class="${((iter.index % 2) == 0) ? 'evenProductRow' : 'oddProductRow'}">
                        <c:forEach var="myorder" items="${orderVect}" varStatus="iter">
                            <td>
                                <c:out value="${myorder}"></c:out>


                                </td>

                        </c:forEach>

                    </tr>

                </c:forEach> 
          
          </table>
        </div>

    </body>
</html>
