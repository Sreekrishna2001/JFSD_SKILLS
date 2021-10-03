<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "jakarta.servlet.http.*,jakarta.servlet.*" %>
<% 
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jfsd_skills","root","kittu2001");
	Statement st=con.createStatement();
%>
<html>
<head>
<title>Books in db</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<style>
table,h1{
margin-top:50px;
margin-left:auto;
margin-right:auto;

}
table, th, td {
  border:1px solid black;
  background:white;
}
body{background: #34e89e;  /* fallback for old browsers */
background: -webkit-linear-gradient(to right, #0f3443, #34e89e);  /* Chrome 10-25, Safari 5.1-6 */
background: linear-gradient(to right, #0f3443, #34e89e); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */}
</style>
<h1 style="margin-left:450px;color:white">Details Of The Books In Database:</h1>
 
                     
 <table >
                       <thead>
                           <tr>
                              <th >book name</th>
                              <th scope="col">bookid</th>
                              <th scope="col">book author</th>
                              <th scope="col">book des</th>
                              <th scope="col">book price</th>
                              <th scope="col">book cover url</th>
                           </tr>
                        </thead>
                        <tbody>
                        <%
							Statement ast=con.createStatement();
                        	ResultSet rst=ast.executeQuery("select * from book");
                        	while(rst.next()){
                        %>
                           <tr>
                              <th scope="row"><%=rst.getInt(1) %></th>
                              <td><%=rst.getString(2) %></td>
                              <td><%=rst.getString(3) %></td>
                              <td><%=rst.getString(4) %></td>
                              <td><%=rst.getInt(5) %></td>
                              <td><%=rst.getString(6) %></td>
                           </tr>
                         <%} %>
                        </tbody>
                     </table>
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>