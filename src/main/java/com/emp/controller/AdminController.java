package com.emp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emp.dao.AdminDAO;
import com.emp.dao.AdminDAOImpl;
import com.emp.utility.PasswordEncrptDecrptUtility;

@WebServlet("/admin")
public class AdminController extends HttpServlet {
	String secret = "empManagement";
	RequestDispatcher rd = null;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session != null && session.getAttribute("userName") != null && session.getAttribute("password") != null) {
			session.invalidate();
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// read user name and password from the from the login form
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");

		// convert password to encrypted format
		PasswordEncrptDecrptUtility passwordEncrptDecrptUtility = new PasswordEncrptDecrptUtility();
		String encryptedPassword = passwordEncrptDecrptUtility.encrypt(password, secret);

		// check userName and password correct or not from DB
		AdminDAO adminDAO = new AdminDAOImpl();
		boolean isValidAdmin = adminDAO.isValidAdmin(userName, encryptedPassword);
		if (isValidAdmin) {
			HttpSession session = req.getSession();
			session.setAttribute("userName", userName);
			session.setAttribute("password", encryptedPassword);
			// RequestDispatcher rd = req.getRequestDispatcher("employee");
			resp.sendRedirect("employee");
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			req.setAttribute("invalidUsernameOrPassword", "Invalid User Name or Password");
			rd.forward(req, resp);
		}

	}
}
