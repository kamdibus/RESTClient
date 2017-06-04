<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="client.ClientClass"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HTML Response</title>
</head>
<body>
	<%
		session = request.getSession();
	%>
	<%
		if (session.getAttribute("clientClass") == null) {
			session.setAttribute("clientClass", new ClientClass());
		}
	%>
	<i><%=((ClientClass) (session.getAttribute("clientClass"))).getResponse()%><br>
	<br></i>
	<%=((ClientClass) (session.getAttribute("clientClass"))).getHtmlAnswer()%>
	<br>
	<a href="xml">xml response</a>
	<br>
	<a href="txt">plain txt response</a>
	<br><br>
	<a href="index.html">Back to home</a>
</body>
</html>