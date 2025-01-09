package com.myServlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dou.DBConnection;

@WebServlet("/AddMovie")
@MultipartConfig(maxFileSize = 16177215)
public class AddMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.getConnection();
		
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		
		Part movieImage = request.getPart("image"); 
		InputStream image = movieImage.getInputStream(); 
        String name = request.getParameter("movieName");
		
		try {
			PreparedStatement pstmt = conn.prepareStatement("insert into movies(name, image) values(?,?)");
			pstmt.setString(1, name);
			pstmt.setBlob(2, image);
			
			int result = pstmt.executeUpdate();
			if(result != 1) {
				out.println("Something went wrong");
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("AddMovie.jsp");
				rd.forward(request, response);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
