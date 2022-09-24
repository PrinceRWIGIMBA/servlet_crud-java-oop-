package Mypackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost/advjava";String user="root";String pass="";
		int id=Integer.parseInt(request.getParameter("id"));
	
		try {
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url, user, pass);
			PreparedStatement ps=conn.prepareStatement("DELETE FROM student WHERE id=?");
			ps.setInt(1, id);
			int status=ps.executeUpdate();
			if(status>0) {
				response.sendRedirect("ViewStudent");
				}
				else
				{
				out.print("Data not deleted");
				}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
