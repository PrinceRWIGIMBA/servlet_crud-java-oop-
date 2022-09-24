package Mypackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Update")
public class Update extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost/advjava";String user="root";String pass="";
		int id=Integer.parseInt(request.getParameter("id"));
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String gender=request.getParameter("gender");
		String level=request.getParameter("level");
		try {
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url, user, pass);
			PreparedStatement ps=conn.prepareStatement("UPDATE student SET fname=?,lname=?,gender=?,level=? WHERE id=?");
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, gender);
			ps.setString(4, level);
			ps.setInt(5, id);
			int status=ps.executeUpdate();
			if(status>0) {
			response.sendRedirect("ViewStudent");}
			else {
			out.print("Update not done");}
			out.print("continue"+id+fname+lname+gender+level);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
