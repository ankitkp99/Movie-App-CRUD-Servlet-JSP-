package com.myServlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dou.DBConnection;

@WebServlet("/DeleteMovie")
public class DeleteMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        Connection conn = DBConnection.getConnection();
	        List<MovieModel> movieList = new ArrayList<>();

	        try {
	            PreparedStatement pstmt = conn.prepareStatement("select * from movies order by movieid desc;");
	            ResultSet rs = pstmt.executeQuery();

	            while (rs.next()) {
	            	int id = rs.getInt(1);
	                String name = rs.getString(2);  
	                byte[] image = rs.getBytes(3); 
	                movieList.add(new MovieModel(id, name, image));
	            }

	            if (movieList != null && !movieList.isEmpty()) {
	                request.setAttribute("movieLists", movieList);
	            } 
	            else {
	                request.setAttribute("movieList", new ArrayList<MovieModel>());
	            }
	 
	            RequestDispatcher rd = request.getRequestDispatcher("DeleteMovie.jsp");
	            rd.forward(request, response);

	        } catch (SQLException e) {
	            e.printStackTrace();
	            response.getWriter().println("Error fetching movie data: " + e.getMessage());
	        }
	    }
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String DeleteId = request.getParameter("movieId");
		Connection conn = DBConnection.getConnection();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement("delete from movies where movieid = ?");
			pstmt.setString(1, DeleteId);
			int result = pstmt.executeUpdate();
			if(result == 1)
			{
				RequestDispatcher rd = request.getRequestDispatcher("DeleteMovie.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
