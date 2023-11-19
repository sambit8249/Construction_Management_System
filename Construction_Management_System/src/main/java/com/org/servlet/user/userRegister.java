package com.org.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.UserDao;
import com.org.dto.User;
@WebServlet("/UserRegister")
public class userRegister extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user=new User();
		
		user.setName(name);
		user.setAge(age);
		user.setMobile(mobile);
		user.setEmail(email);
		user.setPassword(password);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		UserDao d=new UserDao();
		d.saveUser(user);
//		RequestDispatcher rd = request.getRequestDispatcher("userRegister.jsp");
//		rd.include(request, response);
//		out.println("registered");
		
		HttpSession session = request.getSession();
		session.setAttribute("success", "Registration Sucessfully");
		response.sendRedirect("userRegister.jsp");
		
		
		
		
		
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_management","root","root");
//			PreparedStatement pst = con.prepareStatement("insert into user(name,age,mobile,email,password) values(?,?,?,?,?)");
//			pst.setString(1, name);
//			pst.setString(2, age);
//			pst.setString(3, mobile);
//			pst.setString(4, email);
//			pst.setString(5, password);
//			
//			pst.executeUpdate();
//			out.println("REGISTRATION DONE SUCESSFULLY");
//			con.close();
//			
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//		
		
	}

}
