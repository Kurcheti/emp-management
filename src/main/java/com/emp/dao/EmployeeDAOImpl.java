package com.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.emp.model.Employee;
import com.emp.utility.DBConnectionUtility;

public class EmployeeDAOImpl implements EmployeeDAO {
	private String EMP_CREATE_QUERY = "INSERT INTO EMPLOYEE (EMP_ID, EMP_NAME, EMP_MOB, EMP_MAIL, COUNTRY, STATE, ADDRESS, PASSWORD) "
									  + "VALUES (EMP_ID_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
	
	private String FETCH_ALL_EMPS = "SELECT EMP_ID, EMP_MOB, EMP_MAIL, COUNTRY FROM EMPLOYEE";
	
	private String DELETE_EMP_BY_ID = "DELETE FROM EMPMNG.EMPLOYEE WHERE EMP_ID = ?";
	
	PreparedStatement preparedStatementObj;
	long count = 0;
	Connection connection = null;
	
	@Override
	public boolean createEmployee(Employee employee) {
		
		try {
			//get DB Connection obj
			 connection = DBConnectionUtility.getDBConnection();
			
			//create prepared statement
			if(connection != null) {
				PreparedStatement preparedStatementObj = connection.prepareStatement(EMP_CREATE_QUERY);
				if(preparedStatementObj != null) {
					preparedStatementObj.setString(1, employee.getName());
					preparedStatementObj.setString(2, employee.getMobile());
					preparedStatementObj.setString(3, employee.getEmail());
					preparedStatementObj.setString(4, employee.getCountry());
					preparedStatementObj.setString(5, employee.getState());
					preparedStatementObj.setString(6, employee.getAddress());
					preparedStatementObj.setString(7, employee.getPassword());
					count = preparedStatementObj.executeLargeUpdate();
				}
			}
			
		} catch (SQLException sqe) {
			sqe.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
		return count >= 1 ? true : false;
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> empList = new ArrayList<>();
		try {
			connection = DBConnectionUtility.getDBConnection();
			if(connection!=null) {
				preparedStatementObj = connection.prepareStatement(FETCH_ALL_EMPS);
				ResultSet resultSet = preparedStatementObj.executeQuery();
				if(resultSet !=null) {
					while (resultSet.next()) {
						Employee employee = new Employee();
						employee.setEmpId(resultSet.getLong(1));
						employee.setName(resultSet.getString(2));
						employee.setMobile(resultSet.getString(3));
						employee.setCountry(resultSet.getString(4));
						empList.add(employee);
						
					}
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empList;
	}
	
	@Override
	public boolean deleEmployeeById(String empId) {
		long count = 0;
		try {
			 connection = DBConnectionUtility.getDBConnection();
			 if(connection != null) {
				 preparedStatementObj = connection.prepareStatement(DELETE_EMP_BY_ID);
				 if(preparedStatementObj != null) {
					 preparedStatementObj.setString(1, empId);
					 count = preparedStatementObj.executeUpdate();
				 }
			 }
		} catch (Exception e) {
			// TODO: handle exception
		}
		return count>=1 ? true : false;
	}

}
