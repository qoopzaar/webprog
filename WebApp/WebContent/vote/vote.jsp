<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="../include/header.jsp"></jsp:include>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vote</title>
</head>
<body>
	<form action="../vote.do" method="post">
		<h3>Select a Computer Program</h3>
		<div style="background-color: #FFFFFF; font-family: tahoma; font-size: 12px; font-weight: normal;">
			<input type="radio" name="lang" value="1"/>Java<br>
			<input type="radio" name="lang" value="2"/>C#<br>
			<input type="radio" name="lang" value="3"/>C<br>
			<input type="radio" name="lang" value="4"/>Pascal<br>
			<input type="submit" value="Vote" />
		</div>
	</form>
</body>
</html>