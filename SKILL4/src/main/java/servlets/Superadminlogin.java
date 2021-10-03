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
import jakarta.servlet.http.HttpSession;
import workers.Managers;
import workers.AuthSuperAmin;

/**
 * Servlet implementation class Superadminlogin
 */
@WebServlet("/superadminlogin")
public class Superadminlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Superadminlogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AuthSuperAmin l = new AuthSuperAmin();
		try {
		boolean loginstatus = l.authaSuperAdmin(request.getParameter("uname"), request.getParameter("psw"));
		if(loginstatus) {
			HttpSession s=request.getSession();
			s.setAttribute("username", request.getParameter("uname"));
			PrintWriter out = response.getWriter();
//			RequestDispatcher rd=request.getRequestDispatcher("header"); 
//			rd.include(request, response);
		
			out.write("<!doctype html>\r\n"
					+ "<html lang=\"en\">\r\n"
					+ "<head>\r\n"
					+ "    <!-- Required meta tags -->\r\n"
					+ "    <meta charset=\"utf-8\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
					+ "\r\n"
					+ "    <!-- Bootstrap CSS -->\r\n"	
					+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\r\n"
					+ "        integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\" crossorigin=\"anonymous\">\r\n"
					+ "    <script  src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\"\r\n"
					+ "        integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\"\r\n"
					+ "        crossorigin=\"anonymous\"></script>\r\n"
					+ "\r\n"
					+ "        \r\n"
					+ "    <title>Movies</title>\r\n"
					+ "</head> <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\r\n"
					+ "        <div class=\"container-fluid\">\r\n"
					+ "            <a class=\"navbar-brand\" href=\"#\">Online Movie Ticket Booking System</a>\r\n"
					+ "            <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\"\r\n"
					+ "                data-bs-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\"\r\n"
					+ "                aria-label=\"Toggle navigation\">\r\n"
					+ "                <span class=\"navbar-toggler-icon\"></span>\r\n"
					+ "            </button>\r\n"
					+ "            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n"
					+ "                <ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">\r\n"
					+ "                    <li class=\"nav-item\">\r\n"
					+ "                        <a class=\"nav-link active\" aria-current=\"page\" href=\"/Move_Theatre_Ticket_Booking/\">Home</a>\r\n"
					+ "\r\n"
					+ " <li class=\"nav-item\">\r\n"
					+ "                        <a class=\"nav-link active\" aria-current=\"page\" href=\"#\">Hello   "+s.getAttribute("username")+"</a>\r\n"
					+ "\r\n"
					+ "                </li>     "
					+" <li class=\"nav-item active\">\r\n"
					+ "        <a class=\"nav-link\" href=\"addmanager\">Add managers <span class=\"sr-only\"></span></a>\r\n"
					+ "      </li>"
		
					+ "          </ul>\r\n"
					+ "\r\n"
					+ "            </div>\r\n"
					+ "        </div>\r\n"
					+ "    </nav>");
			RequestDispatcher r=request.getRequestDispatcher("movies");
			r.include(request, response);
			
		}
		else {
			response.getWriter().append("incorrect cred");
		}
		}
		catch(Exception e) {e.printStackTrace();}
	}
	

}
