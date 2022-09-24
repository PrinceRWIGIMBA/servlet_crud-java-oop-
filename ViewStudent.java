package Mypackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewStudent")
public class ViewStudent extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection 
			conn=DriverManager.getConnection("jdbc:mysql://localhost/advjava", "root", "");
			PreparedStatement ps=conn.prepareStatement("select * from student");
			ResultSet rs=ps.executeQuery();
			out.print("<html><head><title>View Student</title></head><body>");
			out.print("<a href='NewStudent.html'>New Student</a>");
			out.print("<table border=1 style='width:800px'>");
			out.print("<tr><th>ID</th><th>FIRST NAME</th><th>LAST NAME</th><th>GENDER</th><th>LEVEL</th><th colspan='2'>Action</th></tr>");
			while(rs.next()) {
			out.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2).toString()+"</td>");
			out.print("<td>"+rs.getString(3).toString()+"</td><td>"+rs.getString(4).toString()+"</td>");
			out.print("<td>"+rs.getInt(5)+"</td>");
			out.print("<td><a href='ViewEdit?id="+rs.getInt(1)+"'>Edit</a></td>");
			out.print("<td><a href='Delete?id="+rs.getInt(1)+"'>Delete</a></td></tr>");
			}
			out.print("</table></body></html>");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.close();
	}

}
