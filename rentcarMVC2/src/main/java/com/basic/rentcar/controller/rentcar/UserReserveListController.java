package com.basic.rentcar.controller.rentcar;

import java.io.IOException;
import java.util.ArrayList;

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

public class UserReserveListController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ctx = request.getContextPath();
		HttpSession session = request.getSession();
		if(session.getAttribute("log") == null) {
			alertUtil.alertAndGo(response, "로그인 후 이용 가능합니다", ctx+"/logInOut.do");
//			return "user/login";
			return null;
		}
		
		String id = (String)session.getAttribute("log");
		
		ArrayList<Reservation> list = ReservationDAO.getInstance().getReserveList(id);
		int size = list.size();
		request.setAttribute("size", size);
		System.out.println("size = " + size);
		request.setAttribute("list", list); // 예약 리스트
		
		ArrayList<Rentcar> rentcarList = RentCarDAO.getInstance().allRentcarList();
		
		request.setAttribute("rentcarList", rentcarList); //렌트카 리스트
		
		return "rentcar/userReserveList";
		
	}

}
