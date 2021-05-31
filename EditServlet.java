package com.notifier.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.notifier.dao.UserDao;
import com.notifier.entities.User;
import com.notifier.helper.ConnectionProvider;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter out=response.getWriter()){
			String username=request.getParameter("username");
			String mobilenumber=request.getParameter("mobilenumber");
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			
			
			HttpSession s=request.getSession();
			User user=(User)s.getAttribute("currentUser");
			user.setUsername(username);
			user.setMobilenumber(mobilenumber);
			user.setEmail(email);
			user.setPassword(password);
			
			
			UserDao userDao=new UserDao(ConnectionProvider.getConnection());
			boolean ans=userDao.updateUser(user);
			if(ans) {
				out.println("updated to db");
			}
			else {
				out.println("not updated to db");
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
