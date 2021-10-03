package Main;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import DBConnection.Dbcon;


@WebServlet("/custReg")
public class CustomerReg extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		try
		{
			Connection con=Dbcon.getDbConn();
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			String name=req.getParameter("name");
			String email=req.getParameter("email");
			String username=req.getParameter("username");
			String password=req.getParameter("password");
			String mobileno=req.getParameter("mobile");
			String gender=req.getParameter("gender");
			String location=req.getParameter("location");
			Long mobile=Long.parseLong(mobileno);
			
			PreparedStatement pst=con.prepareStatement("insert into customers(name,gender,username,email,password,mobileno,location) values(?,?,?,?,?,?,?)");
			pst.setString(1, name);
			pst.setString(2, gender);
			pst.setString(3, username);
			pst.setString(4, email);
			pst.setString(5,password);
			pst.setLong(6, mobile);
			pst.setString(7, location);
			int a=pst.executeUpdate();

//			RequestDispatcher rd=req.getRequestDispatcher("header_superadmin.html");
//			rd.include(req, res);
			
			if(a==1)
			{
				res.sendRedirect("customerLogin.html");
			}
			else
			{
				out.println("<div class='container'>");
				out.println("<div class='alert alert-danger' >");
				out.println("<h1>failed to login</h1>");
				out.println("<a href='customerRegistration.html' style='color: blue'>Book Tickets</a>");
				out.println("</div>");
				out.println("</div>");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	
	
	
}
