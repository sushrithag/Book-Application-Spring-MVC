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
<%@page import = "java.sql.*" %>
<%@page import = "com.mvc.model.*" %>
<%
Book book = (Book)request.getAttribute("book");
%>
<form action="updateBook" align="center">
<input type="hidden" name="bid" value = "<%=book.getBid()%>">
<input type="text" name="book_name" value = "<%=book.getBook_name()%>">
<input type="text" name="book_price" value = "<%=book.getBook_price()%>" >
<input type="text" name="book_author" value = "<%=book.getBook_author()%>">
<input type="text" name="book_publisher" value = "<%=book.getBook_publisher()%>" >
<input type="submit" value="Update Book">
</form>
</body>
</html>