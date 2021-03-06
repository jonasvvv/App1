<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

            <a href="<c:url value='order'/>" class="productButton">
                <span class="productText">Order history</span>
            </a>

            <a href="<c:url value='cart'/>" class="choosen">
                <span class="productText">Shopping cart</span>
            </a>

        </div>

        <div id="rightColumn">
            <div class="actionBar">

                <h1>Shopping cart of <c:out value="${pageContext.request.userPrincipal.name}" /> </h1>

            </div>
            <table id="productTable">
                <tr>
                    <th>Product</th>
                    <th>pcs</th>
                    <th>Price/pcs</th>
                </tr>

                <c:forEach var="cartVect" items="${cart}" varStatus="iter">

                    <c:forEach var="mycart" items="${cartVect}" varStatus="iter">
                        <tr>
                            <td><c:out value="${products[iter.index][0]}"></c:out></td>
                            <td> <c:out value="${mycart}"></c:out></td>
                            <td> <c:out value="${products[iter.index][1]}"></c:out></td>
                            </tr>

                    </c:forEach>

                </c:forEach> 
                <tr>
                </tr>
                <tr>
                    <td><b>total</b></td>
                    <td> </td>
                    <td><c:out value="${totalcart}"></c:out></td>
                </tr>
            </table>

            <div class="actionBar">
                <div class="rightButton">
                    <form name='place order' method="POST" action=Controller>
                        <input type="submit" name="place" value='Place order'>
                    </form>
                    <form name='cler cart' method="POST" action=Controller>
                        <input type="submit" name="clear" value='Clear cart '>
                    </form>
                </div>

            </div>   
        </div>

    </body>
</html>
