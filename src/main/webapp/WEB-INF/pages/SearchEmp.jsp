<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Search Employee</h2><hr>
<form action="GetEmp" method="post">
<table align="center" cellpadding="5px">
	<tr>
		<td>Enter ENO</td><td><input type="text" name="eno" required="required" pattern="[0-9]{3}"></td>
	</tr>
	<tr align="center" >
	<td colspan="2"><input type="submit" value="SUBMIT"></td>
	</tr>
</table>
</form>

<%if(request.getAttribute("emp")!=null){ %> 
<hr>
<table align="center" cellpadding="5px" border="1" cellspacing="0">
	
	<tr><th>Eno</th><th>Ename</th><th>Salary</th><th>Designation</th><th>Dept</th></tr>
	<tr>
		<td>${emp.eno}	</td>
		<td>${emp.ename}</td>
		<td>${emp.salary}</td>
		<td>${emp.designation}</td>
		<td>${emp.dept}</td>
</tr>
	
</table>
 <%} %>
 
<a href="index.jsp">Home</a> 
</body>
</html>