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
 * Servlet implementation class BookMovieTIckets
 */
@WebServlet("/bookmovie")
public class BookMovieTIcketsView extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BookMovieTIcketsView() {
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
		out.write(" <form class=\"form-horizontal\" action=\"bookmovie\" method=\"post\">\r\n"
				+ "        <div class=\"form-group\">\r\n"
				+ "          <label class=\"control-label col-sm-2\" for=\"email\">Movie Name:</label>\r\n"
				+ "          <div class=\"col-sm-10\">\r\n"
				+ "            <input type=\"text\" class=\"form-control\" id=\"email\" name=\"moviename\"value ="+request.getParameter("mname")+">\r\n"
				+ "          </div>\r\n"
				+ "        </div>\r\n"
				+ "        <div class=\"form-group\">\r\n"
				+ "          <label class=\"control-label col-sm-2\" for=\"pwd\">No of Tickets:</label>\r\n"
				+ "          <div class=\"col-sm-10\">\r\n"
				+ "            <input type=\"number\" class=\"form-control\" name=\"nooftickets\" id=\"pwd\" >\r\n"
				+ "          </div>\r\n"
				+ "        </div>\r\n"
				+ "\r\n"
				+ "        <div class=\"form-group\">\r\n"
				+ "            <label class=\"control-label col-sm-2\" for=\"pwd\">date</label>\r\n"
				+ "            <div class=\"col-sm-10\">\r\n"
				+ "              <input type=\"date\" class=\"form-control\" name=\"date\" id=\"pwd\" >\r\n"
				+ "            </div>\r\n"
				+ "          </div>\r\n"
				+ "        <div class=\"form-group\">\r\n"
				+ "          <div class=\"col-sm-offset-2 col-sm-10\">\r\n"
				+ "            <button type=\"submit\" class=\"btn btn-primary\">Submit</button>\r\n"
				+ "          </div>\r\n"
				+ "        </div>\r\n"
				+ "      </form> ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		MovieBookin book = new MovieBookin();
		try {
			HttpSession s=request.getSession();
			System.out.println(s.getAttribute("username"));
		boolean bookstatus = book.MoveiTicketBooking(request.getParameter("nooftickets"),request.getParameter("moviename"),request.getParameter("date"),(String)s.getAttribute("username"));
		if(bookstatus)response.getWriter().write("successfully booked");
		else response.getWriter().write("booking failed");
		}
		catch(Exception e) {
			
		}
		
		}

}
