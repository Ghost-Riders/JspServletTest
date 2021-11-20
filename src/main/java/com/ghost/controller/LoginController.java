package com.ghost.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ghost.service.RegistrationService;
import com.ghost.serviceimpl.RegistrationServiceImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession httpSession = request.getSession(false);

		if (httpSession == null) {
//			httpSession = request.getSession();
//			System.out.println(httpSession.getCreationTime() + "\t" + httpSession);
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);

		} else {
			String username = (String) httpSession.getAttribute("username");
//			
//			if (httpSession.isNew()) {
//				System.out.println(httpSession.isNew());
			RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
			rd.forward(request, response);
//			} else {
//				RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
//				rd.forward(request, response);
//			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		RegistrationService rs = new RegistrationServiceImpl();

		if (rs.getAuthenticate(userName, password)) {
			RequestDispatcher rd = null;
			if (rs.getUserStatus(userName)) {
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("username", userName);
				rd = request.getRequestDispatcher("welcome.jsp");
				
			} else {
				rd = request.getRequestDispatcher("unathorized.jsp");
			}
			HttpSession httpSession = request.getSession();

			// request.setAttribute("username", userName);
			httpSession.setAttribute("username", userName);
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}

//		doGet(request, response);
	}

}
