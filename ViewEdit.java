package Mypackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ViewEdit")
public class ViewEdit extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost/advjava";String user="root";String pass="";
		int id=Integer.parseInt(request.getParameter("id"));
		out.print("<html>");
		out.print("<head><title>Student Edit</title></head>");
		out.print("<body>");
	
		try {
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url, user, pass);
			PreparedStatement ps=conn.prepareStatement("SELECT * FROM student WHERE id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();

			if(rs.next()) {
				out.print("<div style='width:400px; margin:0px auto 0px auto'>");
				out.print("<h3>Edit Student</h3>");
				out.print("<form method='GET' action='Update'>");out.print("<input type='hidden' name='id' value='"+id+"'><br/>");
				out.print("<label>First name</label><br/>");
				out.print("<input type='text' name='fname' value='"+rs.getString(2).toString()+"'><br/>");
				out.print("<label>Last name</label><br/>");
				out.print("<input type='text' name='lname' value='"+rs.getString(3).toString()+"'><br/>");
				out.print("<label>Gender</label><br/>");
				out.print("<input type='radio' name='gender' value='male' checked='checked'>Male<input type='radio' name='gender' value='female'>Female<br/>");
				out.print("<label>Level</label> :");
				out.print("<select name='level'>");
				out.print("<option value='1'>Level 1</option><option value='2'>Level 2</option><option value='3'>Level 3</option>");
				out.print("</level><br/>");
				out.print("<input type='submit' name='update' value='Update'><br/>");
				out.print("</form></div>");}
		}

		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.close();
		}
	

}
