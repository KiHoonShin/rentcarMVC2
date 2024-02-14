package com.basic.rentcar.frontController;

import java.util.HashMap;

import com.basic.rentcar.controller.rentcar.CarInfoController;
import com.basic.rentcar.controller.rentcar.CarListController;
import com.basic.rentcar.controller.rentcar.DeleteResController;
import com.basic.rentcar.controller.rentcar.ReservateCarController;
import com.basic.rentcar.controller.rentcar.SelectCarOptionController;
import com.basic.rentcar.controller.rentcar.UploadCarImgController;
import com.basic.rentcar.controller.rentcar.UserReserveListController;
import com.basic.rentcar.controller.user.JoinUserController;
import com.basic.rentcar.controller.user.LoginCheckController;
import com.basic.rentcar.controller.user.LoginOutController;
import com.basic.rentcar.controller.user.MainController;

public class HandlerMapping {
	private HashMap<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		
		mappings.put("/main.do", new MainController());
		mappings.put("/loginCheck.do", new LoginCheckController());
		mappings.put("/logInOut.do", new LoginOutController());
		mappings.put("/uploadCarImg.do", new UploadCarImgController());
		mappings.put("/carInfo.do", new CarInfoController());
		mappings.put("/carList.do", new CarListController());
		mappings.put("/carOption.do", new SelectCarOptionController());
		mappings.put("/carReserve.do", new ReservateCarController());
		mappings.put("/joinUser.do", new JoinUserController());
		mappings.put("/viewReserve.do", new UserReserveListController());
		mappings.put("/deleteCar.do", new DeleteResController());
		
	}
	
	public Controller getController(String key) {
		return mappings.get(key);
	}
	
}
