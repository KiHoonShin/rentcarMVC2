package com.basic.rentcar.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.rentcar.dao.UserDAO;
import com.basic.rentcar.frontController.Controller;
import com.basic.rentcar.vo.User;

public class JoinUserController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 회원가입 클릭시 여기로 넘어와서, 입력받은 값이 없다면 회원가입.jsp로 이동
		// 다 입력 후 회원가입 버튼 클릭 -> 다시 여기로 넘어오기
		// 입력 받은 값들을 member에 insert하여 인원 추가하기
		/*
		 * if(request.getParameter("id") == null) { //이거 말고 userdao 에서 int값 받아오고 그게 -면
		 * 다시 되돌아가기 }
		 */
		
		
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
				return "user/join";
			} else {
				System.out.println("회원 가입 성공 ");
				return "main";
			}
		}
		
		//int cnt = UserDAO.getInstance().insertUser(id, pw, email, tel, hobby, job, age, info);
		
		
	}

}
