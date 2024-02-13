package com.basic.rentcar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

import com.basic.rentcar.vo.Rentcar;

public class RentCarDAO {
	private RentCarDAO() {}
	
	private static RentCarDAO instance;
	public static RentCarDAO getInstance() {
		if(instance == null) {
			instance = new RentCarDAO();
		}
		return instance;
	}
	
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	private Connection getConnect() {
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
	
	public ArrayList<Rentcar> allRentcarList() {
		ArrayList<Rentcar> list = new ArrayList<Rentcar>();
		getConnect();
		String sql = "select * from rentcar";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				int category = rs.getInt("category");
				int price = rs.getInt("price");
				int usepeople = rs.getInt("usepeople");
				int total_qty = rs.getInt("total_qty");
				String company = rs.getString("company");
				String img = rs.getString("img");
				String info = rs.getString("info");
				Rentcar r = new Rentcar(no, name, category, price, usepeople, total_qty, company, img, info);
				list.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}
	
	public ArrayList<Rentcar> mainRentCarListImg() {
		ArrayList<Rentcar> list = new ArrayList<Rentcar>();
		getConnect();
		String sql = "select * from rentcar order by no DESC";
		int cnt = 0;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				int category = rs.getInt("category");
				int price = rs.getInt("price");
				int usepeople = rs.getInt("usepeople");
				int total_qty = rs.getInt("total_qty");
				String company = rs.getString("company");
				String img = rs.getString("img");
				String info = rs.getString("info");
				Rentcar r = new Rentcar(no, name, category, price, usepeople, total_qty, company, img, info);
				list.add(r);
				cnt += 1;
				
				if(cnt == 3) {
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}
	
	public Rentcar getOneRentcarInfo(int num) {
		ArrayList<Rentcar> list = allRentcarList();
		for(Rentcar r : list) {
			if(r.getNo() == num) {
				return r;
			}
		}
		return null;
	}
	
	public ArrayList<Rentcar> getCategoryCar(int cate){
		ArrayList<Rentcar> list = new ArrayList<Rentcar>();
		String sql = "select * from rentcar where category = ?";
		getConnect();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,cate);
			rs = ps.executeQuery();
			while(rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				int category = rs.getInt("category");
				int price = rs.getInt("price");
				int usepeople = rs.getInt("usepeople");
				int total_qty = rs.getInt("total_qty");
				String company = rs.getString("company");
				String img = rs.getString("img");
				String info = rs.getString("info");
				Rentcar r = new Rentcar(no, name, category, price, usepeople, total_qty, company, img, info);
				list.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}
	
	private void dbClose() {
		if(ps != null)
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
