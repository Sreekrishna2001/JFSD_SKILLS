package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import workers.MovieBookin;
import dbConnection.DbConnection;
/**
 * Servlet implementation class Viewtickets
 */
@WebServlet("/viewtickets")
public class Viewtickets extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Viewtickets() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			Connection con=DbConnection.getDbConn();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			RequestDispatcher rd=request.getRequestDispatcher("header"); 
			rd.include(request, response);
			out.println("<div style='margin: 30px'>");
			out.println("<table class='table' style='border: 2px solid black'>");
			out.println("<thead class='thead-dark'>");
			out.println("<tr>");
			out.println("<th scope='col'>No of Tickets Id</th>");
			out.println("<th scope='col'>Date</th>");
			out.println("<th scope='col'>MovieName</th>");
			out.println("<th scope='col'>Action</th>");
			out.println("</tr>");
			out.println("</thead>");
			out.println("<tbody>");
			
			HttpSession ses=request.getSession();
			
			String cid=(String)ses.getAttribute("username");
			
			PreparedStatement pst=con.prepareStatement("select * from moviebooking where uname=?;");
			pst.setString(1, cid);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				out.println("<tr>");
				out.println("<td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				out.println("<td><a href='cancelticket' style='color: blue'>cancel</a>&nbsp;&nbsp;&nbsp;<a href='updatetickethtml?bookingid="+rs.getString(1)+"' style='color: blue'>Update</a></td>");
				out.println("</tr>");
			}
			out.println("</tbody>");
			out.println("</table>");
			out.println("</div>");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
