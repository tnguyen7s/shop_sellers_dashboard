<%-- 
    Document   : login
    Created on : Dec 5, 2021, 3:25:17 PM
    Author     : Tuyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Seller Dashboard - Login Page</title>
    </head>
    <body style="border: solid 1px gray; margin: 50px auto; width: 20%; padding: 20px;">
        <h1>Seller sign-in</h1>
        <form action="LoginServlet.java" method="POST" style="padding: 20px">
            <label for="phone" style="margin-bottom:10px;">Mobile phone number</label><br>
            <input name="phone" type="text" style="margin-bottom:10px;"><br>

            <label for="pwd" style="margin-bottom:10px;">Password</label><br>
            <input name="pwd" type="Password" style="margin-bottom:10px;"><br>

            <button type="submit" name="sign-in" value="clicked" style="margin-bottom:10px;">Sign-in</button>
        </form>
        

        <%
            if (request.getAttribute("invalidLogin") == "true")
            {
                out.println("<p style=\"color: red;\">Invalid phone number or password.</p>");
            }
        %>
    </body>
        
</html>
