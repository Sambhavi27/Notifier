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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter out=response.getWriter()){
			String userName=request.getParameter("username");
			
			String userPassword=request.getParameter("password");
			String confirm_password=request.getParameter("confirm_password");
			
			
			//connection
			UserDao dao=new UserDao(ConnectionProvider.getConnection());
			User u=dao.getUserLogin(userName,userPassword);
			if(u==null) {
				out.println("Invalid Details..Try Again!");
			}
			else {
				
				HttpSession s=request.getSession();
				s.setAttribute("currentUser", u);
				response.sendRedirect("dashboard.jsp");
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
