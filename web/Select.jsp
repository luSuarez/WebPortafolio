<%-- 
    Document   : Select
    Created on : 09-10-2017, 1:03:06
    Author     : portafolio
--%>

<%@page import="Beans.Usuario"%>
<% Usuario user = (Usuario)request.getSession().getAttribute("usuario"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <select name="Pais">
            <% int i =0;
                for ( i = 0; i < 10; i++) { %>
                <option value="<%= i %>"> <%= i %> </option>
            <%}%>
        </select>
    </body>
</html>
