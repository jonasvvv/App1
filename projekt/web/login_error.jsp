<%-- 
    Document   : login_error
    Created on : 2015-apr-27, 10:49:12
    Author     : jonasviklund
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <html>
<head>
<title>Error Page for the SHOP</title>
</head>
<body bgcolor="white">
Invalid username and/or password, please try
<a href='<c:url value="login.jsp"/>'>again</a>.
</body>
</html>
