<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="client.ClientClass"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Plain Txt Response</title>
</head>
<body>
	<%
		session = request.getSession();
	%>
	<i><%=((ClientClass) (session.getAttribute("clientClass"))).getResponse()%><br><br></i>
	<%=((ClientClass) (session.getAttribute("clientClass"))).getPlainAnswer()%>
	<br>
	<a href="xmlResponse.jsp">xml response</a>
	<br>
	<a href="htmlResponse.jsp">html response</a>
</body>
</html>