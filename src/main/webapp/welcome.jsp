<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	if (session.getAttribute("username") != null) {
	%>
	<h1>
		welcome
		<%=session.getAttribute("username")%>
	</h1>
	<a href="logout">logout</a>
	<%
	} else {
	request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	%>

</body>
</html>