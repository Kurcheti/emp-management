package com.emp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emp.dao.EmployeeDAO;
import com.emp.dao.EmployeeDAOImpl;
import com.emp.model.Employee;
import com.emp.utility.PasswordEncrptDecrptUtility;

@WebServlet("/employee")
public class EmployeeController extends HttpServlet {
	RequestDispatcher rd = null;
	String secret = "empManagement";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getParameter("action");
		if (action.equals("signup")) {
			
			rd = req.getRequestDispatcher("WEB-INF/signUp.jsp");
			rd.forward(req, resp);
			
		} else {
			HttpSession session = req.getSession();
			if (session != null && session.getAttribute("userName") != null
					&& session.getAttribute("password") != null) {
				req.setAttribute("enableLogout", true);
				rd = req.getRequestDispatcher("WEB-INF/emplist.jsp");
				rd.forward(req, resp);
			} else {
				req.setAttribute("sessionExpired", "Session Expired login again");
				rd = req.getRequestDispatcher("index.jsp");
				rd.forward(req, resp);
			}
		}

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		PasswordEncrptDecrptUtility encrptDecrptUtility = new PasswordEncrptDecrptUtility();
		
		//read the from values
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String gender = req.getParameter("gender");
		String country = req.getParameter("country");
		String state = req.getParameter("state");
		String address = req.getParameter("address");
		String password = req.getParameter("password");
		
		//create Employee model object and set the values
		Employee employee = new Employee();
		employee.setName(name);
		employee.setEmail(email);
		employee.setMobile(mobile);
		employee.setGender(gender);
		employee.setCountry(country);
		employee.setState(state);
		employee.setAddress(address);
		employee.setPassword(encrptDecrptUtility.encrypt(password, secret));
		
		boolean isEmpolyeeCreated = employeeDAO.createEmployee(employee);
		if(isEmpolyeeCreated) {
			rd = req.getRequestDispatcher("index.jsp");
			req.setAttribute("empCreatedMessage", "Emplyee "+name+" created SuccessFully");
			rd.forward(req, resp);
		}else {
			rd = req.getRequestDispatcher("index.jsp");
			req.setAttribute("empCreationFailedMessage", "Emplyee creation failed, Please try again");
			rd.forward(req, resp);
		}
		
		

	}
}
