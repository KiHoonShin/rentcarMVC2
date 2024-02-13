package com.basic.rentcar.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.frontController.Controller;

public class MainController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ctx = request.getContextPath();
		System.out.println(ctx);
		HttpSession session = request.getSession();
		System.out.println("현재 로그인 : " + session.getAttribute("log") );
		return "main";
	}

}
