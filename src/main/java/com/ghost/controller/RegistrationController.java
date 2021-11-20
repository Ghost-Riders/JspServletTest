package com.ghost.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ghost.model.Registration;
import com.ghost.service.RegistrationService;
import com.ghost.service.UserStatus;
import com.ghost.serviceimpl.RegistrationServiceImpl;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/registration")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Registration registry = new Registration();
		registry.setName(name);
		registry.setUserName(username);
		registry.setPassword(password);
		registry.setUserStatus(UserStatus.INACTIVE);

		System.out.println("name: " + name + "\tusername: " + username + "\tpassword: " + password + "/tUserStatus: "
				+ registry.getUserStatus());

		PrintWriter out = response.getWriter();
		// activation status by admin
		RegistrationService rs = new RegistrationServiceImpl();
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.include(request, response);
		//
		if (rs.saveRegistry(registry)) {
			out.append("<p>User Registered Successfully, please contact to admin for activation</p>");
		} else {
			out.append("<p>User Registery Failed, please try again</p>");
		}

	}

}
