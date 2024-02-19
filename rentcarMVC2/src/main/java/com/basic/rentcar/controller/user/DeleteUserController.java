package com.basic.rentcar.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.dao.UserDAO;
import com.basic.rentcar.frontController.Controller;
import com.basic.rentcar.util.alertUtil;

public class DeleteUserController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("password") == null) {
			return "/user/deleteUser";
		}
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("log");
		
		String password = request.getParameter("password");
		String dbPw = UserDAO.getInstance().deleteCheckPw(id);
		if(!password.equals(dbPw)) {
			alertUtil.alertAndBack(response, "비밀번호가 일치하지 않습니다");
			return null;
		}
		
		session.removeAttribute("log");
		UserDAO.getInstance().deleteUser(id);
		
		String ctx = request.getContextPath();
		alertUtil.alertAndGo(response, id +" 회원 탈퇴 완료", ctx+"/main.do");
//		return "redirect:"+ctx+"/main.do";
		return null;
	}

}
