package servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import dbConnection.DbConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/cancelticket")
public class CancelTicketServlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		try
		{
			Connection con=DbConnection.getDbConn();
			res.setContentType("text/html");
			HttpSession ses=req.getSession();
			PrintWriter out = res.getWriter();
			String bid=(String)ses.getAttribute("username");
			System.out.println(bid);
			PreparedStatement pst=con.prepareStatement("delete from moviebooking where uname=?");
			pst.setString(1, bid);
			pst.execute();
			
			out.write("<h1>SUCCESSFULLY CANCELLED</h1>");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
