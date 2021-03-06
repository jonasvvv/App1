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

            <a href="<c:url value='products'/>" class="choosen">
                <span class="productText">Products</span>
            </a>

            <a href="<c:url value='order'/>" class="productButton">
                <span class="productText">Order history</span>
            </a>

            <a href="<c:url value='cart'/>" class="productButton">
                <span class="productText">Shopping cart</span>
            </a>

        </div>

        <div id="rightColumn">
            <div class="actionBar">


            </div>
            <table id="productTable">
                <tr>
                    <th>Product</th>
                    <th>Price</th>
                    <th></th>
                </tr>
                <c:forEach var="productvect" items="${products}" varStatus="iter">
                    <tr class="${((iter.index % 2) == 0) ? 'evenProductRow' : 'oddProductRow'}">
                        <c:forEach var="product" items="${productvect}" varStatus="iter">
                            <td>
                                <c:out value="${product}"></c:out>
                                </td>
                        </c:forEach>

                        <td>
                            <form action="Controller" method="post">
                                <input type="hidden"
                                       name="productName"
                                       value="${productvect[0]}">
                                <input type="submit" name='toCart'
                                       value="add to cart">
                            </form>
                        </td>

                    </tr>

                </c:forEach>   
            </table>
        </div>

    </body>
</html>
