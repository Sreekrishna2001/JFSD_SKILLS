package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import workers.MovieBookin;

/**
 * Servlet implementation class ViewMovies
 */
@WebServlet("/movies")
public class ViewMovies extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ViewMovies() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
		PrintWriter out  = response.getWriter();
		MovieBookin m = new MovieBookin();
		ResultSet movies = m.getMovies();
//		RequestDispatcher rd=request.getRequestDispatcher("header"); 
//		rd.include(request, response);
		out.write("<body><div class=\"container\">\r\n"
				+ "  <div class=\"row\">");
		while(movies.next()) {
			out.write("    "
					+ "    <div class=\"col-sm\">\r\n"
					+ "<form action=\"/Move_Theatre_Ticket_Booking/bookmovie\" method = \"get\" ><div class=\"card\" style=\"width: 18rem;\">\r\n"
					+"<input name=\"mname\" value ="+"\""+movies.getString(1)+"\""+"hidden>"
					+ "        <img class=\"card-img-top\" src="+movies.getString(2)
					+ "        <div class=\"card-body\">\r\n"
					+ "          <h5 class=\"card-title\">"+movies.getString(1)+"</h5>\r\n"
					+ "          <p class=\"card-text\">"+movies.getString(3)+"</p>\r\n"
					+ "          <button type=\"submit\"  class=\"btn btn-primary\">Book Now</a>\r\n"
					+ "        </div>\r\n"
					+ "      </form>"
					+ "    </div>\r\n"
					);
		}
		out.write("</div>\r\n"+ "</div>");
		
		out.write("</body>\r\n"
				+ "</html>");
		}
		catch(Exception e) {e.printStackTrace();}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
