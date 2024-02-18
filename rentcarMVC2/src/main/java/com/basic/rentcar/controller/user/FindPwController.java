package com.basic.rentcar.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.rentcar.dao.UserDAO;
import com.basic.rentcar.frontController.Controller;
import com.basic.rentcar.util.alertUtil;

public class FindPwController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ctx = request.getContextPath();
		if(request.getParameter("id") == null) {
			return "user/findPw";
		}
		
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String password = UserDAO.getInstance().findPw(id, email);

		if(password == null) {
			alertUtil.alertAndBack(response, "id 혹은 email을 다시 입력하세요");
			return null;
		} 
		
		request.setAttribute("id", id);
		request.setAttribute("password", password);
		
		return "user/findPw";
	}

}
