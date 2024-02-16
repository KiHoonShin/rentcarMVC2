package com.basic.rentcar.controller.rentcar;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.dao.RentCarDAO;
import com.basic.rentcar.frontController.Controller;
import com.basic.rentcar.vo.Rentcar;

public class CarListController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String ctx = request.getContextPath();
		if(session.getAttribute("log") == null) {
			return "redirect:"+ctx+"/loginCheck.do";
		}
		ArrayList<Rentcar> mainImgList = RentCarDAO.getInstance().mainRentCarListImg();
		request.setAttribute("mainImgList", mainImgList);
		
		ArrayList<Rentcar> allRentcarList = RentCarDAO.getInstance().allRentcarList();
		request.setAttribute("allRentcarList", allRentcarList);
		if(request.getParameter("search")!= null) {
			String search = request.getParameter("search");
			System.out.println("search = " + search);
			request.setAttribute("search", search);
		}
		
		if(request.getParameter("category") != null) {
		int category = Integer.parseInt(request.getParameter("category"));
		String temp = "";
		if(category == 1) {
			temp = "소형";
		} else if(category == 2){
			temp = "중형";
		} else {
			temp = "대형";
		}
		ArrayList<Rentcar> categoryCar = RentCarDAO.getInstance().getCategoryCar(category);
		
		int count = categoryCar.size();
		
		System.out.println("category = " + category + "  temp = " + temp + " count = " +count);
		
		request.setAttribute("temp", temp);
		request.setAttribute("count", count);
		request.setAttribute("categoryCar", categoryCar);
		}
		return "rentcar/reserveCarView";
	}

}
