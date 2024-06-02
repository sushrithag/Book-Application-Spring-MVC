<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Application</title>
</head>
<body bgcolor="wheat">
<br><br><br>
<h1 align="center">Welcome to Book Application!</h1>
<br><br><br>
<h1 align="center">
<a href = "profile">Profile</a> |
<a href = "addBook">Add Book</a> |
<a href = "view">View Book</a> |
<a href = "index">Logout</a>
</h1>
<br><br>
<table border = "2" width = "400" height = "200" cellpadding="20" align = "center">
<tr>
<td>Id</td><td>Name</td><td>Email</td><td>Phone</td><td>Address</td>
<%@page import = "java.sql.*" %>
<%@page import = "com.mvc.model.*" %>
<%
User user = (User)request.getAttribute("user");
%>
<tr>
<td><%=user.getId()%></td><td><%=user.getUsername()%></td><td><%=user.getEmail()%></td>
<td><%=user.getPhone()%></td><td><%=user.getAddress()%></td>
</tr>
</table>
</body>
</html>