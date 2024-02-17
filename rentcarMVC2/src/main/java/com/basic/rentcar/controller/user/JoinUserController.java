package com.basic.rentcar.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.rentcar.dao.UserDAO;
import com.basic.rentcar.frontController.Controller;
import com.basic.rentcar.util.alertUtil;
import com.basic.rentcar.vo.User;

public class JoinUserController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String hobby = request.getParameter("hobby");
		String job = request.getParameter("job");
		String age = request.getParameter("age");
		String info = request.getParameter("info");
		
		if(request.getParameter("id") == null) {
			System.out.println("회원 가입하러 jsp로 이동");
			return "user/join";
		} else {
			User u = new User(0, id, pw, email, tel, hobby, job, age, info) ;
			int cnt = UserDAO.getInstance().joinUser(u);
			
			String ctx = request.getContextPath();
			if(cnt == 0) {
				System.out.println("회원 가입 실패 ");
				alertUtil.alertAndBack(response, "회원가입 실패");
//				return "user/join";
				return null;
			} else {
				System.out.println("회원 가입 성공 ");
				alertUtil.alertAndGo(response, "회원가입 성공", ctx+"/main.do");
//				return "main";
				return null;
			}
		}
		
		//int cnt = UserDAO.getInstance().insertUser(id, pw, email, tel, hobby, job, age, info);
		
		
	}

}
