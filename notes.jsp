<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.notifier.dao.NotesDao" %>
  <%@page import="com.notifier.entities.Notebook" %>
   <%@page import="java.util.*" %>
    <%@page import="com.notifier.helper.ConnectionProvider" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
<!-- add notes modal -->
	 <nav class="navbar navbar-expand-md navbar-dark"
  style="background-color:#343a40">
 

  <ul class="navbar-nav navbar-collapse justify-content-end">
   <li><a style="color:grey" href="#" data-toggle="modal" data-target="#add-notes-modal">
   New Note
   </a>
   </li>
   <li>
   <a href="LogoutServlet" class="nav-link">
   <i class="fa fa-sign-out" aria-hidden="true"></i>
   Logout
   </a>
   </li>
  
  </ul>
 
 </nav>
  <nav class="navbar navbar-expand-md navbar-dark">
 
  <ul class="navbar-nav navbar-collapse justify-content-end">
   <li><a href="" class="nav-link">
 
   <form class="form-inline">
    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
  </form>
   </a>
   </li>
 
  
  </ul>
 
 </nav>
	

<!-- Modal -->
<div class="modal fade" id="add-notes-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel" style="padding-left:150px">ADD NOTE</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <form id="add-notes-form" action="AddNoteServlet" method="post">
      					
					<div class="form-group">
                       <select class="form-control"name="bid" required>
                    	<option selected disabled>----Select Notebook---</option>
                    	<%
                    	NotesDao nd=new NotesDao(ConnectionProvider.getConnection());
                    	ArrayList<Notebook> list=nd.getAllNotebooks();
                    	for(Notebook c:list)
                    	{
                    	%>
                    	<option value="<%=c.getBid() %>"><%= c.getName()%></option>
                    	
                    	<%
                    	}
                    	%>
                    </select>
                    </div>
					<div class="form-group">
                       <input type="text" class="form-control" placeholder="Enter note name" name="Nname" required>
                    </div>
                    <div class="form-group">
                      <label>Enter end date</label> <input type="date" class="form-control" id="end" placeholder="Enter end date" name="Nend" required>
                    </div>
                     <div class="form-group">
                      <label>Enter reminder date</label> <input type="date" class="form-control" id="reminder" placeholder="Enter reminder date" name="Nreminder" required>
                    </div>
                     <div class="form-group">
                       <input type="text" class="form-control" id="status" placeholder="Enter status" name="Nstatus" required>
                    </div>
                     <div class="form-group">
                       <input type="text" class="form-control" id="tag" placeholder="Enter tag" name="Ntag" required>
                    </div>
                    <div class="form-group">
                       <input type="text" class="form-control" id="description" placeholder="Enter description" name="Ndescription" required>
                    </div>
                     <button type="submit" class="btn btn-success btn-lg" >Submit</button>
 				
 			</form>
      </div>
      
    </div>
  </div>
</div>
	
<!-- end notes  -->
<!-- JS -->
		<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
		<script>
		$(document).ready(function (e){
			$("#add-notes-form").on('submit',function(event){
				event.preventDefault();
				console.log("You clicked");
				let f=new FormData(this);
				$.ajax({
					url : "AddNoteServlet",
					type : 'POST',
					data : f,
					success: function(data,textStatus,jqXHR){
						console.log(data);
					},
					error: function(jqXHR,textStatus,errorThrown){
						
					},
					processData:false,
					contentType:false
					
				})
			})
		})
		
		</script>

</body>
</html>