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
 * Servlet implementation class CustomerReg
 */
@WebServlet("/customerReg")
public class CustomerReg extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CustomerReg() {
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
			PreparedStatement pst = db.prepareStatement("insert into users(email,username,gender,mobileno,password) values(?,?,?,?,?);");
			pst.setString(1, request.getParameter("email"));pst.setString(2, request.getParameter("username"));pst.setString(3, request.getParameter("gender"));
			pst.setString(4, request.getParameter("mobile"));pst.setString(5, request.getParameter("password"));
			pst.execute();
			response.sendRedirect("login.jsp");
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
