package com.myServlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dou.DBConnection;

@WebServlet("/Registerpage")
public class Registerpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
		Connection conn = DBConnection.getConnection();
		
		try {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			PreparedStatement pstmt = conn.prepareStatement("insert into user(name, email, username, password) values (?,?,?,?)");
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, username);
			pstmt.setString(4, password);
			
			int result = pstmt.executeUpdate();
			if(result == 1)
			{
				out.println("Registration in Successfully");
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
			else
			{
				out.println("Registration in Failed");
				RequestDispatcher rd = request.getRequestDispatcher("Resister.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
