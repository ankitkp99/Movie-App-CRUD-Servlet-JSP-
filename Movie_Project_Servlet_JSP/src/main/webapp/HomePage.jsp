<%@ page import="com.myServlet.MovieModel" %>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>HomePage</title>
    <link rel="stylesheet" type="text/css" href="Homepage.css">
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
    
    <div class="viewmovies">
        <% 
            List<MovieModel> moviesList = (List<MovieModel>) request.getAttribute("movieList");
            if (moviesList != null && !moviesList.isEmpty()) {
                for(MovieModel model : moviesList) {
        %>
            <div>
               	<img src="<%= "data:image/jpeg;base64," + java.util.Base64.getEncoder().encodeToString(model.getImage()) %>" 
               	alt="Movie Image"/>

                <p><%= model.getName() %></p>
            </div>
        <% 
                }
            } else {
        %>
            	<p class="no-movies">No Movies Available</p>
        <% 
            }
        %>
    </div>
</body>
</html>
