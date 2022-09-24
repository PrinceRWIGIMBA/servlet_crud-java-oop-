package Mypackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;


@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String gender=request.getParameter("gender");
		String level=request.getParameter("level");
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost/advjava";
		String user="root";String pass="";
	
			try {
				Class.forName(driver);
				Connection conn=(Connection) DriverManager.getConnection(url,user,pass);
				PreparedStatement ps=conn.prepareStatement("INSERT INTO student SET fname=?,lname=?,gender=?,level=?");
				ps.setString(1, fname);
				ps.setString(2, lname);
				ps.setString(3, gender);
				ps.setString(4, level);
				ps.executeUpdate();
				response.sendRedirect("ViewStudent");
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.close();
			}
			
			
	}

}
