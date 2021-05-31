<%@page import="com.notifier.helper.ConnectionProvider"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login</title>
		<!-- css -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link href="css/mystyle.css" rel="stylesheet" type="text/css"/>
	
	</head>
	<body>
		
		 <div class="container " style="background-color:#f5eeed">
			   <h1 style="text-align:center;margin-top:20px;padding-top:20px">Remind Me</h1>
               <div class="col-md-6 offset-md-3">
               <h2  style="margin-top: 10px; padding-bottom:20px" class=center-align>Login</h2>
               <form action="LoginServlet" method="post">
				   <div class="form-group">
	                    <input type="text" class="form-control" id="uname" placeholder="username" name="username" required>
	               </div>
	               <div class="form-group">
	                     <input type="password" class="form-control" id="password" placeholder="password" name="password" required>
	               </div>
				   <button type="submit" class="btn btn-success btn-lg btn-block ">Submit</button>
               </form>
       
        	   <p>Not a member?<a href="Register.jsp">SignUp</a>
               <br>
               <br>
               <br>
               </div>
       </div>
       
		
		
		
		
		<!-- JS -->
		<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
				
	
	
	</body>
</html>