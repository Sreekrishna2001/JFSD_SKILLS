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
import workers.MovieBookin;

/**
 * Servlet implementation class Addmovies
 */
@WebServlet("/addmovies")
public class Addmoviesview extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Addmoviesview() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		HttpSession s=request.getSession();
		RequestDispatcher rd=request.getRequestDispatcher("header"); 
		rd.include(request, response);
		out.println("<body>      <form class=\"form-horizontal\" action=\"addmovies\" method=\"post\">\r\n"
				+ "        <div class=\"form-group\">\r\n"
				+ "          <label class=\"control-label col-sm-2\" for=\"email\">Manager Name:</label>\r\n"
				+ "          <div class=\"col-sm-10\">\r\n"
				+ "            <input type=\"text\" class=\"form-control\" id=\"email\"value="+s.getAttribute("username")+" readonly>\r\n"
				+ "          </div>\r\n"
				+ "        </div>\r\n"
				+ "        <div class=\"form-group\">\r\n"
				+ "          <label class=\"control-label col-sm-2\" for=\"pwd\">Movie Name:</label>\r\n"
				+ "          <div class=\"col-sm-10\">\r\n"
				+ "            <input type=\"text\" class=\"form-control\" name=\"mname\" id=\"pwd\" >\r\n"
				+ "          </div>\r\n"
				+ "        </div>\r\n"
				+ "\r\n"
				+ "        <div class=\"form-group\">\r\n"
				+ "            <label class=\"control-label col-sm-2\" for=\"pwd\">movie cover url</label>\r\n"
				+ "            <div class=\"col-sm-10\">\r\n"
				+ "              <input type=\"url\" class=\"form-control\" id=\"pwd\" name=\"mcover\" >\r\n"
				+ "            </div>\r\n"
				+ "          </div>\r\n"
				+ "          <div class=\"form-group\">\r\n"
				+ "            <label class=\"control-label col-sm-2\" for=\"pwd\">Movie desc:</label>\r\n"
				+ "            <div class=\"col-sm-10\">\r\n"
				+ "              <input type=\"text\" class=\"form-control\" id=\"pwd\" name=\"mdesc\">\r\n"
				+ "            </div>\r\n"
				+ "          </div>\r\n"
				+ "        <div class=\"form-group\">\r\n"
				+ "          <div class=\"col-sm-offset-2 col-sm-10\">\r\n"
				+ "            <button type=\"submit\" class=\"btn btn-primary\">Submit</button>\r\n"
				+ "          </div>\r\n"
				+ "        </div>\r\n"
				+ "      </form> </body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MovieBookin mb = new MovieBookin();
		try {
			boolean bookst = mb.addMove(request.getParameter("mname"),request.getParameter("mcover"),request.getParameter("mdesc"));
			if(bookst)response.getWriter().write("successfully added");
			else response.getWriter().write("error");
		}
		catch(Exception e) {}
		
	}

}
