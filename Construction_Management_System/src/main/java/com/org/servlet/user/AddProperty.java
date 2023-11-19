package com.org.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddProperty")
public class AddProperty extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String location = request.getParameter("location");
		String price = request.getParameter("price");
		String description = request.getParameter("description");

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/c_management", "root", "root");
			PreparedStatement pst = con
					.prepareStatement("insert into properties(name,location,price,description) values(?,?,?,?)");
			pst.setString(1, name);
			pst.setString(2, location);
			pst.setString(3, price);
			pst.setString(4, description);

			pst.executeUpdate();
//			out.println("REGISTRATION DONE SUCESSFULLY");
			HttpSession session = request.getSession();
			session.setAttribute("success", "Added Succesfully");
			response.sendRedirect("addProperty.jsp");
			con.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
