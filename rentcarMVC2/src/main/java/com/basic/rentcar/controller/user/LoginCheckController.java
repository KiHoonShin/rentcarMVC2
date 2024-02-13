package com.basic.rentcar.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.frontController.Controller;

public class LoginCheckController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
			
			String ctx = request.getContextPath();
			return "redirect:"+ctx+"logInOut.do";
			// 로그인 체크 , 인 아웃을 어떻게 사용해야 좋을까.. 
			// 로그인 체크 통해서 다시 프론트 왔다갔다 해야 되나?
	}

}
