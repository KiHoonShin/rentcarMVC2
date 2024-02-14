package com.basic.rentcar.controller.rentcar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.rentcar.dao.RentCarDAO;
import com.basic.rentcar.frontController.Controller;
import com.basic.rentcar.vo.Rentcar;

public class SelectCarOptionController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
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
