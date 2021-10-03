package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import dbConnection.Dbcon;
import models.User;
/**
 * Servlet implementation class Checkcustomer
 */
@WebServlet("/checkcustomer")
public class Checkcustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Checkcustomer() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		Connection db = Dbcon.getDbConn();
		try {
//			System.out.println(request.getParameter("username")+" "+request.getParameter("password"));
			PreparedStatement pst = db.prepareStatement("select count(*) from users where username=? and password = ?");
			pst.setString(1, request.getParameter("username"));pst.setString(2, request.getParameter("password"));
			ResultSet rs = pst.executeQuery();
			rs.next();
//			System.out.println(rs.getInt(1));
			HttpSession ses = request.getSession();
			if(rs.getInt(1) == 1) {
				ses.setAttribute("username",request.getParameter("username"));
				response.sendRedirect("catalogue.jsp");}
			else{
				response.sendRedirect("login.jsp");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
