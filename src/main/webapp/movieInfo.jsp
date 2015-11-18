<%-- 
    Document   : movieInfo
    Created on : Nov 17, 2015, 11:12:26 PM
    Author     : Grant
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${movie.title} Information</title>
        
        <link rel="stylesheet" type="text/css" href="styles.css" />
    </head>
    <body>
        <div>
            <h1>${movie.title}</h1>
            
            <p>Year: ${movie.year}</p>
            <p>Genre: ${movie.genre}</p>
            <p>Director: ${movie.director}</p>
            <p>Actors: ${movie.actors}</p>
        </div>
    </body>
</html>
