package com.basic.rentcar.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.dao.UserDAO;
import com.basic.rentcar.frontController.Controller;

public class LoginCheckController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
			
			String ctx = request.getContextPath();
			
			System.out.println("로그인체크 들림");
//			if(session.getAttribute("log") == null) {
//				//request.setAttribute("center", "login");
//				return "redirect:"+ctx+"/logInOut.do";
//			} else {
//				session.removeAttribute("log");
//			}
			String id = request.getParameter("id");
			String data = UserDAO.getInstance().isValidId(id) ? "notValid" : "valid";
			
			response.getWriter().print(data);
			
			return null;
	}

}
