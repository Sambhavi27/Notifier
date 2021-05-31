package com.notifier.dao;
import com.notifier.entities.User;
import java.sql.*;
public class UserDao {

	private Connection con;

	public UserDao(Connection con) {
		
		this.con = con;
	}
	
	public boolean saveUser(User user) {
		boolean f =false;
		try {
			
			String query="insert into users(username,mobilenumber,email,password,confirm_password) value(?,?,?,?,?)";
			PreparedStatement pstmt=this.con.prepareStatement(query);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2,user.getMobilenumber());
			pstmt.setString(3,user.getEmail());
			pstmt.setString(4,user.getPassword());
			pstmt.setString(5,user.getConfirm_password());
			
			pstmt.executeUpdate();
			f=true;
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	
	public User getUserLogin(String username,String password) {
		User user=null;
		try {
			
			String query="select * from users where username=? and password=?";
			PreparedStatement pstmt=this.con.prepareStatement(query);
			pstmt.setString(1,username);
			pstmt.setString(2,password);
			
			
			ResultSet res=pstmt.executeQuery();
			if(res.next()) {
				user=new User();
				
				
				user.setUsername(res.getString("username"));
				user.setId(res.getInt("id"));
				user.setEmail(res.getString("email"));
				user.setMobilenumber(res.getString("mobilenumber"));
				user.setPassword(res.getString("password"));
				user.setConfirm_password(res.getString("confirm_password"));
				
				
				
			}
			
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
	public boolean updateUser(User user) {
		boolean f=false;
		try {
			
			String query="update users set username=?,mobilenumber=?,email=?,password=?,confirm_password=? where id=?";
			PreparedStatement p=con.prepareStatement(query);
			p.setString(1,user.getUsername());
			p.setString(2, user.getMobilenumber());
			p.setString(3,user.getEmail());
			p.setString(4,user.getPassword());
			p.setString(5,user.getPassword());
			p.setInt(6,user.getId());
			
			p.executeUpdate();
			f=true;
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
