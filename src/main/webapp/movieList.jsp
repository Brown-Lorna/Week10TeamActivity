<%-- 
    Document   : movieList
    Created on : Nov 17, 2015, 9:11:44 PM
    Author     : Grant
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movie List</title>
        
        <link rel="stylesheet" type="text/css" href="styles.css" />
    </head>
    <body>
        <div>
            <h1>Movie List</h1>
            <c:forEach items="${movieTitles}" var="movieTitle">
                <p>${movieTitle}</p>
            </c:forEach>
        </div>
    </body>
</html>
