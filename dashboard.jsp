<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.notifier.entities.User" %>
<%

User user=(User)session.getAttribute("currentUser");
if(user==null){
	response.sendRedirect("index.jsp");
}

%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Dashboard</title>
		<!-- css -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link href="css/mystyle.css" rel="stylesheet" type="text/css"/>
	
	</head>
	<body>

		<jsp:include page="header.jsp"></jsp:include>
		<div style="background-color:#f5eeed">

			<div class="row">

  				<div class="col-2 table-dark" style="font-size:20px">
  				<div class="title" style="font-size:30px;padding-left:10px">
 					<%=user.getUsername() %>
 					</div>
					<br>
  					<br>
  					<div class="col-1">
  					<a style="color:white" href="notebook.jsp" >Notebooks</a>
  					
  					<a style="color:white" href="notes.jsp" >Notes</a>
  					
  					<a style="color:white" href="#!" data-toggle="modal" data-target="#profile-modal">EditUser</a>
  					</div>
					  <br>
					  <br>
					 
 
  				</div>
  				

  				<div class="col-8 " style="margin-top:60px; font-size:40px">Notes
  
  					<div style="background-color:white;font-size:20px">
 
  						
 					</div>
  
  				</div>
  
  
  
			</div>
		</div>


<!-- Profile Details -->



<!-- Modal -->
<div class="modal fade" id="profile-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel" style="padding-left:150px">EDIT USER</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        
        <form action="EditServlet" method="post">
					<div class="form-group">
                        <label for="uname">UserName</label> <input type="text" class="form-control" id="uname" value="<%=user.getUsername() %>" name="username" required>
                    </div>

                    <div class="form-group">
                      <label>MobileNumber</label> <input type="text" class="form-control" id="mobile" value="<%=user.getMobilenumber() %>" name="mobilenumber" required>
                    </div>

                    <div class="form-group">
                    <table>
                    <tr>
                    <td><label>Email</label></td>
                    <td><input type="email" class="form-control" id="email" value="<%=user.getEmail() %>" name="email" required></td>
                    <td><label>Password</label></td>
                    <td><input type="password" class="form-control" id="password" value="<%=user.getPassword() %>" name="password" required>
                    </tr>
                    </table>
                    </div>
                   
                     <button type="submit" class="btn btn-success btn-lg" style="margin-left:200px">Save</button>
 				
 			</form>
      </div>
     
    </div>
  </div>
</div>

<!-- end -->


<!-- JS -->
		<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
		


</body>
</html>