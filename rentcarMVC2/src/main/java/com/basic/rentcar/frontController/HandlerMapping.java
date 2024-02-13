package com.basic.rentcar.frontController;

import java.util.HashMap;

import com.basic.rentcar.controller.user.LoginCheckController;
import com.basic.rentcar.controller.user.LoginOutController;
import com.basic.rentcar.controller.user.MainController;

public class HandlerMapping {
	private HashMap<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		
		mappings.put("/main.do", new MainController());
		mappings.put("loginCheck.do", new LoginCheckController());
		mappings.put("logInOut.do", new LoginOutController());
		
	}
	
	public Controller getController(String key) {
		return mappings.get(key);
	}
	
}
