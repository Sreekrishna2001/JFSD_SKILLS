package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import workers.Managers;

/**
 * Servlet implementation class Addmanagerview
 */
@WebServlet("/addmanager")
public class Addmanagerview extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Addmanagerview() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		RequestDispatcher rd=request.getRequestDispatcher("header"); 
		rd.include(request, response);
		out.write("    <body><form action=\"addmanager\" method=\"post\">\r\n"
				+ "        <div class=\"form-group\">\r\n"
				+ "          <label for=\"exampleInputEmail1\">Manager Name:</label>\r\n"
				+ "          <input type=\"text\" class=\"form-control\" name=\"mname\" id=\"exampleInputEmail1\" aria-describedby=\"emailHelp\" placeholder=\"Enter email\">\r\n"
				+ "          <small id=\"emailHelp\" class=\"form-text text-muted\">We'll never share your email with anyone else.</small>\r\n"
				+ "        </div>\r\n"
				+ "        <div class=\"form-group\">\r\n"
				+ "          <label for=\"exampleInputPassword1\">Assign Password</label>\r\n"
				+ "          <input type=\"password\" class=\"form-control\" name=\"psw\" id=\"exampleInputPassword1\" placeholder=\"Password\">\r\n"
				+ "        </div>\r\n"
				+ "        <div class=\"form-check\">\r\n"
				+ "          <input type=\"checkbox\" class=\"form-check-input\" id=\"exampleCheck1\">\r\n"
				+ "          <label class=\"form-check-label\" for=\"exampleCheck1\">Check me out</label>\r\n"
				+ "        </div>\r\n"
				+ "        <button type=\"submit\" class=\"btn btn-primary\">Submit</button>\r\n"
				+ "      </form></body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		Managers m = new Managers();
		try {
			boolean mstat = m.addManager(request.getParameter("mname"), request.getParameter("psw"));
			if(mstat) {
				RequestDispatcher rd=request.getRequestDispatcher("header"); 
				rd.include(request, response);
				response.getWriter().write("Successfully added manager");
				
			}
		}
		catch(Exception e) {};
	}

}
