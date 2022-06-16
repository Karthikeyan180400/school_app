<%@page import="com.ty.schoolapp.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="naviBar.jsp" %>
<h3>Enter Your Details</h3>

    <%
       Student student = (Student)request.getAttribute("student");
    %>

	<form action="update" method="post">
	Id<input type="text" name="id" readonly="readonly" value="<%= student.getId()%>"><br><br><br>
	Name<input type="text" name="name" value="<%= student.getName() %>"><br><br><br>
	Email<input type="email" name="email" value="<%= student.getEmail() %>"><br><br><br>
	Phone<input type="number" name="phone" value="<%= student.getPhone() %>"><br><br><br>
	<input type="submit" value="Update">
	
	</form>
</body>
</html>