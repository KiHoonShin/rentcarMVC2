package com.basic.rentcar.controller.rentcar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.dao.RentCarDAO;
import com.basic.rentcar.frontController.Controller;
import com.basic.rentcar.util.alertUtil;
import com.basic.rentcar.vo.Rentcar;

public class SelectCarOptionController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String ctx = request.getContextPath();
//		HttpSession session = request.getSession();
//		if(session.getAttribute("log") == null) {
//			alertUtil.alertAndGo(response, "로그인 후 이용 가능합니다", ctx+"/logInOut.do");
//			return null;
//		}
		
		
		int no = Integer.parseInt(request.getParameter("no"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		int price = Integer.parseInt(request.getParameter("price"));
		String img = request.getParameter("img");
		
		Rentcar vo = RentCarDAO.getInstance().getOneRentcarInfo(no);
		
		request.setAttribute("vo", vo);
		request.setAttribute("no", no);
		request.setAttribute("img", img);
		request.setAttribute("qty", qty);
		request.setAttribute("price", price);
		
		System.out.println("no = " +no + "  img = " + img +"  qty = " +qty);
		
		return "rentcar/carOption";
	}

}
