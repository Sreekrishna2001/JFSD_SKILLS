package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import workers.AuthCustormer;

/**
 * Servlet implementation class Logincust
 */
@WebServlet("/loginc")
public class Logincust extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Logincust() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("/Move_Theatre_Ticket_Booking/");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AuthCustormer l = new AuthCustormer();
		System.out.println(request.getParameter("uname")+request.getParameter("psw"));
		boolean loginstatus = l.loginCustomer(request.getParameter("uname"), request.getParameter("psw"));
		if(loginstatus) {
			HttpSession s=request.getSession();
			s.setAttribute("username", request.getParameter("uname"));
			PrintWriter out = response.getWriter();
			RequestDispatcher rd=request.getRequestDispatcher("header"); 
			rd.include(request, response);
			RequestDispatcher r=request.getRequestDispatcher("movies");
			r.include(request, response);
			
		}
		else {
			response.getWriter().append("incorrect cred");
		}
	}

}
