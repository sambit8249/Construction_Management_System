package com.org.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.org.dto.User;

public class UserDao {

	public void saveUser(User user) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/c_management", "root", "root");
			PreparedStatement pst = con
					.prepareStatement("insert into user(name,age,mobile,email,password) values(?,?,?,?,?)");

			pst.setString(1, user.getName());
			pst.setString(2, user.getAge());
			pst.setString(3, user.getMobile());
			pst.setString(4, user.getEmail());
			pst.setString(5, user.getPassword());

			pst.executeUpdate();
			pst.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public User loginUser(String email, String password) {
		User user = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/c_management", "root", "root");
			PreparedStatement pst = con.prepareStatement("select * from user where email=? and password=?");

			pst.setString(1, email);
			pst.setString(2, password);

			ResultSet rst = pst.executeQuery();

			if (rst.next()) {
				String name = rst.getString("name");
				String age = rst.getString("age");
				String mobile = rst.getString("mobile");
				String mail = rst.getString("email");
				String pwd = rst.getString("password");

				user = new User();
				user.setName(name);
				user.setAge(age);
				user.setMobile(mobile);
				user.setEmail(mail);
				user.setPassword(pwd);

				return user;

			}
//			else
//			{
//				return false;
//			}
			con.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return user;

	}

	public void adduser(User user)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/c_management","root","root");
			PreparedStatement pst = con.prepareStatement("insert into user(name,age,mobile,email,password) values(?,?,?,?,?)");
			
			pst.setString(1, user.getName());
			pst.setString(2, user.getAge());
			pst.setString(3, user.getMobile());
			pst.setString(4, user.getEmail());
			pst.setString(5, user.getPassword());
			
			pst.executeUpdate();
			pst.close();
			
		
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
		
		public List<User> fetchAllUser()
		{
		List<User> list=new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/c_management","root","root");
			PreparedStatement pst = con.prepareStatement("select * from user");
			ResultSet rst = pst.executeQuery();
			
			while(rst.next())
			{
				int id = rst.getInt("id");
				String name = rst.getString("name");
				String age = rst.getString("age");
				String mobile = rst.getString("mobile");
				String mail = rst.getString("email");
				String pwd = rst.getString("password");

				User user = new User();
				user.setName(name);
				user.setAge(age);
				user.setMobile(mobile);
				user.setEmail(mail);
				user.setPassword(pwd);
				user.setId(id);
				
				list.add(user);

			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
			return list;
			
		}
		
		public User fetchUserById(int id)
		{
			User user=null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/c_management","root","root");
				PreparedStatement pst = con.prepareStatement("select * from user where id=?");
				pst.setInt(1, id);
				ResultSet rst = pst.executeQuery();
				if(rst.next())
				{
					int id1=rst.getInt("id");
					String name = rst.getString("name");
					String age = rst.getString("age");
					String mobile = rst.getString("mobile");
					String mail = rst.getString("email");
					String pwd = rst.getString("password");

					user = new User();
					
					user.setId(id1);
					user.setName(name);
					user.setAge(age);
					user.setMobile(mobile);
					user.setEmail(mail);
					user.setPassword(pwd);

				}
				
				
								
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return user;
		}
		
		public boolean updateUserById(int id,User user)
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/c_management","root","root");
				PreparedStatement pst = con.prepareStatement("update user set name=?,age=?,mobile=?,email=?,password=? where id=?");
				
				pst.setString(1, user.getName());
				pst.setString(2, user.getAge());
				pst.setString(3,user.getMobile());
				pst.setString(4, user.getEmail());
				pst.setString(5, user.getPassword());
				
				pst.setInt(6,user.getId());
				
				int row = pst.executeUpdate();
				if(row==1)
				{
					return true;
				}
				
				
				con.close();
		
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return false;

		}
		
		public void deleteUserById(int id)
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/c_management","root","root");
				PreparedStatement pst = con.prepareStatement("delete from  user where id=?");
				pst.setInt(1, id);
				
				pst.executeUpdate();
				con.close();
				
				
		
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
		}

	
	

}
