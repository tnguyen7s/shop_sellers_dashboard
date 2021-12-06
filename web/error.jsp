<%-- 
    Document   : error
    Created on : Dec 5, 2021, 2:24:55 AM
    Author     : Tuyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <%
            out.println("<p style=\"color:red;\">"+request.getAttribute("error")+"</p>");
            
        %>
    </body>
</html>
