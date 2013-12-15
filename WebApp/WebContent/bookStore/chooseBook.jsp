<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="../include/header.jsp"></jsp:include>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book Store : Shopping</title>
</head>
<body>
	<form action="addToCart.do" method="post" >
		<h3>Choose Book(s) to Buy</h3>
		<table style="size: 80%; background-color: #EEEEEE; font-family: tahoma; font-size: 12px; font-weight: normal; padding-left: 15px; padding-right: 15px;">
			<tr align="center">
				<th>&nbsp;</th>
				<th>ISBN</th>
				<th>TITLE</th>
				<th>AUTHOR</th>
				<th align="right">PRICE</th>
			</tr>
			<c:forEach var="book" items="${books}" varStatus="i">
				<tr>
					<td><input type="checkbox" name="isbn" value="${book.isbn}"></td>
					<td>${book.isbn}</td>
					<td>${book.title}</td>
					<td>${book.author}</td>
					<td>${book.price}</td>
				</tr>
			</c:forEach>
			<tr align="center">
				<td colspan="5"><input type="submit" value="Add items to Cart"></td>
			</tr>
		</table>
	</form>
</body>
</html>