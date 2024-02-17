package com.basic.rentcar.controller.rentcar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.rentcar.dao.RentCarDAO;
import com.basic.rentcar.dao.ReservationDAO;
import com.basic.rentcar.frontController.Controller;
import com.basic.rentcar.util.alertUtil;
import com.basic.rentcar.vo.Rentcar;
import com.basic.rentcar.vo.Reservation;

public class DeleteResController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int reserve_seq = Integer.parseInt(request.getParameter("resSeq"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		int no = Integer.parseInt(request.getParameter("no"));
		
		ReservationDAO.getInstance().deleteReserveCar(reserve_seq);
		RentCarDAO.getInstance().backQty(qty, no);
		
		String ctx = request.getContextPath();
		
		Rentcar r = RentCarDAO.getInstance().getOneRentcarInfo(no);
		
		String carName = r.getName();
		
		alertUtil.alertAndGo(response, carName +" 차량 예약이 취소되었습니다", ctx+"/viewReserve.do");
//		return "redirect:"+ctx+"/viewReserve.do";
		return null;
	}

}
