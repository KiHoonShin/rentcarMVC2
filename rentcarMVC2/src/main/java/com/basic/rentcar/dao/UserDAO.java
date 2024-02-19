package com.basic.rentcar.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import com.basic.rentcar.vo.User;

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
	
	public int insertUser(String id, String pw, String email, String tel, String hobby, String job, String age, String info) {
		getConnect();
		String sql = "insert into member values(null,?,?,?,?,?,?,?,?)";
		int cnt = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			ps.setString(3, email);
			ps.setString(4, tel);
			ps.setString(5, hobby);
			ps.setString(6, job);
			ps.setString(7, age);
			ps.setString(8, info);
			cnt = ps.executeUpdate();
			System.out.println("회원 가입 성공 = " + cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}
	
	public int joinUser(User user) {
		getConnect();
		String sql = "insert into member values(null,?,?,?,?,?,?,?,?)";
		int cnt = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getId());
			ps.setString(2, user.getPw());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getTel());
			ps.setString(5, user.getHobby());
			ps.setString(6, user.getJob());
			ps.setString(7, user.getAge());
			ps.setString(8, user.getInfo());
			cnt = ps.executeUpdate();
			System.out.println("회원 가입 성공 = " + cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}
	
	public boolean isValidId(String id) {
		getConnect();
		String sql = "select pw from member where id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return false;
	}
	
	public void deleteUser(String id) {
		getConnect();
		String sql = "delete from member where id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			if(ps.executeUpdate()>0) {
				System.out.println(id+" 회원 삭제 완료");
			} else {
				System.out.println("삭제 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}
	
	public String findPw(String id , String email) {
		getConnect();
		String sql = "select * from member where id = ? and email = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, email);
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
	
	
	public String deleteCheckPw(String id) {
		getConnect();
		String sql = "select * from member where id = ?";
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
