package com.basic.rentcar.controller.rentcar;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.dao.RentCarDAO;
import com.basic.rentcar.dao.ReservationDAO;
import com.basic.rentcar.frontController.Controller;
import com.basic.rentcar.util.alertUtil;
import com.basic.rentcar.vo.Rentcar;
import com.basic.rentcar.vo.Reservation;

public class ReservateCarController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String ctx = request.getContextPath();
		HttpSession session = request.getSession();
		if(session.getAttribute("log") == null) {
			alertUtil.alertAndGo(response, "로그인 후 이용 가능합니다", ctx+"/logInOut.do");
			return null;
		}
		
		// 렌트 금액 구하기
		int no = Integer.parseInt(request.getParameter("no"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		int dday = Integer.parseInt(request.getParameter("dday"));
		int price = Integer.parseInt(request.getParameter("price"));
		String img = request.getParameter("img");
		
		String rday = request.getParameter("rday");
		// 날짜 구해서 비교하기
		Date nowDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		try {
			nowDate = sdf.parse(sdf.format(nowDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("nowDate = " + nowDate);
		
		Date d2 = new Date();
		try {
			d2 = sdf.parse(rday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		boolean result = d2.before(nowDate);
		if(result) {
			System.out.println("선택한 날짜가 현재보다 이전임");
			alertUtil.alertAndBack(response, "현재 날짜 이후로 선택해주세요");
			return null;
		} else {
			System.out.println("선택한 날짜가 현재보다 이후임");
		}
		
		int usein = Integer.parseInt(request.getParameter("usein"));
		int usewifi = Integer.parseInt(request.getParameter("usewifi"));
		int usenavi = Integer.parseInt(request.getParameter("usenavi"));
		int useseat = Integer.parseInt(request.getParameter("useseat"));
		
		int useinPrice;
		int usewifiPrice;
		int useseatPrice;
		useinPrice = usein == 1 ? 10000 : 0;
		usewifiPrice = usewifi == 1 ? 10000 : 0;
		useseatPrice = useseat == 1 ? 10000 : 0;
		
		System.out.println("usein = " + useinPrice + "  usewifi = " + usewifiPrice + "  useseat = " + useseatPrice);
		
		int totalCar = price * qty * dday;
		
		int totalOption = qty * dday * (useinPrice + usewifiPrice + useseatPrice);
		
		int totalPrice = totalCar + totalOption;
		
		System.out.println("totalcar = " + totalCar + "  totalOption = " +totalOption
				+ "  totalPrice = " + totalPrice);
		
		request.setAttribute("totalCar", totalCar);
		request.setAttribute("totalOption", totalOption);
		request.setAttribute("totalPrice", totalPrice);
		request.setAttribute("img", img);
		
		// 여기서 reserveCar sql 추가해야함
		
		// car reserve sql에 값 넣기
		String id = (String)session.getAttribute("log");
		
		Reservation r = new Reservation(no, id, qty, dday, rday, usein, usewifi, usein, useseat);
		
		ReservationDAO.getInstance().addCarReserve(r);
		
		Rentcar rentcar = RentCarDAO.getInstance().getOneRentcarInfo(no);
		// 현재 총 수량에서 대여 수량 차감하기
		int totalQTY = rentcar.getTotal_qty();
		System.out.println("총 수량 = " + totalQTY);
		//int delQTY = totalQTY-qty;
		// 업데이트 쿼리 만들기.
		RentCarDAO.getInstance().updateRentCarQty(no, qty);
		
		//System.out.println("차감 후 수량 = " + delQTY);
		
		
		
		return "rentcar/carReserveResult";
	}

}
