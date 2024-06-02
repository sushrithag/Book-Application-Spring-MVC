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
<form action="add" align="center" method="post">
<input type="text" name="book_name" placeholder="Enter Book Name">
<input type="text" name="book_price" placeholder="Enter Book Price">
<input type="text" name="book_author" placeholder="Enter Book Author">
<input type="text" name="book_publisher" placeholder="Enter Book Publisher">
<input type="submit" value="Add Book">

</form>
</body>
</html>