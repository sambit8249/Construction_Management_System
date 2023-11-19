<%@page import="com.org.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="components/allcss.jsp"
%>
</head>
<body>


<% 
	User user=(User)session.getAttribute("userObj");
	if(user==null)
	{
		response.sendRedirect("userLogin.jsp");
	}
	else
	{
	%>	
	
<%@ include file="components/usernavbar.jsp" %>
<h1 style="color:red ; text-align:center">welcome to the home page</h1>
<% 
}
	%>
</body>
</html>