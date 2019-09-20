<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Employee Details</h2><hr>
<pre>
				Eno			:${empInfo.eno}
				Ename			:${empInfo.ename}
				Salary			:${empInfo.salary}
				Designation		:${empInfo.designation}
				Dept			:${empInfo.dept}
</pre>
<hr>
<a href="dataentry">ADD Employee</a><br>
<a href="datafetch">Update/Delete Employee</a><br>
<a href="index.jsp">Home</a>
</body>
</html>