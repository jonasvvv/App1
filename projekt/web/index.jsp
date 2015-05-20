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
        <title>BOOKSHOP</title>
    </head>
    <body>

        <div id='header'>

            <div class="logout">
                <form name='logout' action=logout.jsp>
                    <input type="submit" value='log out'>
                </form>
            </div>

            <div class="shopname">
                <h1>Store</h1>    
            </div>

        </div>

        <div id="leftColumn">
            <div class="productButton" id="selectedCategory">
                <span class="productText">Poducts</span>
            </div>

            <a href="<c:url value='products'/>" class="productButton">
                <span class="productText">Poducts</span>
            </a>

            <a href="/order" class="productButton">
                <span class="productText">Order history</span>
            </a>

            <a href="/cart" class="productButton">
                <span class="productText">Shopping cart</span>
            </a>

        </div>

        <div id="rightColumn">
            <span class="body" >
            Hej här kan man nu skriva lite text om saker
            </span>
        </div>
       
    </body>
</html>
