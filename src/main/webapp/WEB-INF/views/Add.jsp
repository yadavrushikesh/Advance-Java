<%@page import="com.jspiders.springmvc.POJO.StudentPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    List<StudentPOJO> students=(List<StudentPOJO>)request.getAttribute("students");
    String msg = (String) request.getAttribute("msg");
    %>
    <jsp:include page="NavBar.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
form {
	margin-top: 10px;
}

form table {
	margin: auto;
	width: 100%;
}

tr {
	text-align: center;
}

#data {
	background-color: black;
	border: 1px solid white;
	width: 100%;
	border: 1px solid white;
	color: white;
}

#data td {
	border: 1px solid white;
	text-align: center;
}
fieldset table {
	margin: auto;
	text-align: left;
}

fieldset {
	margin: 15px 520px;
	text-align: center;
}

legend {
	color: white;
	background-color: #333;
}
body {
	background-image:
		url('https://img.freepik.com/free-vector/student-graduation-cap-using-computer-desk_1262-21421.jpg?w=1060&t=st=1694004468~exp=1694005068~hmac=0ea94af374fc5ab17c8ed42a8e2c107cf9b3ff790e5a905c0fbeccb5ed7b052e');
	background-size: 80%;
}

</style>
</head>
<body>
    <div align="center">
		<fieldset>
			<legend>Add Student Details</legend>
			<form action="./add" method="post">
				<table>
					<tr>
						<td>Name</td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="text" name="email"></td>
					</tr>
					<tr>
						<td>Contact</td>
						<td><input type="text" name="contact"></td>
					</tr>
					<tr>
						<td>Address</td>
						<td><input type="text" name="address"></td>
					</tr>
				</table>
				<input type="submit" value="ADD">
			</form>
		</fieldset>
		
		<%
		if (msg != null) {
		%>
		<h3><%=msg%>
		</h3>
		<%
		}
		%>
		<%
		if (students != null) {
		%>
		<table id="data">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>EMAIL</th>
				<th>CONTACT</th>
				<th>ADDRESS</th>
			</tr>
			<%
			for (StudentPOJO pojo : students) {
			%>
			<tr>
				<td><%=pojo.getId()%></td>
				<td><%=pojo.getName()%></td>
				<td><%=pojo.getEmail()%></td>
				<td><%=pojo.getContact()%></td>
				<td><%=pojo.getAddress()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<%
		}
		%>
		</div>
  
</body>
</html>