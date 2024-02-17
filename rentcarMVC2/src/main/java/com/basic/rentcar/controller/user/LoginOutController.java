package com.basic.rentcar.controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.dao.UserDAO;
import com.basic.rentcar.frontController.Controller;
import com.basic.rentcar.util.alertUtil;

public class LoginOutController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String ctx = request.getContextPath();
		
		if(session.getAttribute("log") != null) {
//			request.setAttribute("center", "/logInOut.do");
			// 로그아웃 시키기
			session.removeAttribute("log");
			System.out.println("로그아웃 성공");
//			return "redirect:"+ctx+"/main.do";
			alertUtil.alertAndGo(response, "로그아웃 성공", ctx+"/main.do");
			return null;
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
			System.out.println("비밀번호 오류");
			alertUtil.alertAndBack(response, "아이디와 비밀번호가 일치하지 않습니다");
//			return "user/login";
			return null;
		} 
		
		session.setAttribute("log", id);
		alertUtil.alertAndGo(response, "로그인 성공", ctx+"/main.do");
//		return "redirect:"+ctx+"/main.do";
		return null;
	}

}
