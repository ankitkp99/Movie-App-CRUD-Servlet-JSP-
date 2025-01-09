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

import com.dou.DBConnection;

@WebServlet("/Loginpage")
public class Loginpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.getConnection();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			PreparedStatement pstmt = conn.prepareStatement("select * from user where username = ? and password = ?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
			{
//				RequestDispatcher rd = request.getRequestDispatcher("HomePage.jsp");
//				rd.forward(request, response);
				response.sendRedirect("Homepage");
			}
			else {
				request.setAttribute("errorMessage", "Login Failed: Invalid username or password.");
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
