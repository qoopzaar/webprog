<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="../include/header.jsp"></jsp:include>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="../addCustomer.do" method="POST">
Customer ID : <input name="id" /> <br>
Name: <input name="name" /> <br>
Address: <textarea name="addr" rows="4" cols="20"></textarea> <br>
Mobile: <input name="mobile" size="9" /> <br>
Fax: <input name="fax" size="9" /> <br>
E-mail: <input name="email" size="25" /> <br><br>
<input type="submit" value="Add" />
</form>
</body>
</html>