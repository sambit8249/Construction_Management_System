package com.org.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.UserDao;
import com.org.dto.User;
@WebServlet("/UserLogin")
public class userLogin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	
//	User user=new User();
	
//	user.setEmail(email);
//	user.setPassword(password);
	
	PrintWriter out = response.getWriter();
	response.setContentType("text/html");
	
	HttpSession session = request.getSession();
	
	UserDao d=new UserDao();
	User user = d.loginUser(email,password);
	
	if(user!=null)
	{
	
	session.setAttribute("userObj",user);
	response.sendRedirect("userHome.jsp");
	}
	else
	{
		session.setAttribute("fail", "Invalid email or password");
		response.sendRedirect("userLogin.jsp");
	}
	
	
	}

}
