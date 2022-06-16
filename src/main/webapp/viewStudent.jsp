<!DOCTYPE html>
<%@page import="com.ty.schoolapp.dto.Student"%>
<%@page import="java.util.List"%>
<html>
<head>
<style>
#customers {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#customers td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
}

#customers tr:nth-child(even) {
	background-color: #f2f2f2;
}

#customers tr:hover {
	background-color: #ddd;
}

#customers th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #04AA6D;
	color: white;
}
</style>
</head>
<body>
<%@include file="naviBar.jsp" %>
	<h1>Student Details</h1>

	<table id="customers">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Phone</th>
			<th>Edit</th>
			<th>Delete</th>

			<%
			List<Student> students = (List<Student>) request.getAttribute("studentslist");
			%>
			<%
			for (Student student : students) {
			%>
		</tr>
		<tr>
			<td><%= student.getId()%></td>
			<td><%= student.getName() %></td>
			<td><%= student.getEmail() %></td>
			<td><%= student.getPhone() %></td>
			<td><a href="edit?id=<%= student.getId() %>">Edit</a></td>
			<td><a href="delete?id=<%= student.getId() %>">Delete</a></td>
			
			<%
			}
			%>
		
	</table>

</body>
</html>


