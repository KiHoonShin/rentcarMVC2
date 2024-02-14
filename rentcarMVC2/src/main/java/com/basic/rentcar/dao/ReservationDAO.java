package com.basic.rentcar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.basic.rentcar.vo.Reservation;

public class ReservationDAO {
	
	private ReservationDAO() {}

	private static ReservationDAO instance;
	public static ReservationDAO getInstance() {
		if(instance == null) {
			instance = new ReservationDAO();
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
			conn = DriverManager.getConnection(url,id,pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public ArrayList<Reservation> getReserveList(String id2){
		ArrayList<Reservation> list = new ArrayList<Reservation>();
		Reservation r = null;
		getConnect();
		String sql = "select * from rentcar c1 , carreserve c2 where c2.id = ? and c1.no = c2.no";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id2);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				r = new Reservation();
				r.setReserve_seq(rs.getInt("reserve_seq"));
				r.setNo(rs.getInt("no"));
				//String id = rs.getString("id");
				r.setQty(rs.getInt("qty"));
				r.setDday(rs.getInt("dday"));
				r.setRday(rs.getString("rday"));
				r.setUsein(rs.getInt("usein"));
				r.setUsewifi(rs.getInt("usewifi"));
				r.setUsenavi(rs.getInt("usenavi"));
				r.setUseseat(rs.getInt("useseat"));
				list.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}
	
	public void addCarReserve(Reservation r) {
		getConnect();
		String sql = "insert into carreserve values(null,?,?,?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, r.getNo());
			ps.setString(2, r.getId());
			ps.setInt(3, r.getQty());
			ps.setInt(4, r.getDday());
			ps.setString(5, r.getRday());
			ps.setInt(6, r.getUsein());
			ps.setInt(7, r.getUsewifi());
			ps.setInt(8, r.getUsenavi());
			ps.setInt(9, r.getUseseat());
			
			if(ps.executeUpdate() > 0) {
				// 업데이트 메서드 만들어서 넣기( qty 수정해야함)
				System.out.println("차량 예약 완료");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
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
