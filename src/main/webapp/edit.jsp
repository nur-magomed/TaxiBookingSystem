<%@ page import="model.CustomerBean" %><%--
  Created by IntelliJ IDEA.
  User: nur
  Date: 30.10.16
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
    <% if (session == null || session.getAttribute("currentSessionCustomer") == null) {
        response.sendRedirect("index.jsp"); // No logged-in user found, so redirect to login page.
    } else {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0);
    }
    %>
</head>
<body>

<% CustomerBean currentCustomer = (CustomerBean) session.getAttribute("currentSessionCustomer"); %>

<form action="/EditController" method="post">

    <fieldset style="width: 300px">
        <legend>Registration:</legend>
        <table >
            <tr>
                <td align="right">First name:</td>
                <td align="left"><input type="text" name="firstName" value="<%=currentCustomer.getFirst_name()%>"/></td>
            </tr>
            <tr>
                <td align="right">Last name:</td>
                <td align="left"><input type="text" name="lastName" value="<%=currentCustomer.getLast_name()%>"/></td>
            </tr>
            <tr>
                <td align="right">Phone number:</td>
                <td align="left"> <input type="text" name="phone_numb" value="<%=currentCustomer.getPhone_number()%>"/></td>
            </tr>
            <tr>
                <td align="right">Email:</td>
                <td align="left"><input type="text" name="email" value="<%=currentCustomer.getEmail()%>"/></td>
            </tr>

            <tr>
                <td align="right">Gender:</td>
                <td align="left"><select name="gender">
                    <option value="1" selected>Male</option>
                    <option value="0">Female</option>
                </select></td>
            </tr>

            <tr>
                <td align="right">Home address:</td>
                <td align="left"><input type="text" name="address1" value="<%=currentCustomer.getAddress_1()%>"/></td>
            </tr>
            <tr>
                <td align="right">Job address:</td>
                <td align="left"><input type="text" name="address2" value="<%=currentCustomer.getAddress_2()%>"/></td>
            </tr>



            <tr>
                <td align="right">Password:</td>
                <td align="left"><input type="password" name="user_password" value="<%=currentCustomer.getPassword()%>"/></td>
            </tr>
        </table>

        <br>
        <input type="submit" value="Update">
        <input type="reset" value="Cancel">
    </fieldset>
</form>

<a href="LogoutController" >Logout</a>
</body>
</html>
