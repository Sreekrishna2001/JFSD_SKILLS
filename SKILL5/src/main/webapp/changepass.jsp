<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*,dbConnection.Dbcon"%>
<%@ page import = "jakarta.servlet.http.*,jakarta.servlet.*" %>
<% 
	Connection con = Dbcon.getDbConn();
	PreparedStatement pst = con.prepareStatement("update users set password =? where username =? and mobileno =? ;");
	pst.setString(1,request.getParameter("newpassword"));pst.setString(2,request.getParameter("username"));pst.setString(3,request.getParameter("mobile"));
	
	boolean s = pst.execute();
	if(!s){
		response.sendRedirect("login.jsp");
	}
	else{
		response.getWriter().append("error while resetting password");
	}
%>