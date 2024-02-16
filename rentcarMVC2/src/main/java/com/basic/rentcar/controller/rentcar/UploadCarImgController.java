package com.basic.rentcar.controller.rentcar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.dao.RentCarDAO;
import com.basic.rentcar.frontController.Controller;
import com.basic.rentcar.vo.Rentcar;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class UploadCarImgController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		String saveDirectory = request.getServletContext().getRealPath("/img");
		String saveDirectory = "C:\\rentcarMVC2\\rentcarMVC2\\src\\main\\webapp\\img";
		System.out.println("saveDir = " + saveDirectory);
		
		Path saveDirPath = Paths.get(saveDirectory);
		if (!Files.isDirectory(saveDirPath)) {
			Files.createDirectories(saveDirPath);
		}
		
		
		MultipartRequest multi = new MultipartRequest(request, saveDirPath.toString(), 5 * 1024 * 1024, "UTF-8",
				new DefaultFileRenamePolicy());

		String img = null;
		if (multi.getFilesystemName("uploadFile") != null) {
			img = multi.getFilesystemName("uploadFile");// 실제 서버에 올라간 파일이름
//			img = multi.getOriginalFileName("uploadFile");
			String fileType = multi.getContentType("uploadFile"); // 파일의 타입 .txt , jpg , .png
			System.out.println("fileType= " + fileType);
		}
		
		System.out.println("img = " + img);
//		
//		String info = multi.getParameter("info");
//		System.out.println("info = " + info);
		
		String ctx = request.getContextPath();
//		return "redirect:"+ctx+"/insertCar.do";
		
		
		String name = multi.getParameter("name");
		int category = Integer.parseInt(multi.getParameter("category"));
		int price = Integer.parseInt(multi.getParameter("price"));
		int usepeople = Integer.parseInt(multi.getParameter("usepeople"));
		int total_qty = Integer.parseInt(multi.getParameter("total_qty"));
		String company = multi.getParameter("company");
		String info = multi.getParameter("info");
		
		Rentcar r = new Rentcar(name, category, price, usepeople, total_qty, company, img, info);
		RentCarDAO.getInstance().insertCar(r);
		
		return "redirect:"+ctx+"/main.do";
	}
	
}
