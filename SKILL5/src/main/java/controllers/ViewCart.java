package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import dbConnection.Dbcon;
import models.Book;

/**
 * Servlet implementation class ViewCart
 */

@WebServlet("/viewcart")
public class ViewCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ViewCart() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
		Connection db = Dbcon.getDbConn();
		String bookid = (String)request.getParameter("bookid");
		int bid = Integer.parseInt(bookid);
		PreparedStatement pst = db.prepareStatement("select * from book where bookid = ?");
		pst.setInt(1,bid);
		ResultSet rs = pst.executeQuery();
		Book b = new Book();
		while(rs.next()) {
			b.setBookid(rs.getInt(1));
			b.setBookname(rs.getString(2));
			b.setBookauthor(rs.getString(3)); 			
			b.setBookdesc(rs.getString(4));
			b.setBookprice(rs.getInt(5));
			b.setBookcoverurl(rs.getString(6));
		}
		HttpSession s = request.getSession();
		if(s.getAttribute("cart")!=null) {
			ArrayList<Book> blst = (ArrayList<Book>)s.getAttribute("cart");
			blst.add(b);
			s.setAttribute("cart", blst);
		}
		else {
			ArrayList<Book> blst = new ArrayList<Book>();
			blst.add(b);
			s.setAttribute("cart", blst);
		}

		
//		RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
		response.sendRedirect("cart.jsp");
		}
		catch(Exception e) {e.printStackTrace();}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
