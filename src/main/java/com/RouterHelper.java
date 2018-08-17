package com;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class RouterHelper {

	public static String[] getUserAndAction(String uri) {
		String[] result = new String[2];
		result[0] = uri.replaceFirst("/ClaimProcessing/", "").split("/")[0];
		result[1] = uri.replaceFirst("/ClaimProcessing/", "").split("/")[1];

		return result;
	}

	public static boolean validateUserType(String user, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("Role") != null) {
			String sessionUserType = (String) session.getAttribute("Role");
			switch (user) {
			case "customer":
				if (sessionUserType == "CU")
					return true;
				else
					return false;
			case "manager":
				if (sessionUserType == "MA")
					return true;
				else
					return false;
			case "admin":
				if (sessionUserType == "AD")
					return true;
				else
					return false;
			}
		}
		return true;
	}

}
