<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="../include/header.jsp"></jsp:include>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book Store : Add Book</title>
</head>
<body>
<form action="addBook.do" method="post">
	<h2>Add Book</h2>
	<b>ISBN: </b>
	<input type='text' name='isbn'>
	<br>
	<b>Title: </b>
	<input type='text' name='title'>
	<br>
	<b>Author: </b>
	<input type='text' name='author'>
	<br>
	<b>Price: </b>
	<input type='text' name='price'>
	<br>
	<input type='submit' value='Add'>
</form>
</body>
</html>