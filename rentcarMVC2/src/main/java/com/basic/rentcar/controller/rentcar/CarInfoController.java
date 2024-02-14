package com.basic.rentcar.controller.rentcar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.rentcar.dao.RentCarDAO;
import com.basic.rentcar.frontController.Controller;
import com.basic.rentcar.vo.Rentcar;

public class CarInfoController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int num = -1;
		if(request.getParameter("no") == null) {
			return "main";
		}
		
		num = Integer.parseInt(request.getParameter("no"));
		Rentcar vo = RentCarDAO.getInstance().getOneRentcarInfo(num);
		if(vo.getTotal_qty() < 1) {
			System.out.println("이 차량은 모두 대여중입니다.");
			return "main";
		}
		request.setAttribute("vo", vo);
		
		int category = vo.getCategory();
		String temp = "";
		if(category == 1) {
			temp = "소형";
		} else if(category == 2) {
			temp = "중형";
		} else {
			temp = "대형";
		}
		
		request.setAttribute("temp", temp);
		
		return "rentcar/rentcarInfo";
	}

}
