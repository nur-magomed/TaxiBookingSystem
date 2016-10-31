<%--
  Created by IntelliJ IDEA.
  User: nur
  Date: 27.10.16
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$Title$</title>

    <% if (session != null && session.getAttribute("currentSessionCustomer") != null) {
        response.sendRedirect("welcome.jsp");
    } else {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0);
    }
    %>
</head>
<body>




<h1> Welcome to taxi booking system</h1>

<br><form action="LoginController" method="post">
    <fieldset style=" width: 300px" >
        <legend>Login:</legend>

        <table align="center">
            <tr>
                <td align="right">Username:</td>
                <td align="left"><input type="text" name="username"/></td>
            </tr>
            <tr>
                <td align="right">Password:</td>
                <td align="left"> <input type="password" name="password"/> <p></td>
            </tr>
        </table>

        <input type="submit" value="Login">

        <a href="registration.jsp">Register</a>
    </fieldset>
</form>


</body>
</html>