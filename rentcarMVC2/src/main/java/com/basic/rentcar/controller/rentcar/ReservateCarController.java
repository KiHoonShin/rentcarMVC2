package com.basic.rentcar.controller.rentcar;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.dao.ReservationDAO;
import com.basic.rentcar.frontController.Controller;
import com.basic.rentcar.vo.Reservation;

public class ReservateCarController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		int dday = Integer.parseInt(request.getParameter("dday"));
		int price = Integer.parseInt(request.getParameter("price"));
		String img = request.getParameter("img");
		
		int usein = Integer.parseInt(request.getParameter("usein"));
		int usewifi = Integer.parseInt(request.getParameter("usewifi"));
		int useseat = Integer.parseInt(request.getParameter("useseat"));
		
		usein = usein == 1 ? 10000 : 0;
		usewifi = usewifi == 1 ? 10000 : 0;
		useseat = useseat == 1 ? 10000 : 0;
		
		System.out.println("usein = " + usein + "  usewifi = " + usewifi + "  useseat = " + useseat);
		
		int totalCar = price * qty * dday;
		
		int totalOption = qty * dday * (usein + usewifi + useseat);
		
		int totalPrice = totalCar + totalOption;
		
		System.out.println("totalcar = " + totalCar + "  totalOption = " +totalOption
				+ "  totalPrice = " + totalPrice);
		
		request.setAttribute("totalCar", totalCar);
		request.setAttribute("totalOption", totalOption);
		request.setAttribute("totalPrice", totalPrice);
		request.setAttribute("img", img);
		
		// 여기서 reserveCar sql 추가해야함
		
		return "rentcar/carReserveResult";
	}

}
