package com.notifier.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.notifier.dao.NotesDao;
import com.notifier.entities.Notes;
import com.notifier.entities.User;
import com.notifier.helper.ConnectionProvider;

/**
 * Servlet implementation class AddNoteServlet
 */
@WebServlet("/AddNoteServlet")
@MultipartConfig
public class AddNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter out=response.getWriter()){
			int bid=Integer.parseInt(request.getParameter("bid"));
			String name=request.getParameter("Nname");
			String reminder=request.getParameter("Nreminder");
			String end =request.getParameter("Nend");
			String status=request.getParameter("Nstatus");
			String tag=request.getParameter("Ntag");
			String desc=request.getParameter("Ndescription");
			
			
			HttpSession session=request.getSession();
			User user=(User)session.getAttribute("currentUser");
			
			Notes n=new Notes(name,null,null,null,status,tag,desc,bid,user.getId());
			NotesDao dao=new NotesDao(ConnectionProvider.getConnection());
			if(dao.saveNotes(n)) {
				out.println("done");
			}
			else {
				out.println("error");
			}
		
		}
		
			
		
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
