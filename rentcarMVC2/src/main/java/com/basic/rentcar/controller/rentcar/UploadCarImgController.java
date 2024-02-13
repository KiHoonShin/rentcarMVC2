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

public class UploadCarImgController implements Controller{

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
		return "rentcar/reserveCarView";
	}
	
}
