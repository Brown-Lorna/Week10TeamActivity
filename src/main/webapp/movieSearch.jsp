<%-- 
    Document   : movieSearch
    Created on : Nov 17, 2015, 9:09:32 PM
    Author     : Grant
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movie Searchlet</title>
        
        <link rel="stylesheet" type="text/css" href="styles.css" />
    </head>
    <body>
        <div>
            <form name="search" method="GET" action="MovieSearch">
                <label for="movie">Search Movie Database</label>
                <input id="movie" name="movie" type="text" /> <br />
                
                <input name="submit" type="submit" value="Search" />
            </form>
        </div>
    </body>
</html>
