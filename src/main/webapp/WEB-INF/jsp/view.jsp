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
<td>Book Id</td><td>Book Name</td><td>Book Price</td><td>Book Author</td><td>Book Publisher</td><td>Delete</td><td>Update</td>
</tr>
<%@page import="java.util.*" %>
<%@page import="com.mvc.model.*" %>
<%
List li = (List)request.getAttribute("li");
Iterator it = li.iterator();
while(it.hasNext())
{
	Book book = (Book)it.next();
%>
<tr>
<td><%=book.getBid() %></td><td><%=book.getBook_name() %></td><td><%=book.getBook_price() %></td>
<td><%=book.getBook_author() %></td><td><%=book.getBook_publisher() %></td><td><a href = "delete?id=<%=book.getBid()%>">Delete</a></td>
<td><a href = "update?id=<%=book.getBid()%>">Update</a></td>
</tr>
<%
}
%>

</table>
</body>
</html>