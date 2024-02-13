package com.basic.rentcar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

	private UserDAO() {}
	
	private static UserDAO instance;
	public static UserDAO getInstance() {
		if(instance == null) {
			instance = new UserDAO();
		}
		return instance;
	}
	
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public Connection getConnect() {
		String url = "jdbc:mysql://localhost:3306/rentcardb01?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
		String id = "root";
		String pw = "1234";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url, id, pw);
			} catch (Exception e) {
				e.printStackTrace();
			}
		return conn;
	}
	
	public String checkingId(String id) {
		getConnect();
		String sql = "select * from member where id = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getString("pw");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return null;
	}
	
	
	
	
	
	private void dbClose() {
		if(conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(ps != null)
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
}
