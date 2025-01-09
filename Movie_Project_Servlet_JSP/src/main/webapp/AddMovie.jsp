<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Movies</title>
<link rel="stylesheet" type="text/css" href="AddMovie.css">
</head>
<body>
	<h1>Movie Mafia</h1>
	<nav>
		<ul>
			<li><a href="Homepage">Home</a></li>
			<li><a href="AddMovie.jsp">Add Movie</a></li>
			<li><a href="DeleteMovie">Delete Movie</a></li>
		</ul>
	</nav>
	<form action="AddMovie" method="post" enctype="multipart/form-data">
		<div>
			<label for="username">Add Image:</label>
			<input type="file" id="username" name="image" accept="image/*" required>
		</div>
		<div>
			<label for="movieName">Movie Name:</label>
			<input type="text" id="movieName" name="movieName" required>
		</div>
		<div>
			<button type="submit">Add Movie</button>
		</div>
	</form>
</body>
</html>
