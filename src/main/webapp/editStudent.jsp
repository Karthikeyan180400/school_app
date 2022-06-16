<!DOCTYPE html>
<%@page import="com.ty.schoolapp.dto.Student"%>
<html>
<style>
body {
  font-family: Arial;
}

input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=email], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=number], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
<body>
<%@include file="naviBar.jsp" %>
<h3>Student Updating Form</h3>

    <%
       Student student = (Student)request.getAttribute("student");
    %>

<div class="container">
  <form action="update">
    <label for="fname">ID</label>
    <input type="text" id="fname" name="id" readonly="readonly" placeholder="Student name.." value="<%= student.getId()%>">
    
    <label for="fname">Name</label>
    <input type="text" id="fname" name="name" placeholder="Student name.." value="<%= student.getName()%>">

    <label for="lname">Email</label>
    <input type="email" id="lname" name="email" placeholder="Email address.." value="<%= student.getEmail() %>">

    <label for="country">Phone</label>
    <input type="number" id="lname" name="phone" placeholder="Phone number.." value="<%= student.getPhone() %>">
    
  
    <input type="submit" value="Update Student">
  </form>
</div>

</body>
</html>
