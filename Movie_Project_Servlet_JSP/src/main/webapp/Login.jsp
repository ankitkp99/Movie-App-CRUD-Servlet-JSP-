<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="Loginpage.css">
</head>
<body>
	<div class="loginform">
		<h2>Login</h2>

		<%
		String errorMessage = (String) request.getAttribute("errorMessage");
		if (errorMessage != null) {
		%>
		<p style="color: red;"><%=errorMessage%></p>
		<%
		}
		%>

		<form action="Loginpage" method="post">
			<div>
				<label for="username">Username:</label> <br>
				<input type="text" id="username" name="username" required>
			</div>
			<div>
				<label for="password">Password:</label> <br>
				<input type="password" id="password" name="password" required>
			</div>
			<div>
				<button type="submit">Login</button>
			</div>
		</form>

		<p>
			Don't have an account? <br> <a href="Register.jsp">Register
				Here</a>
		</p>
	</div>
</body>
</html>
