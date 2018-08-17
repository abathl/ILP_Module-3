package com;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomerRoutes {

	public static void perform(String action, HttpServletRequest request, HttpServletResponse response) {
		switch(action) {
		case "post-claim":
			break;
		case "get-claims":
			break;
		default:
			break;
		}
	}
}
