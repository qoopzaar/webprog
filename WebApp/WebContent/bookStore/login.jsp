<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="../include/header.jsp"></jsp:include>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book Store</title>
</head>
<body>
	<form action="../bookStore.do" method="post">
		<h3>Login Page</h3>
		<table style="background-color: #EEEEEE; font-family: tahoma; font-size: 12px; font-weight: normal;">
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>Username :</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr style="text-align: center;">
				<td colspan="2"><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>
</body>
</html>