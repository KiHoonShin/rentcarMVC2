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
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("log");
		session.removeAttribute("log");
		UserDAO.getInstance().deleteUser(id);
		
		String ctx = request.getContextPath();
		alertUtil.alertAndGo(response, "회원 탈퇴 완료", ctx+"/main.do");
//		return "redirect:"+ctx+"/main.do";
		return null;
	}

}
