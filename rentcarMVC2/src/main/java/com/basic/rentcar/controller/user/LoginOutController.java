package com.basic.rentcar.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.dao.UserDAO;
import com.basic.rentcar.frontController.Controller;

public class LoginOutController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String ctx = request.getContextPath();
		
		if(session.getAttribute("log") != null) {
//			request.setAttribute("center", "/logInOut.do");
			return "main";
		}
		
		if(request.getParameter("id") == null) {
			return "user/login";
		}
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("id = " + id + "  pw = " + pw);
		String dbPw = UserDAO.getInstance().checkingId(id);
		System.out.println("dbPw = " + dbPw);
		if(dbPw == null || dbPw.equals(pw) == false) {
			return "redirect:"+ctx+"/loginCheck.do";
		} 
		
		session.setAttribute("log", id);
		
		return "redirect:"+ctx+"/main.do";
	}

}
