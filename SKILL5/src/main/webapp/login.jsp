<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="login.css">
</head>
<style>
body{
background: #34e89e;  /* fallback for old browsers */
background: -webkit-linear-gradient(to right, #0f3443, #34e89e);  /* Chrome 10-25, Safari 5.1-6 */
background: linear-gradient(to right, #0f3443, #34e89e); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
}
</style>

<body>
    <div>
          <nav class="navbar navbar-expand-lg navbar-dark bg-dark color-white">
  <a class="navbar-brand" href="index.jsp">Book Store</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse ml-auto" id="navbarNavAltMarkup">
    <div class="navbar-nav ml-auto">
      
      <a class="nav-item nav-link active" href="register.jsp">Register <span class="sr-only">(current)</span></a>
      <a class="nav-item nav-link active" href="login.jsp">Login <span class="sr-only">(current)</span></a>
    </div>
  </div>
</nav>
    </div>


    <div>
        <form class="loginform" action="checkcustomer" method="get">
            <div class="userlogo">
                <i class="fa fa-user-circle" style="font-size: 60px;" aria-hidden="true"></i>
            </div>
            <h3 class="heading">Customer Login</h3>
            <div class="main">
                <div class="form-group">
                    <input type="text" name="username" placeholder="Username" class="form-control" required>
                </div>
                <div class="form-group">
                    <input type="password" name="password" placeholder="password" class="form-control" required>
                </div>
                <button class="btn btn-primary" type="submit">Login</button>
            </div>
			<div style="margin-bottom: 20px;text-align: center;">
                <p>Already have an account: <a href="register.jsp" style="color: blue;">Signup</a></p>
            </div>
            <div style="margin-bottom: 20px;text-align: center;">
                <p>Forgot Password: <a href="forgotpass.jsp" style="color: blue;">Reset here</a></p>
            </div>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
</body>

</html>