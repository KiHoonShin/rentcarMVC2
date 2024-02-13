package com.basic.rentcar.frontController;

public class ViewResolver {
	public static String makeView(String nextPage) {
//		return "/WEB-INF/rentcar/" + nextPage + ".jsp";
		if(nextPage == "main") {
			return "/WEB-INF/" + nextPage + ".jsp";
		} else {
			return "/WEB-INF/user/" + nextPage + ".jsp";
		}
	}
}
