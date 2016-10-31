<%@ page import="model.CustomerBean" %><%--
  Created by IntelliJ IDEA.
  User: nur
  Date: 28.10.16
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>

<% if (session == null || session.getAttribute("currentSessionCustomer") == null) {
    response.sendRedirect("index.jsp"); // No logged-in user found, so redirect to login page.
} else {
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setDateHeader("Expires", 0);
}
%>


    <% CustomerBean currentCustomer = (CustomerBean) session.getAttribute("currentSessionCustomer"); %>
<%  String name=currentCustomer.getFirstName();
    String lastname=currentCustomer.getLastName();
    out.println("Welcome  " + name + " " +lastname);
%>

<br><br>
    <a href="edit.jsp" >Edit</a>

<a href="LogoutController" >Logout</a>

</body>
</html>
