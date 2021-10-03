<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "jakarta.servlet.http.*,jakarta.servlet.*" %>
<%@ page import = "models.Book" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<title>Insert title here</title>
    <style>
    .card-img-top {
    width: 100%;
    height: 15vw;
    object-fit: cover;
}
body{background: #34e89e;  /* fallback for old browsers */
background: -webkit-linear-gradient(to right, #0f3443, #34e89e);  /* Chrome 10-25, Safari 5.1-6 */
background: linear-gradient(to right, #0f3443, #34e89e); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */}
    </style>
</head>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark color-white">
  <a class="navbar-brand" href="catalogue.jsp">Book Store</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse ml-auto" id="navbarNavAltMarkup">
    <div class="navbar-nav ml-auto">
      <a class="nav-item nav-link active" href="catalogue.jsp">Go Back <span class="sr-only">(current)</span></a>
    </div>
  </div>
</nav>
<body>
<center><h1>This is User Cart Displaying Elements With Session</h1></center>
<div class="container-fluid">
    <div class="row">

     <%
			ArrayList<Book> lst = (ArrayList<Book>)session.getAttribute("cart");	
                        	for(Book b : lst){%>
                        	<div class="card mr-2" style="width: 18rem;">
  	<img class="card-img-top" src=<%=b.bookcoverurl%> alt="Card image cap">
  	<div class="card-body">
    	<h5 class="card-title"><%=b.bookname%></h5>
   	 <p class="card-text"><%=b.bookdesc%></p>
   	 </p><spab><u>Price-Rs<%=b.bookprice%></u></spab>
    	<a href="vewcart?bookid=<%=b.bookid%>" class="btn btn-primary">Remove from Cart</a>
 	 </div>
	</div>
                <%} %>
    </div>
     </div>
         <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>