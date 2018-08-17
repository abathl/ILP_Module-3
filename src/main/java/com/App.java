package com;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/App")
public class App extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2321591142814867516L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Print URL
		/*
		String uri = request.getRequestURI();
		PrintWriter pw = response.getWriter();
		pw.println("URI:\n" + uri + "\n");
		// Get User and Action from URI
		String[] uriInfo = RouterHelper.getUserAndAction(uri);
		String user = uriInfo[0];
		String action = uriInfo[1];
		pw.println("User:\n" + user + "\n");
		pw.println("Action:\n" + action + "\n");
		if (RouterHelper.validateUserType(user, request)) {
			switch (user) {
			case "customer":
				pw.println("Inside Customer Case");
				CustomerRoutes.perform(action, request, response);
			case "manager":
				pw.println("Inside Manager Case");
				CustomerRoutes.perform(action, request, response);
			case "admin":
				pw.println("Inside Admin Case");
				CustomerRoutes.perform(action, request, response);
			}
		}
		else 
			pw.println("User access not granted.");
		*/
		String json = "";
		try {
			PolicyController pc = new PolicyController();
			json = pc.getPoliciesForManager(1);
		} catch (SQLException e) {
			
		}
		
		
		PrintWriter pw = response.getWriter();
		pw.print(json);

	}
}
