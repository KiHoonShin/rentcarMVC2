package com.basic.rentcar.controller.rentcar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.rentcar.dao.RentCarDAO;
import com.basic.rentcar.frontController.Controller;
import com.basic.rentcar.vo.Rentcar;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.annotation.MultipartConfig;

public class InsertCarController implements Controller{
	
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		String saveDirectory = request.getServletContext().getRealPath("/Uploads");
//		System.out.println("saveDir = " + saveDirectory);
//		
//		Path saveDirPath = Paths.get(saveDirectory);
//		if (!Files.isDirectory(saveDirPath)) {
//			Files.createDirectories(saveDirPath);
//		}
//		
//		MultipartRequest multi = new MultipartRequest(request, saveDirPath.toString(), 5 * 1024 * 1024, "UTF-8",
//				new DefaultFileRenamePolicy());
//		if(multi.getParameter("name") == null) {
//			System.out.println("name 못받아");
//			return "rentcar/registerCar";
//		}
//
//		String img = null;
//		if (multi.getFilesystemName("uploadFile") != null) {
//			img = multi.getFilesystemName("uploadFile");// 실제 서버에 올라간 파일이름
//
//			String fileType = multi.getContentType("uploadFile"); // 파일의 타입 .txt , jpg , .png
//			System.out.println("fileType= " + fileType);
//
//		}
		request.setCharacterEncoding("utf-8");
		return "rentcar/registerCar";
//		if(request.getParameter("img") == null) {
//			System.out.println("아직 이미지 없음");
//			return "rentcar/registerCar";
////		}
//		System.out.println("insert.do 넘어옴");
//		String img = request.getParameter("img");
//		System.out.println("insert : img = " + img);
		
//		if(request.getParameter("name") == null) {
//		System.out.println("name 못받아옴");
//		return "rentcar/registerCar";
//	}
		
//		String name = request.getParameter("name");
//		int category = Integer.parseInt(request.getParameter("category"));
//		int price = Integer.parseInt(request.getParameter("price"));
//		int usepeople = Integer.parseInt(request.getParameter("usepeople"));
//		int total_qty = Integer.parseInt(request.getParameter("total_qty"));
//		String company = request.getParameter("company");
//		
//		String info = request.getParameter("info");
//		
//		Rentcar r = new Rentcar(name, category, price, usepeople, total_qty, company, img, info);
//		RentCarDAO.getInstance().insertCar(r);
//		
//		String ctx = request.getContextPath();
//		return "redirect:"+ctx+"/main.do";
	}
}
