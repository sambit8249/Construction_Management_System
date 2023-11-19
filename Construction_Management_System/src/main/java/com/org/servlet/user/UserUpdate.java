package com.org.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.dao.UserDao;
import com.org.dto.User;
@WebServlet("/userUpdate")
public class UserUpdate  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strId = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		int id1=Integer.parseInt(strId);
		
		User user=new User();
		user.setName(name);
		user.setAge(age);
		user.setMobile(mobile);
		user.setEmail(email);
		user.setPassword(password);
		user.setId(id1);
		
		UserDao dao=new UserDao();
		
		dao.updateUserById(id1, user);
		response.sendRedirect("fetchAllUser.jsp");
	}

}
