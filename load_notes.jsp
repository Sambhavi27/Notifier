<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.notifier.dao.NotesDao" %>
  <%@page import="com.notifier.entities.Notes" %>
   <%@page import="java.util.*" %>
    <%@page import="com.notifier.helper.ConnectionProvider" %>
<div class="row">


<% NotesDao d=new NotesDao(ConnectionProvider.getConnection());
List<Notes> note=d.getAllNotes();
for(Notes n:note){
	

	%>
	<div class="col-md-6 mt-3">
	<div class="card">
	
	<div class="card--body">
	<h3><%=n.getName() %></h3>
	<h3><%=n.getDescription() %></h3>
	</div>
	</div>
	
	</div>
	<%} %>
	</div>
	

 