<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String msg = (String) request.getAttribute("msg");
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
fieldset table {
	margin: auto;
	margin-top:20px;
	text-align: left;
}

fieldset {
	margin: 15px 520px;
	margin-top:50px;
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
   <%
		if (msg != null) {
		%>
		<h4>
			<%=msg%>
		</h4>
		<%
		}
		%>
		<fieldset>
			<legend>Login Page</legend>
			<form action="./login" method="post">
				<table>
					<tr>
						<td>Username</td>
						<td><input type="text" name="username"></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="password"></td>
					</tr>
				</table>
				<input type="submit" value="LOGIN">
			</form>

		</fieldset>
		<a href="http://localhost:8080/springmvc/createAccount">Create
			Account</a>
	</div>

</body>
</html>