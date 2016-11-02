<%--
  Created by IntelliJ IDEA.
  User: nur
  Date: 27.10.16
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>

    <% if (session != null && session.getAttribute("currentSessionCustomer") != null) {
        response.sendRedirect("welcome.jsp"); // No logged-in user found, so redirect to login page.
    } else {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0);
    }
    %>
</head>
<body>

<div style="text-align: center;">

    <h2> Registration </h2>

    <form action="CustomerController" method="post">

        <fieldset style="width: 300px">
            <legend>Registration:</legend>
            <table >
                <tr>
                    <td align="right">First name:</td>
                    <td align="left"><input type="text" name="firstName"/></td>
                </tr>
                <tr>
                    <td align="right">Last name:</td>
                    <td align="left"><input type="text" name="lastName"/></td>
                </tr>
                <tr>
                    <td align="right">Phone number:</td>
                    <td align="left"> <input type="text" name="phone_numb"/></td>
                </tr>
                <tr>
                    <td align="right">Email:</td>
                    <td align="left"><input type="text" name="email"/></td>
                </tr>
                <tr>
                    <td align="right">Password:</td>
                    <td align="left"><input type="password" name="user_password"/></td>
                </tr>

            </table>

        <br>
        <input type="submit" value="Register">
        <input type="reset" value="Cancel">
        </fieldset>
    </form>


</div>
</body>
</html>